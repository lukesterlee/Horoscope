package lukesterlee.c4q.nyc.horoscope;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Willee on 5/7/15.
 */
public class SignFragment extends ListFragment {

    OnSignSelectedListener mActivityCallBack;

    public interface OnSignSelectedListener {
        public void onSignSelected(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Data.signs);
        setListAdapter(adapter);

    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mActivityCallBack = (OnSignSelectedListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString() + " didn't implement OnSignSelectedListener interface");
        }
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        mActivityCallBack.onSignSelected(position);
    }
}
