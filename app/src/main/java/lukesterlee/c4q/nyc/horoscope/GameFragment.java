package lukesterlee.c4q.nyc.horoscope;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Willee on 5/7/15.
 */
public class GameFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_game, container, false);

        TextView randomDate = (TextView) result.findViewById(R.id.randomDate);
        randomDate.setText(SignCalculator.getRandomDate());

        return result;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

}
