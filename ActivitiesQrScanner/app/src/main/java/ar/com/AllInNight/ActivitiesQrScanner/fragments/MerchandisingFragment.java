package ar.com.AllInNight.ActivitiesQrScanner.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import ar.com.AllInNight.ActivitiesQrScanner.R;
import ar.com.AllInNight.ActivitiesQrScanner.adapters.MyCarMerchandisingAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnMerchandisignListener} interface
 * to handle interaction events.
 * Use the {@link MerchandisingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MerchandisingFragment extends Fragment {
    private OnMerchandisignListener mListener;
    private GridView gridViewMerchandising;
    private MyCarMerchandisingAdapter adapter;

    public MerchandisingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MyCarsAccesoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MerchandisingFragment newInstance() {
        MerchandisingFragment fragment = new MerchandisingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_merchandising, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridViewMerchandising = getActivity().findViewById(R.id.gridViewMerchandising);
        adapter = new MyCarMerchandisingAdapter(this.getContext());
        gridViewMerchandising.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMerchandisignSeleceted(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMerchandisignListener) {
            mListener = (OnMerchandisignListener) context;
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
    public interface OnMerchandisignListener {
        // TODO: Update argument type and name
        void onMerchandisignSeleceted(Uri uri);
    }
}
