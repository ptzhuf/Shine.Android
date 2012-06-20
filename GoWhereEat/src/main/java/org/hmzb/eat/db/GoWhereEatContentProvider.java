/**
 * 
 */
package org.hmzb.eat.db;

import org.hmzb.eat.constants.GoWhereEatConstants;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/**
 * 【】类.
 * 
 * @author zhufu
 * 
 *         <pre>
 * 修改日期		修改人	修改原因
 * 2012-6-17	zhufu	新建
 * </pre>
 */
public class GoWhereEatContentProvider extends ContentProvider {

    private GoWhereEatDB goWhereEatDB;

    /*
     * (non-Javadoc)
     * 
     * @see android.content.ContentProvider#onCreate()
     */
    @Override
    public boolean onCreate() {
        goWhereEatDB = new GoWhereEatDB(this.getContext(), "GoWhereEatDB.db", null, 1);
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.content.ContentProvider#query(android.net.Uri, java.lang.String[], java.lang.String,
     * java.lang.String[], java.lang.String)
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.d(GoWhereEatConstants.TAG, uri.getPath());
        String dbPath = uri.getPath();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from " + dbPath.substring(1));
        if (selection != null && selection.length() != 0) {
            sql.append(" where " + selection);
        }
        return goWhereEatDB.query(sql.toString(), null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.content.ContentProvider#getType(android.net.Uri)
     */
    @Override
    public String getType(Uri uri) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.content.ContentProvider#insert(android.net.Uri, android.content.ContentValues)
     */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String table = uri.getPath().substring(1);
        long id = goWhereEatDB.insert(table, values);
        if (id > 0) {
            // 通知所有的监听，数据发生变化.
            getContext().getContentResolver().notifyChange(uri, null);
            return ContentUris.withAppendedId(uri, id);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.content.ContentProvider#delete(android.net.Uri, java.lang.String, java.lang.String[])
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String table = uri.getPath().substring(1);
        return goWhereEatDB.delete(table, selection, selectionArgs);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.content.ContentProvider#update(android.net.Uri, android.content.ContentValues, java.lang.String,
     * java.lang.String[])
     */
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String table = uri.getPath().substring(1);
        // TODO 使用占位符避免注入
        if (selection == null || selection.length() == 0) {
            selection = "_id = " + values.getAsInteger("_id");
        }
        return goWhereEatDB.update(table, values, selection, selectionArgs);
    }

}
