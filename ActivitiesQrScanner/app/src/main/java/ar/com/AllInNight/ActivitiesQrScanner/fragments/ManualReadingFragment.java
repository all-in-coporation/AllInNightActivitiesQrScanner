package ar.com.AllInNight.ActivitiesQrScanner.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.AllInNight.ActivitiesQrScanner.R;

import com.google.android.gms.plus.PlusOneButton;

public class ManualReadingFragment extends Fragment {
    public static final String TAG =  "ManualReadingFragment";
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    private final String PLUS_ONE_URL = "http://developer.android.com";
    private MaterialButton digitarChasisButton;

    private OnManualReadingFragmentInteractionListener mListener;

    public ManualReadingFragment() {
        // Required empty public constructor
    }

    public static ManualReadingFragment newInstance() {
        ManualReadingFragment fragment = new ManualReadingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manual_reading, container, false);

        //Find the +1 button
        digitarChasisButton = view.findViewById(R.id.digitarChasisButton);
        digitarChasisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onManualReadingClicked();
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnManualReadingFragmentInteractionListener) {
            mListener = (OnManualReadingFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnManualReadingFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnManualReadingFragmentInteractionListener {
        void onManualReadingClicked();
    }

}
