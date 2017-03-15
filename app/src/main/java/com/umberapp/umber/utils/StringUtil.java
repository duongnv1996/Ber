package com.umberapp.umber.utils;

import android.app.Activity;
import android.database.DatabaseUtils;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import me.zhanghai.android.materialprogressbar.BuildConfig;

public class StringUtil {
    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_10 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT_11 = "dd MMMM, 'kl' HH:mm";
    public static final String DATE_FORMAT_12 = "dd MMM";
    public static final String DATE_FORMAT_13 = "dd MMM, 'kl' HH:mm";
    public static final String DATE_FORMAT_14 = "dd MMM yyyy";
    public static final String DATE_FORMAT_15 = "d-MMM";
    public static final String DATE_FORMAT_16 = "hh:mm";
    public static final String DATE_FORMAT_17 = "dd MMMM";
    public static final String DATE_FORMAT_18 = "HH:mm";
    public static final String DATE_FORMAT_19 = "MMMM";
    public static final String DATE_FORMAT_2 = "MMM yyyy";
    public static final String DATE_FORMAT_20 = "MM";
    public static final String DATE_FORMAT_21 = "yyyy-MM-dd HH:mm:ss Z";
    public static final String DATE_FORMAT_22 = "MMMM yyyy";
    public static final String DATE_FORMAT_23 = "MM/yy";
    public static final String DATE_FORMAT_24 = "dd/MM";
    public static final String DATE_FORMAT_25 = "d MMM yyyy";
    public static final String DATE_FORMAT_26 = "EEEE dd MMMM";
    public static final String DATE_FORMAT_27 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT_3 = "MMM dd, yyyy h:mm a";
    public static final String DATE_FORMAT_4 = "MMM dd, yyy";
    public static final String DATE_FORMAT_5 = "h:mm a";
    public static final String DATE_FORMAT_6 = "MMMM dd, yyyy";
    public static final String DATE_FORMAT_7 = "MM/dd/yyyy";
    public static final String DATE_FORMAT_8 = "dd MMM HH:mm";
    public static final String DATE_FORMAT_9 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String HTML_TAG_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
    public static final String TIMESTAMP_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date convertStringToDate(String time, String format) {
        Date date = null;
        try {
            return new SimpleDateFormat(format).parse(time);
        } catch (ParseException e) {
            return date;
        }
    }

    public static String convertDateToString(Date date, String format) {
        String strDate = null;
        try {
            strDate = new SimpleDateFormat(format, Locale.ENGLISH).format(date);
        } catch (IllegalArgumentException e) {
        }
        return strDate;
    }

    public static String convertDateToStringGMT(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String strDate = null;
        try {
            strDate = dateFormat.format(date);
        } catch (IllegalArgumentException e) {
        }
        return strDate;
    }

    public static String convertDateToString(Date date, String format, Locale locale) {
        String strDate = null;
        try {
            strDate = new SimpleDateFormat(format, locale).format(date);
        } catch (IllegalArgumentException e) {
        }
        return strDate;
    }

    public static Calendar convertStringToCalendar(String time, String format) {
        Calendar calendar = null;
        try {
            Date date = new SimpleDateFormat(format).parse(time);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            return calendar;
        }
    }

    public static String convertCalendarToString(Calendar calendar, String format) {
        String strDate = null;
        try {
            strDate = new SimpleDateFormat(format).format(calendar.getTime());
        } catch (IllegalArgumentException e) {
        }
        return strDate;
    }

    public static Timestamp convertStringToTimeStamp(String time, String format) {
        try {
            return new Timestamp(new SimpleDateFormat(format).parse(time).getTime());
        } catch (ParseException e) {
            return new Timestamp(Calendar.getInstance().getTime().getTime());
        }
    }

    public static String convertNowToString(String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        dateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateformat.format(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());
    }

    public static String convertNowToTimeStampString(String format) {
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
    }

