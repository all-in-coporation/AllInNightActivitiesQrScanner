package ar.com.AllInNight.ActivitiesQrScanner.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.AllInNight.ActivitiesQrScanner.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BuyCarFilter.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BuyCarFilter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyCarFilter extends Fragment {
    public static final String TAG = "BuyCarFilter";
    public BuyCarFilter() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuyCarFilter.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyCarFilter newInstance(String param1, String param2) {
        BuyCarFilter fragment = new BuyCarFilter();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_car_filter, container, false);
    }
}
