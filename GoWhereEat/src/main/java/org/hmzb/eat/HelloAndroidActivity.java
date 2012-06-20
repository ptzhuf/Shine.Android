package org.hmzb.eat;

import java.util.ArrayList;
import java.util.Random;

import org.hmzb.eat.constants.GoWhereEatConstants;
import org.hmzb.eat.model.ShopDTO;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloAndroidActivity extends Activity {

    /**
     * 手动按钮.
     */
    private Button manualBtn;
    /**
     * 随机按钮.
     */
    private Button randomBtn;
    /**
     * 插入按钮.
     */
    private Button insertBtn;

    /**
     * Called when the activity is first created.
     * 
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this
     *            Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). <br/>
     *            <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(GoWhereEatConstants.TAG, "onCreate");
        setContentView(R.layout.main);
        setAllView();
        final ContentResolver cr = getContentResolver();
        // 设置手动按钮的事件监听，启动ManualActivity
        manualBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HelloAndroidActivity.this, ManualActivity.class);
                HelloAndroidActivity.this.startActivity(intent);
            }
        });
        // 设置随机按钮的事件监听，启动ResultActivity
        randomBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询所有的商铺
                Cursor cursor = cr.query(GoWhereEatConstants.SHOP_URI, null, null, null, null);
                // 获得一个随机的商铺
                ShopDTO shopDTO = getRandomShop(cursor);
                ArrayList<ShopDTO> shopDTOList = new ArrayList<ShopDTO>();
                // 关闭游标
                cursor.close();
                // 启动结果activity
                Intent intent = new Intent();
                intent.setClass(HelloAndroidActivity.this, ResultActivity.class);
                shopDTOList.add(shopDTO);
                intent.putParcelableArrayListExtra("shop", shopDTOList);
                HelloAndroidActivity.this.startActivity(intent);
            }
        });
        // 设置插入按钮的事件监听，启动InsertActivity
        insertBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HelloAndroidActivity.this, ShopActivity.class);
                HelloAndroidActivity.this.startActivity(intent);
            }
        });
    }

    /**
     * 随机产生一个商铺.
     * 
     * @param cursor 游标
     * @return 商铺传输对象
     * 
     *         <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-19	zhufu	新建
     * </pre>
     */
    private ShopDTO getRandomShop(Cursor cursor) {

        int position = new Random().nextInt(cursor.getCount());
        cursor.moveToPosition(position);
        ShopDTO shopDTO = new ShopDTO(cursor.getString(1), cursor.getString(2));
        return shopDTO;
    }

    /**
     * 设置所有的控件.
     * 
     * <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-19	zhufu	新建
     * </pre>
     */
    private void setAllView() {
        manualBtn = (Button) findViewById(R.id.manualBtn);
        randomBtn = (Button) findViewById(R.id.randomBtn);
        insertBtn = (Button) findViewById(R.id.insertBtn);
    }

}
