package ar.com.AllInNight.ActivitiesQrScanner.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.AllInNight.ActivitiesQrScanner.R;
import ar.com.AllInNight.ActivitiesQrScanner.beans.Car;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyCarTabFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyCarTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCarTabFragment extends Fragment {
    private static final String ARG_My_CAR_SELECTED = "param1";
    private Car myCar;
    private OnFragmentInteractionListener mListener;
    public static final String TAG = "MyCarTabFragment";
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;

    public MyCarTabFragment() {
        // Required empty public constructor
    }

    public static MyCarTabFragment newInstance(Car myCar) {
        MyCarTabFragment fragment = new MyCarTabFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_car_tab, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyCarTabFragmentAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMerchandisignListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    class MyCarTabFragmentAdapter extends FragmentPagerAdapter {

        public MyCarTabFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MyCarInfoFragment.newInstance("","");
                case 1:
                    return MyCarManualesFragment.newInstance(myCar);
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return getString(R.string.title_my_car_tab_info);
                case 1:
                    return getString(R.string.title_my_car_tab_manuals);
            }
            return null;
        }
    }
}
