package shixin.aopdemo.login.core;

import android.content.Context;

import shixin.aopdemo.login.interf.ILoginFilter;

/**
 * 登陆控制
 */
public class LoginControl {
    private volatile static LoginControl instance;
    private Context applicationContext;
    /**
     * 全局持有ilogin
     */
    private ILoginFilter iLogin;

    private LoginControl() {
    }

    public static LoginControl getInstance() {
        if (instance == null) {
            synchronized (LoginControl.class) {
                if (instance == null) {
                    instance = new LoginControl();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     *
     * @param context 上下文
     * @param iLogin  登陆接口
     */
    public void init(Context context, ILoginFilter iLogin) {
        applicationContext = context.getApplicationContext();
        setiLogin(iLogin);
    }


    public ILoginFilter getiLogin() {
        return iLogin;
    }

    public void setiLogin(ILoginFilter iLogin) {
        this.iLogin = iLogin;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }
}