    public static boolean isEmpty(EditText editText) {
        if (editText == null || editText.getEditableText() == null || editText.getEditableText().toString().trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static String sqlQuote(String string) {
        string = DatabaseUtils.sqlEscapeString(string.trim());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        return stringBuffer.toString();
    }

    public static String removeAllTagHtml(String html) {
        return Pattern.compile("</?[^>]+>").matcher(html).replaceAll(BuildConfig.FLAVOR);
    }

    public static String generateKey(String string) {
        char[] chars = string.toUpperCase().toCharArray();
        StringBuffer hex = new StringBuffer();
        for (char toHexString : chars) {
            hex.append(Integer.toHexString(toHexString));
        }
        return hex.toString();
    }

//    public static CharSequence convertHtmlFileToString(Activity activity, String fileName) {
//        CharSequence stringBuffer;
//        Throwable th;
//        BufferedReader bufferedReader = null;
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(activity.getAssets().open(fileName)));
//            try {
//                String line = BuildConfig.FLAVOR;
//                stringBuffer = new StringBuffer();
//                while (true) {
//                    line = in.readLine();
//                    if (line == null) {
//                        break;
//                    }
//                    stringBuffer.append(line);
//                }
//                if (in != null) {
//                    try {
//                        in.close();
//                    } catch (IOException e) {
//                    }
//                }
//                bufferedReader = in;
//            } catch (IOException e2) {
//                bufferedReader = in;
//                try {
//                    stringBuffer = BuildConfig.FLAVOR;
//                    if (bufferedReader != null) {
//                        try {
//                            bufferedReader.close();
//                        } catch (IOException e3) {
//                        }
//                    }
//                    return stringBuffer;
//                } catch (Throwable th2) {
//                    th = th2;
//                    if (bufferedReader != null) {
//                        try {
//                            bufferedReader.close();
//                        } catch (IOException e4) {
//                        }
//                    }
//                    throw th;
//                }
//            } catch (Throwable th3) {
//                th = th3;
//                bufferedReader = in;
//                if (bufferedReader != null) {
//                    bufferedReader.close();
//                }
//                throw th;
//            }
//        } catch (IOException e5) {
//            stringBuffer = BuildConfig.FLAVOR;
//            if (bufferedReader != null) {
//                bufferedReader.close();
//            }
//            return stringBuffer;
//        }
//        return stringBuffer;
//    }

    public static Date getLastModifiedDate(File file) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(file.lastModified());
        return calendar.getTime();
    }

    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getNameOfMonth(Calendar calendar) {
        return new SimpleDateFormat("MMM").format(calendar.getTime());
    }

    public static String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    }

    public static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static String getFileNameInUrl(String url) {
        if (url.length() == 0 || !url.contains("/")) {
            return BuildConfig.FLAVOR;
        }
        return url.substring(url.lastIndexOf(47) + 1, url.length());
    }

    public static String getFileNameWithoutExtensionInUrl(String url) {
        if (url.length() == 0 || !url.contains("/")) {
            return BuildConfig.FLAVOR;
        }
        String fileName = url.substring(url.lastIndexOf(47) + 1, url.length());
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    public static String getDurationTime(long duration) {
        StringBuilder builder = new StringBuilder();
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        duration -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(duration);
        duration -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration - TimeUnit.MINUTES.toMillis(minutes));
        if (days != 0) {
            builder.append(days + "d");
            builder.append(" ");
        }
        if (hours != 0) {
            builder.append(hours + "h");
            builder.append(" ");
        }
        if (minutes != 0) {
            builder.append(minutes + "m");
            builder.append(" ");
        }
        if (seconds != 0) {
        }
        return builder.toString();
    }

    public static String getCookie(String cookies, String cookieName) {
        String CookieValue = null;
        if (cookies == null) {
            return null;
        }
        for (String ar1 : cookies.split("(;)|(&)|(\")")) {
            if (ar1.contains(cookieName)) {
                CookieValue = ar1.split("=")[1];
            }
        }
        return CookieValue;
    }
}
