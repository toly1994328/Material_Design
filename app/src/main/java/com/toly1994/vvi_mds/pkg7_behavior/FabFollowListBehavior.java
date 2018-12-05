package com.toly1994.vvi_mds.pkg7_behavior;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/11/30 0030:14:34<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：FloatingActionButton伴随动画
 */
public class FabFollowListBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private static final int MIN_DY = 30;
    private static final String TAG = "FabFollowListBehavior";

    public FabFollowListBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /**
     * 初始时不调用，滑动时调用---一次滑动过程，之调用一次
     */
    @Override
    public boolean onStartNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull FloatingActionButton child,
            @NonNull View directTargetChild,
            @NonNull View target, int axes, int type) {
        return true;
    }

    /**
     * @param dyConsumed 每次回调前后的Y差值
     */
    @Override
    public void onNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull FloatingActionButton child,
            @NonNull View target, int dxConsumed,
            int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);

        //平移隐现
        if (dyConsumed > MIN_DY) {//上滑：消失
            showOrNot(coordinatorLayout, child, false).start();
        } else if (dyConsumed < -MIN_DY) {//下滑滑：显示
            showOrNot(coordinatorLayout, child, true).start();
        }

        //仅滑动时消失
//        if (dyConsumed > MIN_DY || dyConsumed < -MIN_DY) {//上滑：消失
//            showOrNot(child).start();
//        }
    }

    private Animator showOrNot(CoordinatorLayout coordinatorLayout, final View fab, boolean show) {
        //获取fab头顶的高度
        int hatHeight = coordinatorLayout.getBottom() - fab.getBottom() + fab.getHeight();
        int end = show ? 0 : hatHeight;
        float start = fab.getTranslationY();
        ValueAnimator animator = ValueAnimator.ofFloat(start, end);
        animator.addUpdateListener(animation ->
                fab.setTranslationY((Float) animation.getAnimatedValue()));
        return animator;
    }

    private Animator showOrNot(final View fab) {
        //获取fab头顶的高度
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);

        animator.addUpdateListener(animation -> {
            fab.setScaleX((Float) animation.getAnimatedValue());
            fab.setScaleY((Float) animation.getAnimatedValue());
        });
        return animator;
    }
}
