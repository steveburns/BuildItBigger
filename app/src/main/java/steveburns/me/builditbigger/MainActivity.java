package steveburns.me.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import steveburns.me.jokeactivity.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(final View view) {

        final Context theContext = this;
        final AsyncTaskResponse asyncTaskResponse = new AsyncTaskResponse() {
            @Override
            public void notifyCaller(final String result) {
                final Intent intent = new Intent(theContext, JokeActivity.class);
                intent.putExtra("joke_text", result);
                theContext.startActivity(intent);
            }
        };

        new EndpointsAsyncTask(asyncTaskResponse).execute(this);
    }

}
