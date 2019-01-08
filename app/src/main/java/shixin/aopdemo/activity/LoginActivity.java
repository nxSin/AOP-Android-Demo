package shixin.aopdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import shixin.aopdemo.R;
import shixin.aopdemo.constant.ApplicationConstant;
import shixin.aopdemo.constant.ShareperferenceKey;
import shixin.aopdemo.util.ToastUtils;
import shixin.aopdemo.util.Useful;

/**
 * 登陆页面
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
    }

    private void findView() {
        //登陆按钮
        findViewById(R.id.login_btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登陆设置标志为1
                Useful.SharedPerferencesCreat(ApplicationConstant.APP, ShareperferenceKey.LOGIN, ApplicationConstant.ONE);
                ToastUtils.showToast("登陆成功");
            }
        });
    }
}
