/**
 * 
 */
package org.hmzb.eat.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * �������µ�activity����������. TODO : ���������onClick��ʱ�򴫵����ݽ����������㹻ͨ�ã�
 * 
 * @author zhufu
 * 
 *         <pre>
 * �޸�����		�޸���	�޸�ԭ��
 * 2012-6-18	zhufu	�½�
 * </pre>
 */
public class ClickButtonToActivityListener implements OnClickListener {

    /**
     * Ŀ��activity�����Ͷ���.
     */
    private Class<?> targetActivityClass;

    /**
     * ӵ�е�ǰ�ؼ���avtivity
     */
    private Activity sourceActivity;

    /**
     * ���캯��.
     * 
     * @param targetActivityClass
     * @param sourceActivity
     */
    public ClickButtonToActivityListener(Class<?> targetActivityClass, Activity sourceActivity) {
        this.setTargetActivityClass(targetActivityClass);
        this.sourceActivity = sourceActivity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(sourceActivity, targetActivityClass);
        sourceActivity.startActivity(intent);
    }

    /**
     * @return the targetActivityClass
     */
    public Class<?> getTargetActivityClass() {
        return targetActivityClass;
    }

    /**
     * @param targetActivityClass the targetActivityClass to set
     */
    public void setTargetActivityClass(Class<?> targetActivityClass) {
        this.targetActivityClass = targetActivityClass;
    }

    /**
     * @return the sourceActivity
     */
    public Activity getSourceActivity() {
        return sourceActivity;
    }

    /**
     * @param sourceActivity the sourceActivity to set
     */
    public void setSourceActivity(Activity sourceActivity) {
        this.sourceActivity = sourceActivity;
    }

}
