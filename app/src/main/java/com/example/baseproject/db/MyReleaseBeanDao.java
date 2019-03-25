package com.example.baseproject.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_RELEASE_BEAN".
*/
public class MyReleaseBeanDao extends AbstractDao<MyReleaseBean, Long> {

    public static final String TABLENAME = "MY_RELEASE_BEAN";

    /**
     * Properties of entity MyReleaseBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Time = new Property(3, String.class, "time", false, "TIME");
        public final static Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public final static Property People = new Property(5, String.class, "people", false, "PEOPLE");
        public final static Property Beizhu = new Property(6, String.class, "beizhu", false, "BEIZHU");
    }


    public MyReleaseBeanDao(DaoConfig config) {
        super(config);
    }
    
    public MyReleaseBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_RELEASE_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"URL\" TEXT," + // 1: url
                "\"TITLE\" TEXT," + // 2: title
                "\"TIME\" TEXT," + // 3: time
                "\"ADDRESS\" TEXT," + // 4: address
                "\"PEOPLE\" TEXT," + // 5: people
                "\"BEIZHU\" TEXT);"); // 6: beizhu
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_RELEASE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyReleaseBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        String people = entity.getPeople();
        if (people != null) {
            stmt.bindString(6, people);
        }
 
        String beizhu = entity.getBeizhu();
        if (beizhu != null) {
            stmt.bindString(7, beizhu);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyReleaseBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        String people = entity.getPeople();
        if (people != null) {
            stmt.bindString(6, people);
        }
 
        String beizhu = entity.getBeizhu();
        if (beizhu != null) {
            stmt.bindString(7, beizhu);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MyReleaseBean readEntity(Cursor cursor, int offset) {
        MyReleaseBean entity = new MyReleaseBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // time
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // address
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // people
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // beizhu
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyReleaseBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAddress(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPeople(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setBeizhu(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MyReleaseBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MyReleaseBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MyReleaseBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
