package ar.com.AllInNight.ActivitiesQrScanner.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.AllInNight.ActivitiesQrScanner.R;
import ar.com.AllInNight.ActivitiesQrScanner.beans.Car;

public class MyCarManualesFragment extends Fragment implements View.OnClickListener {
    private MaterialButton officialPageButton;
    private MaterialButton manualButton;
    private MaterialButton techicalDetailButton;
    private static final String ARG_My_CAR_SELECTED = "param1";
    private Car myCar;

    public MyCarManualesFragment() {
    }

    public static MyCarManualesFragment newInstance(Car myCar) {
        MyCarManualesFragment fragment = new MyCarManualesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_My_CAR_SELECTED, myCar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myCar = (Car) getArguments().getSerializable(ARG_My_CAR_SELECTED);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_car_manuales, container, false);

        officialPageButton = v.findViewById(R.id.officialPageButton);
        officialPageButton.setOnClickListener(this);
        manualButton = v.findViewById(R.id.manualButton);
        manualButton.setOnClickListener(this);
        techicalDetailButton = v.findViewById(R.id.techicalDetailButton);
        techicalDetailButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.officialPageButton:
                openInBrowser(myCar.getUrlOfficialPage());
                break;
            case R.id.manualButton:
                openInBrowser(myCar.getUrlManuals());
                break;
            case R.id.techicalDetailButton:
                openInBrowser(myCar.getUrlTechnicalDetail());
                break;
        }
    }

    private void openInBrowser(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
