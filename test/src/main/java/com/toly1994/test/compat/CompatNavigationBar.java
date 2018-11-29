package com.toly1994.test.compat;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/10/31 0031:11:48<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class CompatNavigationBar {

    public static void handle(Activity activity) {
        new CompatNavigationBar(activity.findViewById(android.R.id.content));
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        // 虚拟导航键颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setNavigationBarColor(0xffF8F8F8);
        }
    }

    private View mChildOfContent;
    private int usableHeightPrevious;
    private ViewGroup.LayoutParams frameLayoutParams;

    private CompatNavigationBar(View content) {
        mChildOfContent = content;
        mChildOfContent.getViewTreeObserver().
                addOnGlobalLayoutListener(() -> possiblyResizeChildOfContent());
        frameLayoutParams = mChildOfContent.getLayoutParams();
    }

    private void possiblyResizeChildOfContent() {
        int usableHeightNow = computeUsableHeight();
        if (usableHeightNow != usableHeightPrevious) {
            //将计算的可视高度设置成视图的高度
            frameLayoutParams.height = usableHeightNow;
            mChildOfContent.requestLayout();//请求重新布局
            usableHeightPrevious = usableHeightNow;
        }
    }

    private int computeUsableHeight() {
        //计算视图可视高度
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
//        这里是调整顶起的高度，可以直接用r.bottom
        return (r.bottom);
    }
}