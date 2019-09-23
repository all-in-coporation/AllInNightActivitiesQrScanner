package ar.com.AllInNight.ActivitiesQrScanner.fragments;

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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CarDealerTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarDealerTabFragment extends Fragment {
    public static final String TAG = "CarDealerTabFragment";
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    public CarDealerTabFragment() {
        // Required empty public constructor
    }

    public static CarDealerTabFragment newInstance() {
        CarDealerTabFragment fragment = new CarDealerTabFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_car_tab, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CarDealersFragmentAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }

    class CarDealersFragmentAdapter extends FragmentPagerAdapter {

        public CarDealersFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return BuyCarFragment.newInstance();
                case 1:
                    return MyCarsAccesoriesFragment.newInstance();
                case 2:
                    return MerchandisingFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return getString(R.string.title_find_concesionaria_buy);
                case 1:
                    return "Accesorios";
                case 2:
                    return "Merchandising";
            }
            return null;
        }
    }
}
