package shixin.aopdemo.login.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登陆过滤
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface LoginFilter {
    /**
     * 用户过滤类型
     *
     * @return 0默认
     */
    int userfilterState() default 0;
}
