package lukesterlee.c4q.nyc.horoscope;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Willee on 5/7/15.
 */
public class GameFragment extends Fragment {

    View result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        result = inflater.inflate(R.layout.fragment_game, container, false);

        Button button = (Button) result.findViewById()

        return result;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

}
