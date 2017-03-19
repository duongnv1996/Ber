package com.umberapp.umber.apis;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ItemAnimator;

import com.umberapp.umber.R;
import com.umberapp.umber.socket.SocketConstants;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.FileUtils;
import com.umberapp.umber.utils.RLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {
    public static Retrofit getRootApi() {
        return new Builder().baseUrl(ApiConstants.API_ROOT).client(new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static String getStatusFromServer(String st, Context context) {
        if (st.equals(SocketConstants.KEY_FINDING)) {
            return context.getString(R.string.finding);
        }
        if (st.equals(SocketConstants.KEY_CREATED)) {
            return context.getString(R.string.created);
        }
        if (st.equals(SocketConstants.KEY_ON_MY_WAY)) {
            return context.getString(R.string.on_way);
        }
        if (st.equals(SocketConstants.KEY_START)) {
            return context.getString(R.string.start);
        }
        if (st.equals(SocketConstants.STATUS_ORDER_ESTIMATED)) {
            return context.getString(R.string.estimated);
        }
        if (st.equals(SocketConstants.KEY_ARRIVED)) {
            return context.getString(R.string.arrived_);
        }
        if (st.equals(SocketConstants.KEY_SERVER_DECLINCE)) {
            return context.getString(R.string.server_declince);
        }
        if (st.equals(SocketConstants.STATUS_ORDER_DECLINE)) {
            return context.getString(R.string.decline);
        }
        if (st.equals(Constant.KEY_FINISH)) {
            return context.getString(R.string.finish_);
        }
        return context.getString(R.string.unknow);
    }

    public static File writeResponseBodyToDisk(ResponseBody body, Context context, String nameFile) {
        Throwable th;
        try {
            File futureStudioIconFile = new File(FileUtils.getFolder(context) + nameFile);
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                byte[] fileReader = new byte[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;
                inputStream = body.byteStream();
                OutputStream outputStream2 = new FileOutputStream(futureStudioIconFile);
                while (true) {
                    try {
                        int read = inputStream.read(fileReader);
                        if (read == -1) {
                            break;
                        }
                        outputStream2.write(fileReader, 0, read);
                        fileSizeDownloaded += (long) read;
                        RLog.m85d("file download: " + fileSizeDownloaded + " of " + fileSize);
                    } catch (IOException e) {
                        outputStream = outputStream2;
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream2;
                    }
                }
                outputStream2.flush();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream2 == null) {
                    return futureStudioIconFile;
                }
                outputStream2.close();
                return futureStudioIconFile;
            } catch (IOException e2) {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream == null) {
                    return null;
                }
                outputStream.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (Throwable e3) {
            return null;
        }
    }
}
