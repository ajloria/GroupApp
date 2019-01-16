package jdhami4.tcss450.uw.edu.fragmentslab;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        Button b = (Button) v.findViewById(R.id.button_first_red);
        b.setOnClickListener(this); //add this Fragment Object as the OnClickListener
        b = (Button) v.findViewById(R.id.button_first_green);
        //Use a Lamda expression to add the OnClickListener
        b.setOnClickListener(view -> mListener.onFragmentInteraction(Color.GREEN));
        b = (Button) v.findViewById(R.id.button_first_blue);
        //Use a method reference to add the OnClickListener
        b.setOnClickListener(this::setBlue);

        b = (Button) v.findViewById(R.id.button_UWpurple);
        //Use a Lamda expression to add the OnClickListener
        b.setOnClickListener(view -> mListener.onFragmentInteraction(Color.rgb(51, 0, 111)));

        b = (Button) v.findViewById(R.id.button_UWgold);
        //Use a Lamda expression to add the OnClickListener
        b.setOnClickListener(view -> mListener.onFragmentInteraction(Color.rgb(232, 211, 162)));

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            switch (view.getId()) {
                case R.id.button_first_red:
                    mListener.onFragmentInteraction(Color.RED);
                    break;
                default:
                    Log.wtf("", "Didn't expect to see me...");
            }
        }
    }
    public void setBlue(View view) {
        if (mListener != null) {
            mListener.onFragmentInteraction(Color.BLUE);
        }
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
        // TODO: Update argument type and name
        void onFragmentInteraction(int color);
    }
}
