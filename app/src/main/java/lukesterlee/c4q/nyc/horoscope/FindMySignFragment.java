package lukesterlee.c4q.nyc.horoscope;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * Created by Willee on 5/7/15.
 */
public class FindMySignFragment extends Fragment {

    DatePicker picker;
    Button button;
    TextView myDate;
    String sign;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_findsign, container, false);

        picker = (DatePicker) result.findViewById(R.id.datePicker);
        myDate = (TextView) result.findViewById(R.id.myDate);
        button = (Button) result.findViewById(R.id.dateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign = SignCalculator.getSign(picker.getMonth()+1, picker.getDayOfMonth());
                myDate.setText("Your sign is " + sign);
            }
        });



        return result;
    }
}
