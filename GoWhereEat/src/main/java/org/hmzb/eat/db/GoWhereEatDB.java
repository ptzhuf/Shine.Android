/**
 * 
 */
package org.hmzb.eat.db;

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
        db.execSQL("create table shop(_id int identity(1,1) primary key, name text, address text);");
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
}
