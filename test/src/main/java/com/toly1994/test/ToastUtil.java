package com.toly1994.test;

import android.content.Context;
import android.widget.Toast;


public class ToastUtil {
    private static Toast toast;

    /**
     * 能够连续弹的吐司，不会等上个吐司消失
     *
     * @param ctx 上下文
     * @param msg 信息
     */
    public static void showAtOnce(Context ctx, String msg) {
        if (toast == null) {
            toast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
        }
        toast.setText(msg);//将text文本设置给吐司
        toast.show();
    }

    /**
     * 显示吐司
     *
     * @param ctx 上下文
     * @param msg 信息
     * @return 吐司
     */
    public static Toast show(Context ctx, String msg) {

        Toast toast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
        toast.show();
        return toast;
    }

}
