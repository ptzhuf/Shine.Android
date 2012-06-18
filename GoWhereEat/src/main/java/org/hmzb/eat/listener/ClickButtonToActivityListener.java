/**
 * 
 */
package org.hmzb.eat.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 【启动新的activity监听器】类. TODO : 考虑如何在onClick的时候传递数据进来（必须足够通用）
 * 
 * @author zhufu
 * 
 *         <pre>
 * 修改日期		修改人	修改原因
 * 2012-6-18	zhufu	新建
 * </pre>
 */
public class ClickButtonToActivityListener implements OnClickListener {

    /**
     * 目标activity的类型对象.
     */
    private Class<?> targetActivityClass;

    /**
     * 拥有当前控件的avtivity
     */
    private Activity sourceActivity;

    /**
     * 构造函数.
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
