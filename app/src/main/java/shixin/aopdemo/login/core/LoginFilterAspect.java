package shixin.aopdemo.login.core;

import android.content.Context;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import shixin.aopdemo.login.annotation.LoginFilter;
import shixin.aopdemo.login.interf.ILoginFilter;

/**
 * 登陆过滤切面
 */
@Aspect
public class LoginFilterAspect {
    private static final String TAG = "LoginFilterAspect";

    public LoginFilterAspect() {
    }

    //指定注解,前面的**代表通配符， (..)代表参数任意个数任意，也可改为携带实际参数
    @Pointcut("call(@shixin.aopdemo.login.annotation.LoginFilter * *(..))")
    public void loginFilter() {
    }


    @Around("loginFilter()")
    public void aroundLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        ILoginFilter iLogin = LoginControl.getInstance().getiLogin();
        if (iLogin == null) {
            throw new IllegalStateException("LoginSDK 没有初始化！");
        }

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalStateException("LoginFilter 注解只能用于方法上");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        LoginFilter loginFilter = methodSignature.getMethod().getAnnotation(LoginFilter.class);
        if (loginFilter == null) {
            return;
        }

        Context context = LoginControl.getInstance().getApplicationContext();
        //检验是否已经登陆了，登陆了则继续执行原代码
        if (iLogin.isLogin(context)) {
            joinPoint.proceed();
        } else {
            //如果没登陆则将状态传下去让用户处理
            boolean canProceed = iLogin.userFilter(context, loginFilter.userfilterState());
            //如果返回允许继续则进行继续
            if (canProceed) {
                joinPoint.proceed();
            }
        }

    }
}
