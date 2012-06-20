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
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
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

    /**
     * 结果列表.
     */
    private ListView resultListView;

    /**
     * 简单游标适配器.
     */
    private SimpleCursorAdapter simpleCursorAdapter;

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
        // 查询所有的商铺,并创建adapter
        createSimpleCursorAdapter(GoWhereEatConstants.SHOP_URI);
        resultListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获得数据
                Object item = parent.getItemAtPosition(position);
                Cursor cs = (Cursor) item;
                ShopDTO shopDTO = new ShopDTO();
                shopDTO.setName(cs.getString(1));
                shopDTO.setAddress(cs.getString(2));
                Log.d(GoWhereEatConstants.TAG, shopDTO.getName() + "'s " + "address is " + shopDTO.getAddress());
                // 放入到列表
                ArrayList<ShopDTO> shopDTOList = new ArrayList<ShopDTO>();
                shopDTOList.add(shopDTO);
                // 启动结果Activity
                Intent intent = new Intent();
                intent.setClass(ManualActivity.this, ResultActivity.class);
                // intent.Pu.putExtra("shop", shopDTO);
                intent.putParcelableArrayListExtra("shop", shopDTOList);
                startActivity(intent);
            }
        });
        resultListView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 获得数据
                Object item = parent.getItemAtPosition(position);
                Cursor cs = (Cursor) item;
                ShopDTO shopDTO = new ShopDTO();
                shopDTO.setId(cs.getInt(0));
                shopDTO.setName(cs.getString(1));
                shopDTO.setAddress(cs.getString(2));
                // 放入到列表
                ArrayList<ShopDTO> shopDTOList = new ArrayList<ShopDTO>();
                shopDTOList.add(shopDTO);
                // 启动activity
                Intent intent = new Intent();
                intent.setClass(ManualActivity.this, ShopActivity.class);
                intent.putParcelableArrayListExtra("shop", shopDTOList);
                startActivityForResult(intent, 1);
                return true;
            }

        });
    }

    /**
     * 创建SimpleCursorAdapter.
     * 
     * @param uri uri
     * 
     *            <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-20	zhufu	新建
     * </pre>
     */
    private void createSimpleCursorAdapter(Uri uri) {
        ContentResolver cr = this.getContentResolver();
        Cursor cursor = cr.query(uri, null, null, null, null);
        Log.d(GoWhereEatConstants.TAG, "cursor's count is " + String.valueOf(cursor.getCount()));
        Log.d(GoWhereEatConstants.TAG, "ManualActivity -> onCreate");
        // 通过SimpleCursorAdapter关联数据与列表@link(https://github.com/ptzhuf/Shine.Android/wiki/学习历程)
        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.manual, cursor, new String[] {"name" },
                new int[] {R.id.resultTextView });
        resultListView.setAdapter(simpleCursorAdapter);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(GoWhereEatConstants.TAG,"ManualActivity -> onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
//        simpleCursorAdapter.notifyDataSetChanged();
        // FIXME 重新查询一次，不知道是否有更好的通知办法
        createSimpleCursorAdapter(GoWhereEatConstants.SHOP_URI);
    }
}
