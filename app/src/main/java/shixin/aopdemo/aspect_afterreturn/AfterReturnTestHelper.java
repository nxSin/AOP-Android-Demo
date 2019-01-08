package shixin.aopdemo.aspect_afterreturn;

import android.util.Log;

/**
 * AfterReturn测试
 */
public class AfterReturnTestHelper {

    private static final String TAG = AfterReturnTestHelper.class.getSimpleName();

    public void testAfterReturnOne() {
        Log.d(TAG, "testAfterReturnOne");
        //调用带返回值方法，传入1，3参数
        int i = aspectjTest(1, 3);
        Log.i(TAG, "testAfterReturnOne over");
    }

    /**
     * 被调用
     */
    private int aspectjTest(int a, int b) {
        return 5;
    }
}

