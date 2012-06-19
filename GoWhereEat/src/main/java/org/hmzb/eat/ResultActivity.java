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
 * 【结果展示】类.
 * 
 * @author zhufu
 * 
 *         <pre>
 * 修改日期		修改人	修改原因
 * 2012-6-18	zhufu	新建
 * </pre>
 */
public class ResultActivity extends Activity {

    /**
     * 商铺名文本控件.
     */
    private TextView nameTextView;
    /**
     * 地址文本控件.
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
     * 设置所有的view控件.
     * 
     * <pre>
     * 修改日期		修改人	修改原因
     * 2012-6-18	zhufu	新建
     * </pre>
     */
    private void setAllView() {
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        addressTextView = (TextView) findViewById(R.id.addressTextView);
        // imageView = (ImageView) findViewById(R.id.imageView1);
    }

}
