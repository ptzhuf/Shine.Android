/**
 * 
 */
package org.hmzb.eat.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 【去哪儿吃数据库辅助】类.
 * 
 * @author zhufu
 * 
 *         <pre>
 * 修改日期		修改人	修改原因
 * 2012-6-17	zhufu	新建
 * </pre>
 */
public class GoWhereEatDB extends SQLiteOpenHelper {

    public GoWhereEatDB(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO : try 据说必须有主键_id才能够被SimpleCursorAdapter绑定，否则会报错
        StringBuilder createDBSql = new StringBuilder();
        createDBSql.append("CREATE TABLE [shop] ( \n");
        createDBSql.append("  [_id] INTEGER NOT NULL PRIMARY KEY,  \n");
        createDBSql.append("  [name] VARCHAR2 NOT NULL,  \n");
        createDBSql.append("  [address] VARCHAR2); \n");
        createDBSql.append(" \n");

        db.execSQL(createDBSql.toString());
        db.execSQL("insert into shop(name, address) values('和味元宵店', '公司楼下面向大丰收右方');");
        db.execSQL("insert into shop(name, address) values('又一村', '公司楼下面向大丰收右方');");
        db.execSQL("insert into shop(name, address) values('广式美食', '公司楼下面向大丰收左方');");
        db.execSQL("insert into shop(name, address) values('兰州拉面', '公司楼下面向大丰收右方');");
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    /**
     * 查询.
     * 
     * @param sql 查询语句
     * @param selectionArgs 投射列
     * @return
     * 
     *         <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-17	zhufu	新建
     * </pre>
     */
    public Cursor query(String sql, String[] selectionArgs) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        return cursor;
    }

    /**
     * 插入数据.
     * 
     * @param table 表明
     * @param values 字段值
     * @return
     * 
     *         <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-19	zhufu	新建
     * </pre>
     */
    public long insert(String table, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(table, null, values);
    }

    /**
     * 更新数据.
     * 
     * @param table
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return the number of rows affected.
     * 
     *         <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-19	zhufu	新建
     * </pre>
     */
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(table, values, whereClause, whereArgs);
    }

    /**
     * 根据条件删除.
     * 
     * @param table 表名
     * @param whereClause 条件
     * @param whereArgs 占位符参数
     * @return the number of rows affected if a whereClause is passed in, 0 otherwise. To remove all rows and get a
     *         count pass "1" as the whereClause.
     * 
     *         <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-20	zhufu	新建
     * </pre>
     */
    public int delete(String table, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table, whereClause, whereArgs);
    }
}
