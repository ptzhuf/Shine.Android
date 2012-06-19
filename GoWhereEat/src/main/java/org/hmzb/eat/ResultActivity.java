/**
 * 
 */
package org.hmzb.eat;

import java.util.ArrayList;

import org.hmzb.eat.model.ShopDTO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * �����չʾ����.
 * 
 * @author zhufu
 * 
 *         <pre>
 * �޸�����		�޸���	�޸�ԭ��
 * 2012-6-18	zhufu	�½�
 * </pre>
 */
public class ResultActivity extends Activity {

    /**
     * �������ı��ؼ�.
     */
    private TextView nameTextView;
    /**
     * ��ַ�ı��ؼ�.
     */
    private TextView addressTextView;

    // private ImageView imageView;

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setAllView();
        Intent intent = getIntent();
        ArrayList<ShopDTO> shopDTOList = intent.getParcelableArrayListExtra("shop");
        ShopDTO shopDTO = shopDTOList.get(0);
        nameTextView.setText(shopDTO.getName());
        addressTextView.setText(shopDTO.getAddress());

    }

    /**
     * �������е�view�ؼ�.
     * 
     * <pre>
     * �޸�����		�޸���	�޸�ԭ��
     * 2012-6-18	zhufu	�½�
     * </pre>
     */
    private void setAllView() {
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        addressTextView = (TextView) findViewById(R.id.addressTextView);
        // imageView = (ImageView) findViewById(R.id.imageView1);
    }

}
