package com.zhang.greendaotest;

import android.app.Application;
import android.content.Context;

import com.zhang.greendaotest.db.GreenDaoManager;
import com.zhang.greendaotest.greendao.gen.DaoSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.zhang.greendaotest.R.raw.city;

/**
 * Project: GreenDaoTest
 * Author:  张佳林
 * Version:  1.0
 * Date:    2017/7/5
 * Modify:  //TODO
 * Description: //TODO
 * Copyright notice:
 */

public class MyApp extends Application {
    public static Context sContext;
    public static DaoSession sDaoSession;
    public static DaoSession sNewDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        writeDB();
        initDatabase();

    }

    private void initDatabase() {
        sDaoSession = GreenDaoManager.getInstance().getmDaoMaster(sContext).newSession();
        sNewDaoSession = GreenDaoManager.getInstance().getmNewDaoSession();
    }

    public static Context getAppContext() {
        return sContext;
    }
    public static String sDBPath;   //数据库存入手机的路径
    public void writeDB() {
        FileOutputStream fout = null;
        InputStream inputStream = null;
        sDBPath = getFilesDir() + "\\databases\\" + "city.db";
        try {
            inputStream = getResources().openRawResource(city);
            fout = new FileOutputStream(new File(sDBPath));
            byte[] buffer = new byte[128];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                fout.write(buffer, 0, len);
            }
            buffer = null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
