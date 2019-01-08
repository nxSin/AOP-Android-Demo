package shixin.aopdemo.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import shixin.aopdemo.activity.LoginActivity;
import shixin.aopdemo.constant.ApplicationConstant;
import shixin.aopdemo.constant.ShareperferenceKey;
import shixin.aopdemo.login.constant.UserLoginFilterType;
import shixin.aopdemo.login.core.LoginControl;
import shixin.aopdemo.login.interf.ILoginFilter;
import shixin.aopdemo.util.ToastUtils;
import shixin.aopdemo.util.Useful;

/**
 * application
 */
public class APP extends Application {

    private static final String TAG = APP.class.getSimpleName();
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LoginControl.getInstance().init(this, iLogin);
    }

    /**
     * 登陆过滤策略控制
     */
    ILoginFilter iLogin = new ILoginFilter() {
        @Override
        public boolean userFilter(Context context, int userfilterState) {
            switch (userfilterState) {
                case UserLoginFilterType.NO_LOGIN_2_LOGIN:
                    //跳转到登陆页面
                    ToastUtils.showToast("没登陆哦！将自动跳转自登陆页面");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    return false;
                case UserLoginFilterType.NO_LOGIN_2_NEXT:
                    Log.d(TAG, "没有登陆，允许继续访问");
                    return true;
                case UserLoginFilterType.NO_LOGIN_2_HINT:
                    ToastUtils.showToast("没登陆哦！请先登陆");
                    return false;
            }

            return false;
        }

        @Override
        public boolean isLogin(Context context) {
            return Useful.ReadSharedPerference(ApplicationConstant.APP, ShareperferenceKey.LOGIN)
                    .equals(ApplicationConstant.ONE);
        }

        @Override
        public void clearLoginState(Context context) {
            Useful.clearSpecialPerferences(ApplicationConstant.APP, ShareperferenceKey.LOGIN);
        }
    };

    public static Context getContext() {
        return mContext;
    }
}
