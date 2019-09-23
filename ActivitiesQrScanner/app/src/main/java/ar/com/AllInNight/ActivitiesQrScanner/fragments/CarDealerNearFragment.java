package ar.com.AllInNight.ActivitiesQrScanner.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ar.com.AllInNight.ActivitiesQrScanner.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CarDealerNearFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarDealerNearFragment extends Fragment implements View.OnClickListener {
    private CardView fiatCardView;
    private CardView toyotaCardView;
    private CardView vwCardView;
    private CardView peugeotCardView;
    private ImageView imageMaps;

    public CarDealerNearFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CarDealerNearFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarDealerNearFragment newInstance() {
        CarDealerNearFragment fragment = new CarDealerNearFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fiatCardView = view.findViewById(R.id.fiatCardView);
        fiatCardView.setOnClickListener(this);

        toyotaCardView = view.findViewById(R.id.toyotaCardView);
        toyotaCardView.setOnClickListener(this);

        vwCardView = view.findViewById(R.id.vwCardView);
        vwCardView.setOnClickListener(this);

        peugeotCardView = view.findViewById(R.id.peugeotCardView);
        peugeotCardView.setOnClickListener(this);

        imageMaps = view.findViewById(R.id.imageMaps);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_near_car_dealers, container, false);
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        if (R.id.fiatCardView == v.getId()){
            imageMaps.setImageResource(R.drawable.maps02);
        }
        else if (R.id.toyotaCardView == v.getId()){
            imageMaps.setImageResource(R.drawable.maps03);
        }
        else {
            imageMaps.setImageResource(R.drawable.maps01);
        }
    }
}
