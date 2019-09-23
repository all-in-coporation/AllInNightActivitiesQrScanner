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
 * interface
 * to handle interaction events.
 * Use the {@link BenefictFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BenefictFragment extends Fragment {
    public static final String TAG = "BenefictFragment";
    public BenefictFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment BenefictFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BenefictFragment newInstance() {
        BenefictFragment fragment = new BenefictFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_benefict, container, false);
    }

}
