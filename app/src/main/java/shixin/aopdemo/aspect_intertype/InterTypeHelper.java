package shixin.aopdemo.aspect_intertype;

import android.util.Log;

/**
 * innertype测试
 */
public class InterTypeHelper {

    private static final String TAG = InterTypeHelper.class.getSimpleName();

    public void testStart() {
        Log.d(TAG, "testStart");
        Baby baby = new Baby("小宝贝");
        Log.i(TAG, "name:" + baby.getName());
        if (baby instanceof People) {
            Log.i(TAG, "baby instance of People true,baby age:" + ((People) baby).getAge());
        }
        Log.i(TAG, "testStart over");
    }

}

