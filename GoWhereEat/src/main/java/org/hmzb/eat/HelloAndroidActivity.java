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
     * �ֶ���ť.
     */
    private Button manualBtn;
    /**
     * �����ť.
     */
    private Button randomBtn;
    /**
     * ���밴ť.
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
        // �����ֶ���ť���¼�����������ManualActivity
        manualBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HelloAndroidActivity.this, ManualActivity.class);
                HelloAndroidActivity.this.startActivity(intent);
            }
        });
        // ���������ť���¼�����������ResultActivity
        randomBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // ��ѯ���е�����
                Cursor cursor = cr.query(GoWhereEatConstants.SHOP_URI, null, null, null, null);
                // ���һ�����������
                ShopDTO shopDTO = getRandomShop(cursor);
                ArrayList<ShopDTO> shopDTOList = new ArrayList<ShopDTO>();
                // �ر��α�
                cursor.close();
                // �������activity
                Intent intent = new Intent();
                intent.setClass(HelloAndroidActivity.this, ResultActivity.class);
                shopDTOList.add(shopDTO);
                intent.putParcelableArrayListExtra("shop", shopDTOList);
                HelloAndroidActivity.this.startActivity(intent);
            }
        });
        // ���ò��밴ť���¼�����������InsertActivity
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
     * �������һ������.
     * 
     * @param cursor �α�
     * @return ���̴������
     * 
     *         <pre>
     * �޸�����		�޸���	�޸�ԭ��
     * 2012-6-19	zhufu	�½�
     * </pre>
     */
    private ShopDTO getRandomShop(Cursor cursor) {

        int position = new Random().nextInt(cursor.getCount());
        cursor.moveToPosition(position);
        ShopDTO shopDTO = new ShopDTO(cursor.getString(1), cursor.getString(2));
        return shopDTO;
    }

    /**
     * �������еĿؼ�.
     * 
     * <pre>
     * �޸�����		�޸���	�޸�ԭ��
     * 2012-6-19	zhufu	�½�
     * </pre>
     */
    private void setAllView() {
        manualBtn = (Button) findViewById(R.id.manualBtn);
        randomBtn = (Button) findViewById(R.id.randomBtn);
        insertBtn = (Button) findViewById(R.id.insertBtn);
    }

}
