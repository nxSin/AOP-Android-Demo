package shixin.aopdemo.login.constant;

/**
 * 用户登陆过滤类型
 */
public interface UserLoginFilterType {
    /**
     * 没登陆跳转到登陆页面
     */
    int NO_LOGIN_2_LOGIN = 0;
    /**
     * 没登陆继续执行
     */
    int NO_LOGIN_2_NEXT = 1;
    /**
     * 没登陆提示
     */
    int NO_LOGIN_2_HINT = 2;
}
