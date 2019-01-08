package shixin.aopdemo.login.interf;

import android.content.Context;

/**
 * 登陆过滤接口
 */
public interface ILoginFilter {
    /**
     * 用户过滤
     *
     * @param context         上下文
     * @param userfilterState 过滤状态
     * @return true 代表允许继续执行,false 代表不允许继续执行
     */
    boolean userFilter(Context context, int userfilterState);

    /**
     * 是否登陆
     *
     * @return true 是，false 没有登陆
     */
    boolean isLogin(Context context);

    /**
     * 清楚登陆标志
     *
     * @param context
     */
    void clearLoginState(Context context);
}
