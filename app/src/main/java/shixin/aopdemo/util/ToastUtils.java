package shixin.aopdemo.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import shixin.aopdemo.base.APP;

/**
 * 单例  Toast
 * Created by rdx on 2017/3/9.
 */

public class ToastUtils {
    private static Toast toast;

    private static Handler handler = new Handler(Looper.getMainLooper());

    /**
     * 单例吐司，能够连续弹的吐司
     *
     * @param text
     */
    public static void showToast(final String text) {

        final Context context = APP.getContext();
        if (context == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            initToast(context, text);
            toast.show();
        } else {
            handler.post(() -> {
                initToast(context, text);
                toast.show();
            });
        }
    }

    private static void initToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);//如果不为空，则直接改变当前toast的文本
        }
    }
}
