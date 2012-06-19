/**
 * 
 */
package org.hmzb.eat;

import java.util.ArrayList;

import org.hmzb.eat.constants.GoWhereEatConstants;
import org.hmzb.eat.model.ShopDTO;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * 【手动选择去哪儿吃activity】类.
 * 
 * @author zhufu
 * 
 *         <pre>
 * 修改日期		修改人	修改原因
 * 2012-6-17	zhufu	新建
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

        ContentResolver cr = this.getContentResolver();
        // GoWhereEatDB goWhereEatDB = new GoWhereEatDB(this, "GoWhereEatDB.db", null, 1);
        Cursor cursor = cr.query(GoWhereEatConstants.URI, null, null, null, null);
        Log.d(GoWhereEatConstants.TAG, "cursor's count is " + String.valueOf(cursor.getCount()));
        // Cursor cursor = goWhereEatDB.query("select * from shop ", null);
        Log.d(GoWhereEatConstants.TAG, "ManualActivity -> onCreate");
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Log.d(GoWhereEatConstants.TAG, "name is " + cursor.getString(1));
//            Log.d(GoWhereEatConstants.TAG, "address is " + cursor.getString(2));
//            cursor.moveToNext();
//        }
//        cursor.moveToFirst();
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
                Log.d(GoWhereEatConstants.TAG, shopDTO.getName() + "'s " + "address is " + shopDTO.getAddress());

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
