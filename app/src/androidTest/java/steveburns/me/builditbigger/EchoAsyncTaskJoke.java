package steveburns.me.builditbigger;

import android.test.AndroidTestCase;
import android.text.TextUtils;

/**
 * Created by sburns on 12/5/15.
 */
public class EchoAsyncTaskJoke extends AndroidTestCase {

    public void testVerifyAsyncJokeResponse() {
        final AsyncTaskResponse asyncTaskResponse = new AsyncTaskResponse() {
            @Override
            public void notifyCaller(String result) {
                assertTrue(TextUtils.isEmpty(result));
            }
        };
        new EndpointsAsyncTask(asyncTaskResponse).execute(getContext());
    }
}
