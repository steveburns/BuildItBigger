package steveburns.me.jokeactivity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        Intent intent = getActivity().getIntent();
        String jokeText = intent.getStringExtra("joke_text");

        TextView textView = (TextView)view.findViewById(R.id.joke_view);
        textView.setText(jokeText);

        return view;
    }
}
