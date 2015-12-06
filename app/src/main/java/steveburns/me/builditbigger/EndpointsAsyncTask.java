package steveburns.me.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.builditbigger.sburns.jokes.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by sburns on 12/1/15.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi sApiService = null;
    private AsyncTaskResponse mAsyncTaskResponse;

    public EndpointsAsyncTask(final AsyncTaskResponse asyncTaskResponse) {
        mAsyncTaskResponse = asyncTaskResponse;
    }

    @Override
    protected String doInBackground(final Context... params) {
        if (sApiService == null) {  // Only do this once
            final MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setRootUrl("http://10.0.2.2:8080/")
//                    .setRootUrl("http://10.0.2.2:8888/")
//                    .setRootUrl("http://0.0.0.0/_ah/api/")
//                    .setRootUrl("http://10.0.2.2/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(final AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            sApiService = builder.build();
        }

        try {
            return sApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(final String result) {

        if (mAsyncTaskResponse != null) {
            mAsyncTaskResponse.notifyCaller(result);
        }
    }
}
