package shixin.aopdemo;

import shixin.aopdemo.aspect_around.AroundTestHelper;
import shixin.aopdemo.aspect_filed.FiledHelper;

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
        new AroundTestHelper().testAroundOne();

        //Filed测试
        new FiledHelper().testStart();
    }
}
