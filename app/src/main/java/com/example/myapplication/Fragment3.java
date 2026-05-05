package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Fragment3 extends Fragment {

    // Interface للـ checkbox
    public interface Fragment3Listener {
        void onCheckboxChanged(boolean isChecked);
    }

    private Fragment3Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment3Listener) {
            listener = (Fragment3Listener) context;
        }
    }


    public static Fragment3 newInstance(String name) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);


        TextView tvName = view.findViewById(R.id.tvName);
        CheckBox checkBox = view.findViewById(R.id.checkBox);
        Button btnFinish = view.findViewById(R.id.btnFinish);


        if (getArguments() != null) {
            String name = getArguments().getString("name");
            tvName.setText("Welcome, " + name + "!");
        }


        btnFinish.setEnabled(false);


        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                btnFinish.setEnabled(true);
                btnFinish.setText("Finish");
            } else {
                btnFinish.setEnabled(false);
                btnFinish.setText("Continue");
            }


            if (listener != null) {
                listener.onCheckboxChanged(isChecked);
            }
        });

        return view;
    }
}