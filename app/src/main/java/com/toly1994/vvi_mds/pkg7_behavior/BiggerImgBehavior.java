package com.toly1994.vvi_mds.pkg7_behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.toly1994.test.L;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/11/28 0028:17:02<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：最简单的behavior
 */
public class BiggerImgBehavior extends CoordinatorLayout.Behavior<View> {

    private float curY;

    public BiggerImgBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 确定使用Behavior的View要依赖的View的类型：
     * 返回false：onDependentViewChanged不触发
     *
     * @param parent     CoordinatorLayout布局容器
     * @param child      装载behavior的控件
     * @param dependency 被联动的控件
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    /**
     * 当被依赖的View状态改变时回调
     *
     * @param parent     CoordinatorLayout布局容器
     * @param child      装载behavior的控件
     * @param dependency 被联动的控件
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        float dy = dependency.getTop() - curY; //dy>0 ----下移

        float faction;//移动的分度值
        if (dy <= 0) {//上移动
            faction = -dependency.getTop() * 1.f / dependency.getHeight();
        } else {
            faction = 1 - (-dependency.getTop() * 1.f / dependency.getHeight());
        }

        L.d(faction + L.l());
//        dependency.setTranslationY(-dependency.getTop());//让dependency不移动

//        dependency.setPivotX(dependency.getWidth()/2);//旋转
//        dependency.setPivotY(dependency.getHeight()/2);
//        dependency.setRotation(360 * faction);//旋转
        if (dy < 0) {
            dependency.setScaleX(1 - faction);
            dependency.setScaleY(1 - faction);
        } else {
            dependency.setScaleX(1 + faction);
            dependency.setScaleY(1 + faction);
        }
        dependency.setTranslationY(dy);
        curY = dependency.getY();//更新curY
        return true;
    }

}
