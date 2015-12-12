package steveburns.me.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import steveburns.me.jokeactivity.JokeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        final ProgressBar spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

        FlavorUtils.insertAds(root);

        root.findViewById(R.id.tell_joke_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                tellJoke(view, spinner);
            }
        });
        return root;
    }

    private void tellJoke(final View view, final ProgressBar spinner) {

        spinner.setVisibility(View.VISIBLE);
        final Context theContext = getActivity();
        final AsyncTaskResponse asyncTaskResponse = new AsyncTaskResponse() {
            @Override
            public void notifyCaller(final String result) {

                spinner.setVisibility(View.GONE);
                final Intent intent = new Intent(theContext, JokeActivity.class);
                intent.putExtra("joke_text", result);
                theContext.startActivity(intent);
            }
        };

        new EndpointsAsyncTask(asyncTaskResponse).execute();
    }
}
