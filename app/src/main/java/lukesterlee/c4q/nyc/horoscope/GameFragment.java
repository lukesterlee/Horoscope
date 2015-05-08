package lukesterlee.c4q.nyc.horoscope;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Willee on 5/7/15.
 */
public class GameFragment extends Fragment {

    TextView randomDate;
    TextView remainingTime;
    Button startButton;
    GridView gridview;
    TextView answer;

    String date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_game, container, false);

        startButton = (Button) result.findViewById(R.id.gameStartButton);
        randomDate = (TextView) result.findViewById(R.id.randomDate);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Data.signs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return result;
    }

    @Override
     public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(getArguments().getInt("position"));
    }

    @Override
    public void onStart() {
        super.onStart();

        remainingTime = (TextView) getActivity().findViewById(R.id.timer);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = SignCalculator.getRandomDate();
                randomDate.setText(date);
                gridview = (GridView) getActivity().findViewById(R.id.game_grid_view);
                gridview.setAdapter(new ImageAdapter(getActivity()));

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Toast toast = Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                CountDownTimer timer = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        remainingTime.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        if (getActivity() != null) {
                            remainingTime.setText("Time out!");
                            answer = (TextView) getActivity().findViewById(R.id.gameAnswer);
                            answer.setText("The answer is " + SignCalculator.getAnswer(date));
                        }

                    }
                }.start();
            }
        });




    }

}
