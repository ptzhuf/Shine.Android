package com.shine.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 
 * 【Activity】类. 这个类要继承Activity,要Override OnCreate方法。每个Activity都要在Manifest中注册。
 * 
 * @author zhufu
 * 
 *         <pre>
 * 修改日期		修改人	修改原因
 * 2012-5-27	zhufu	新建
 * </pre>
 */
public class Activity01 extends Activity {
    private EditText editText1;
    private EditText editText2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 这句话必须写在内容操作之前
        setContentView(R.layout.main);
        TextView textView = (TextView) findViewById(R.id.myTextView);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.myButton);
        textView.setText("欢迎光临");
        button.setText("计算结果");
        button.setOnClickListener(new MyButtonListener());
    }

    class MyButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            String resultString = getResult();
            Intent intent = new Intent();
            intent.setClass(Activity01.this, ResultActivity.class);
            intent.putExtra("result", resultString);
            // 启动外部activity 参数在AndroidManifest中定义（action name）
            // intent.setAction("frog.my.com");
            Activity01.this.startActivity(intent);
        }

    }

    public String getResult() {
        String editText1String = editText1.getText().toString();
        String editText2String = editText2.getText().toString();
        Integer edit1 = Integer.valueOf(editText1String);
        Integer edit2 = Integer.valueOf(editText2String);
        Integer result = edit1 + edit2;
        return result.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        System.out.println("Activity01 -> onDestroy");
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onPause()
     */
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        System.out.println("Activity01 -> onPause");
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onRestart()
     */
    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        System.out.println("Activity01 -> onRestart");
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        System.out.println("Activity01 -> onResume");
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onStart()
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("Activity01 -> onStart");
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onStop()
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        System.out.println("Activity01 -> onStop");
    }

}