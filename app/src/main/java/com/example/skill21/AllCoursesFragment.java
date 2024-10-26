package com.example.skill21;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AllCoursesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AllCoursesFragment() {
        // Required empty public constructor
    }
    public static AllCoursesFragment newInstance(String param1, String param2) {
        AllCoursesFragment fragment = new AllCoursesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_courses, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView textView = getView().findViewById(R.id.textfsu);
        ToggleButton toggleButton = getView().findViewById(R.id.star_button_fsu);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("save", Context.MODE_PRIVATE);
        toggleButton.setChecked(sharedPreferences.getBoolean("value",false));
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    SharedPreferences.Editor editor=getActivity().getSharedPreferences("save",Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    toggleButton.setChecked(true);
                }
                else {
                    SharedPreferences.Editor editor=getActivity().getSharedPreferences("save",Context.MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    toggleButton.setChecked(false);
                }
            }
        });
    }
}