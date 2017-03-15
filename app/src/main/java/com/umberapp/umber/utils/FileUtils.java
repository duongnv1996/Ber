package com.umberapp.umber.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Environment;

import com.umberapp.umber.apis.ApiConstants;
import com.wang.avi.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import me.zhanghai.android.materialprogressbar.BuildConfig;

public class FileUtils {
    public static String getFolder(Context context) {
        String filePath = Environment.getExternalStorageDirectory().getPath() + File.separator + context.getString(R.string.app_name) + File.separator + ApiConstants.KEY_FILE + File.separator;
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return filePath;
    }

    public void openFolder() {
    }

    public static void openFolder(Context context) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setDataAndType(Uri.parse(Environment.getExternalStorageDirectory().getPath() + getFolder(context)), "text/csv");
        context.startActivity(Intent.createChooser(intent, "Open folder"));
    }

    public static File SaveImage(Context context, Bitmap finalBitmap) {
        String filePath = Environment.getExternalStorageDirectory().getPath() + File.separator + context.getString(R.string.app_name) + File.separator + "image" + File.separator;
        File folder = new File(filePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(filePath, "Image-" + new Random().nextInt(ApiConstants.SIZE_RADIUS) + ".jpg");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            RLog.m86e("Create file image success");
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File writeFileSD(Context context, String nameFile, String content) {
        File mFile = new File(getFolder(context) + nameFile);
        try {
            mFile.createNewFile();
            if (mFile.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(mFile);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                writer.write(content);
                writer.flush();
                writer.close();
                fileOutputStream.close();
                RLog.m86e("create file " + mFile.getPath() + " successful !");
                return mFile;
            }
        } catch (FileNotFoundException e) {
            RLog.m86e(e.toString());
            e.printStackTrace();
        } catch (IOException e2) {
            RLog.m86e(e2.toString());
            e2.printStackTrace();
        }
        return null;
    }

    public static String readFile(Context context, String nameFile, String namePath) {
        return BuildConfig.FLAVOR;
    }
}
