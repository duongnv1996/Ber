package com.umberapp.umber.utils;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.text.util.Linkify;

import com.wdullaer.materialdatetimepicker.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import me.zhanghai.android.materialprogressbar.BuildConfig;

public class TextUtils {
    public static boolean isEmailValid(String email) {
        if (Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$", 2).matcher(email).matches()) {
            return true;
        }
        return false;
    }

    public static int getWordCount(String str) {
        int i = 0;
        for (int j = 0; j < str.length(); j++) {
            int k = Character.codePointAt(str, j);
            if (k <= 0 || k > Utils.SELECTED_ALPHA_THEME_DARK) {
                i += 2;
            } else {
                i++;
            }
        }
        return i;
    }

    public static String parseTimestampToYMD(String input) {
        try {
            return new SimpleDateFormat(StringUtil.DATE_FORMAT_1).format(new SimpleDateFormat(StringUtil.DATE_FORMAT_27).parse(input));
        } catch (Exception ex) {
            ex.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static String parseTimestampToMMMDY(String input) {
        try {
            return new SimpleDateFormat(StringUtil.DATE_FORMAT_6).format(new SimpleDateFormat(StringUtil.DATE_FORMAT_27).parse(input));
        } catch (Exception ex) {
            ex.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static String getStringTimeFromLong(long date, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        return formater.format(cal.getTime());
    }

    public static Spannable linkifyHtml(String html, int linkifyMask) {
        Spanned text = Html.fromHtml(html);
        URLSpan[] currentSpans = (URLSpan[]) text.getSpans(0, text.length(), URLSpan.class);
        SpannableString buffer = new SpannableString(text);
        Linkify.addLinks(buffer, linkifyMask);
        for (URLSpan span : currentSpans) {
            buffer.setSpan(span, text.getSpanStart(span), text.getSpanEnd(span), 0);
        }
        return buffer;
    }
}
