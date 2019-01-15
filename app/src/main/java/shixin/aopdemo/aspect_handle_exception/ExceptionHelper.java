package shixin.aopdemo.aspect_handle_exception;

import android.util.Log;

import java.io.IOException;

/**
 * 异常测试
 */
public class ExceptionHelper {

    private static final String TAG = ExceptionHelper.class.getSimpleName();

    public void testStart() {
        Log.d(TAG, "testStart");
        try {
            testException();
        } catch (IOException e6666) {
//            e.printStackTrace();
        }
        Log.i(TAG, "testStart over");
    }

    private void testException() throws IOException {
        //抛出异常
        throw new IOException("testStart");
    }
}

