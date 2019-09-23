package ar.com.AllInNight.ActivitiesQrScanner.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ar.com.AllInNight.ActivitiesQrScanner.R;
import ar.com.AllInNight.ActivitiesQrScanner.adapters.MyCarRecybleViewAdapter;
import ar.com.AllInNight.ActivitiesQrScanner.beans.Car;


public class MyCarsFragment extends Fragment {
    public static final String TAG = "MyCarsFragment";
    private OnMyCarsFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private MyCarRecybleViewAdapter adapter;
    private List<Car> data;
    private String insertData;
    private boolean loading;
    private int loadTimes;


    public MyCarsFragment() {
        // Required empty public constructor
    }

    public static MyCarsFragment newInstance() {
        MyCarsFragment fragment = new MyCarsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();

    }

    private void initData() {
        data = new ArrayList<>();
        Car car = new Car();
        car.setBrand("Fiat");
        car.setDrawableId(R.drawable.fait_toro_transparente);
        car.setModel("Toro");
        car.setPatent("AVC 654 SS");
        car.setVin("XAA767RX666C8X55");
        car.setYear(2018);
        data.add(car);

        car = new Car();
        car.setBrand("Fiat");
        car.setDrawableId(R.drawable.fiat_uno_blanco);
        car.setModel("UNO");
        car.setPatent("BCE 987 BB");
        car.setVin("BAC257RX787C8X55");
        car.setYear(2019);
        data.add(car);

        car = new Car();
        car.setBrand("Fiat");
        car.setDrawableId(R.drawable.fiat_argo);
        car.setModel("ARGO");
        car.setPatent("BTC 654 SS");
        car.setVin("ARC767RA878C8X53");
        car.setYear(2018);
        data.add(car);

        car = new Car();
        car.setBrand("Fiat");
        car.setDrawableId(R.drawable.fiat_punto);
        car.setModel("PUNTO");
        car.setPatent("BCE 987 BB");
        car.setVin("BAC257RX787C8X55");
        car.setYear(2019);
        data.add(car);

        insertData = "0";
        loadTimes = 0;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMyCarsFragmentInteractionListener) {
            mListener = (OnMyCarsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMyCarsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnMyCarsFragmentInteractionListener {
        /**
         * Selecciona un item de My Auto de la lista
         * @param car
         */
        void onMyCarCardSelected(Car car);
    }


    private void initView() {
        mRecyclerView = getActivity().findViewById(R.id.recycler_view_recycler_view);

        if (getScreenWidthDp() >= 1200) {
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            mRecyclerView.setLayoutManager(gridLayoutManager);
        } else if (getScreenWidthDp() >= 800) {
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            mRecyclerView.setLayoutManager(gridLayoutManager);
        } else {
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(linearLayoutManager);
        }

        adapter = new MyCarRecybleViewAdapter(getContext(), mListener);
        mRecyclerView.setAdapter(adapter);
        adapter.setItems(data);
    }

    private int getScreenWidthDp() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return (int) (displayMetrics.widthPixels / displayMetrics.density);
    }
}
