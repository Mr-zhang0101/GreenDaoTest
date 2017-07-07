package com.zhang.greendaotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zhang.greendaotest.MyApp;
import com.zhang.greendaotest.greendao.gen.DaoMaster;
import com.zhang.greendaotest.greendao.gen.DaoSession;

import static org.greenrobot.greendao.test.DbTest.DB_NAME;

/**
 * Project: GreenDaoTest
 * Author:  张佳林
 * Version:  1.0
 * Date:    2017/7/5
 * Modify:  //TODO
 * Description: //TODO
 * Copyright notice:
 */

public class GreenDaoManager {
    private DaoMaster mNewDaoMaster;
    private DaoMaster mDaoMaster;
    private DaoSession mNewDaoSession;
    private DaoSession mDaoSession;


    private GreenDaoManager() {
        /**
         * 初始化GreenDao
         */
        DaoMaster.DevOpenHelper devOpenHelper =  new DaoMaster.DevOpenHelper(MyApp.getAppContext(), "user.db", null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();

        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(MyApp.sDBPath, null);
        mNewDaoMaster = new DaoMaster(database);
        mNewDaoSession = mNewDaoMaster.newSession();

    }

    private static class SingleInstance {
        private static final GreenDaoManager INSTANCE = new GreenDaoManager();
    }


    public static GreenDaoManager getInstance() {
        return SingleInstance.INSTANCE;
    }

    /**
     * 得到DaoMaster实例
     * @return
     */
    public DaoMaster getmDaoMaster(Context context) {
        MyOpenHelper helper = new MyOpenHelper(context,DB_NAME,null);
        mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        return mDaoMaster;
    }

    /**
     * 得到DaoSession实例
     * @return
     */
    public DaoSession getmDaoSession() {
        return mDaoSession;
    }
    public DaoSession getmNewDaoSession() {
        return mNewDaoSession;
    }

}