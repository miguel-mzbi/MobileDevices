package com.mobiledevices.miguel.a170202_activityinclass;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExampleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExampleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExampleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BIG = "big";
    private static final String ARG_MEDIUM = "medium";
    private static final String ARG_SMALL = "small";


    // TODO: Rename and change types of parameters
    private String big, medium, small;

    public ExampleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ExampleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExampleFragment newInstance(String p1, String p2, String p3) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_BIG, p1);
        args.putString(ARG_MEDIUM, p2);
        args.putString(ARG_SMALL, p3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            big = getArguments().getString(ARG_BIG);
            medium = getArguments().getString(ARG_MEDIUM);
            small = getArguments().getString(ARG_SMALL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        TextView t2 = (TextView) view.findViewById(R.id.textView2);
        TextView t3 = (TextView) view.findViewById(R.id.textView3);
        TextView t4 = (TextView) view.findViewById(R.id.textView4);

        t2.setText(big);
        t3.setText(medium);
        t4.setText(small);

        return view;
    }
}