/**
 * 
 */
package org.hmzb.eat;

import java.util.ArrayList;

import org.hmzb.eat.model.ShopDTO;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * ���ֶ�ѡ��ȥ�Ķ���activity����.
 * 
 * @author zhufu
 * 
 *         <pre>
 * �޸�����		�޸���	�޸�ԭ��
 * 2012-6-17	zhufu	�½�
 * </pre>
 */
public class ManualActivity extends Activity {

    private ListView resultListView;

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);
        resultListView = (ListView) findViewById(R.id.ressultlistView);

        Uri uri = Uri.parse("content://www.hmzb.org/shop");

        ContentResolver cr = this.getContentResolver();
        // GoWhereEatDB goWhereEatDB = new GoWhereEatDB(this, "GoWhereEatDB.db", null, 1);
        Cursor cursor = cr.query(uri, null, null, null, null);
        Log.d("hmzb", String.valueOf(cursor.getCount()));
        // Cursor cursor = goWhereEatDB.query("select * from shop ", null);
        Log.d("shine", "ManualActivity -> onCreate");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Log.d("hmzb", "name is " + cursor.getString(1));
            Log.d("hmzb", "address is " + cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.moveToFirst();
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.manual, cursor,
                new String[] {"name" }, new int[] {R.id.resultTextView });
        resultListView.setAdapter(simpleCursorAdapter);
        // setListAdapter(simpleCursorAdapter);
        resultListView.setOnItemClickListener(new OnItemClickListener() {

            /*
             * (non-Javadoc)
             * 
             * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView,
             * android.view.View, int, long)
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Cursor cs = (Cursor) item;
                ShopDTO shopDTO = new ShopDTO();
                shopDTO.setName(cs.getString(1));
                shopDTO.setAddress(cs.getString(2));
                Log.d("hmzb", shopDTO.getName() + "'s " + "address is " + shopDTO.getAddress());

                Intent intent = new Intent();
                intent.setClass(ManualActivity.this, ResultActivity.class);
                // intent.Pu.putExtra("shop", shopDTO);
                ArrayList<ShopDTO> shopDTOList = new ArrayList<ShopDTO>();
                shopDTOList.add(shopDTO);
                intent.putParcelableArrayListExtra("shop", shopDTOList);
                startActivity(intent);
            }
        });
    }

}
