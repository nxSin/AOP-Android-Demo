package shixin.aopdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import shixin.aopdemo.AspectHelper;
import shixin.aopdemo.R;
import shixin.aopdemo.constant.ApplicationConstant;
import shixin.aopdemo.constant.ShareperferenceKey;
import shixin.aopdemo.logh.AnnoExeTimeLogAspect;
import shixin.aopdemo.login.annotation.LoginFilter;
import shixin.aopdemo.login.constant.UserLoginFilterType;
import shixin.aopdemo.util.Useful;

/**
 * 主页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();

        testAspect();
    }

    /**
     * 测试Aspect
     */
    private void testAspect() {
        new AspectHelper().test();
    }

    private void findView() {
        findViewById(R.id.main_btn_need_login).setOnClickListener(this);
        findViewById(R.id.main_btn_need_login_hint).setOnClickListener(this);
        findViewById(R.id.main_btn_not_need_login).setOnClickListener(this);
        findViewById(R.id.main_btn_clear_login_info).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_need_login:
                testNeedLoginEL2LoginActivity();
                break;
            case R.id.main_btn_need_login_hint:

                testNeedLoginELHint();
                break;
            case R.id.main_btn_not_need_login:
                testNotNeedLogin();
                break;
            case R.id.main_btn_clear_login_info:
                clearLoginInfo();
                testLog(7);
                break;
            default:
                break;
        }
    }

    @AnnoExeTimeLogAspect()
    private void testLog(int value) {
        Log.d(TAG, "日志:" + value);
    }

    /**
     * 清楚登陆信息
     */
    @AnnoExeTimeLogAspect
    private void clearLoginInfo() {
        Useful.clearSpecialPerferences(ApplicationConstant.APP, ShareperferenceKey.LOGIN);
    }

    /**
     * 测试不需要登陆就能跳转的页面
     */
    @LoginFilter(userfilterState = UserLoginFilterType.NO_LOGIN_2_NEXT)
    private void testNotNeedLogin() {
        startActivity(new Intent(this, NotNeedLoginActivity.class));
    }

    /**
     * 测试需要登陆才能跳转的页面,没登陆只提示
     */
    @LoginFilter(userfilterState = UserLoginFilterType.NO_LOGIN_2_HINT)
    private void testNeedLoginELHint() {
        startActivity(new Intent(this, NotNeedLoginActivity.class));
    }

    /**
     * 测试需要登陆才能跳转的页面,没登陆自动跳转登陆页面
     */
    @LoginFilter(userfilterState = UserLoginFilterType.NO_LOGIN_2_LOGIN)
    private void testNeedLoginEL2LoginActivity() {
        startActivity(new Intent(this, NeedLoginActivity.class));
    }
}
