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
 * ��ȥ�Ķ������ݿ⸨������.
 * 
 * @author zhufu
 * 
 *         <pre>
 * �޸�����		�޸���	�޸�ԭ��
 * 2012-6-17	zhufu	�½�
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
        // TODO : try ��˵����������_id���ܹ���SimpleCursorAdapter�󶨣�����ᱨ��
        StringBuilder createDBSql = new StringBuilder();
        createDBSql.append("CREATE TABLE [shop] ( \n");
        createDBSql.append("  [_id] INTEGER NOT NULL PRIMARY KEY,  \n");
        createDBSql.append("  [name] VARCHAR2 NOT NULL,  \n");
        createDBSql.append("  [address] VARCHAR2); \n");
        createDBSql.append(" \n");

        db.execSQL(createDBSql.toString());
        db.execSQL("insert into shop(name, address) values('��ζԪ����', '��˾¥�����������ҷ�');");
        db.execSQL("insert into shop(name, address) values('��һ��', '��˾¥�����������ҷ�');");
        db.execSQL("insert into shop(name, address) values('��ʽ��ʳ', '��˾¥������������');");
        db.execSQL("insert into shop(name, address) values('��������', '��˾¥�����������ҷ�');");
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
     * ��ѯ.
     * 
     * @param sql ��ѯ���
     * @param selectionArgs Ͷ����
     * @return
     * 
     *         <pre>
     * �޸�����		�޸���	�޸�ԭ��
     * 2012-6-17	zhufu	�½�
     * </pre>
     */
    public Cursor query(String sql, String[] selectionArgs) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        return cursor;
    }

    /**
     * ��������.
     * 
     * @param table ����
     * @param values �ֶ�ֵ
     * @return
     * 
     *         <pre>
     * �޸�����		�޸���	�޸�ԭ��
     * 2012-6-19	zhufu	�½�
     * </pre>
     */
    public long insert(String table, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(table, null, values);
    }

    /**
     * ��������.
     * 
     * @param table
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return the number of rows affected.
     * 
     *         <pre>
     * �޸�����		�޸���	�޸�ԭ��
     * 2012-6-19	zhufu	�½�
     * </pre>
     */
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(table, values, whereClause, whereArgs);
    }

    /**
     * ��������ɾ��.
     * 
     * @param table ����
     * @param whereClause ����
     * @param whereArgs ռλ������
     * @return the number of rows affected if a whereClause is passed in, 0 otherwise. To remove all rows and get a
     *         count pass "1" as the whereClause.
     * 
     *         <pre>
     * �޸�����		�޸���	�޸�ԭ��
     * 2012-6-20	zhufu	�½�
     * </pre>
     */
    public int delete(String table, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table, whereClause, whereArgs);
    }
}
