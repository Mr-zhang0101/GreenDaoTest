package com.zhang.greendaotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zhang.greendaotest.greendao.gen.DaoMaster;
import com.zhang.greendaotest.greendao.gen.UserDao;

import org.greenrobot.greendao.database.Database;



public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 数据库升级
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.getInstance().migrate(db,UserDao.class);
    }

}