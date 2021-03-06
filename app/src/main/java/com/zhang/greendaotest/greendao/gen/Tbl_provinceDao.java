package com.zhang.greendaotest.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.zhang.greendaotest.bean.Tbl_province;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TBL_PROVINCE".
*/
public class Tbl_provinceDao extends AbstractDao<Tbl_province, Long> {

    public static final String TABLENAME = "TBL_PROVINCE";

    /**
     * Properties of entity Tbl_province.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Code = new Property(1, String.class, "code", false, "codeid");
        public final static Property Parent = new Property(2, String.class, "parent", false, "parentid");
        public final static Property City = new Property(3, String.class, "city", false, "cityName");
    }


    public Tbl_provinceDao(DaoConfig config) {
        super(config);
    }
    
    public Tbl_provinceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TBL_PROVINCE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"codeid\" TEXT," + // 1: code
                "\"parentid\" TEXT," + // 2: parent
                "\"cityName\" TEXT);"); // 3: city
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TBL_PROVINCE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Tbl_province entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(2, code);
        }
 
        String parent = entity.getParent();
        if (parent != null) {
            stmt.bindString(3, parent);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(4, city);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Tbl_province entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(2, code);
        }
 
        String parent = entity.getParent();
        if (parent != null) {
            stmt.bindString(3, parent);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(4, city);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Tbl_province readEntity(Cursor cursor, int offset) {
        Tbl_province entity = new Tbl_province( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // code
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // parent
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // city
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Tbl_province entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setParent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCity(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Tbl_province entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Tbl_province entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Tbl_province entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
