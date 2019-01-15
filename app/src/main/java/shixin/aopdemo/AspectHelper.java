package shixin.aopdemo;

import shixin.aopdemo.aspect_intertype.InterTypeHelper;

/**
 * 切入点测试
 */
public class AspectHelper {

    public void test() {
        //after before
//        new AfterBeforeTestHelper().testAfterBeforeOne();

        //AfterReturning
//        new AfterReturnTestHelper().testAfterReturnOne();

        //Around
//        new AroundTestHelper().testAroundOne();

        //Filed测试
//        new FiledHelper().testStart();

        //异常捕获测试
//        new ExceptionHelper().testStart();

        //测试组合
//        new CombineHelper().testStart();

        //intertype测试
        new InterTypeHelper().testStart();
    }
}
