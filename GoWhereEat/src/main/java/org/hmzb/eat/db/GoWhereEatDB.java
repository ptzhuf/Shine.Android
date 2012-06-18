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
        db.execSQL("create table shop(_id int identity(1,1) primary key, name text, address text);");
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
}
