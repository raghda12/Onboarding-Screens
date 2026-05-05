package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {

    public static Fragment2Binding fragment2Binding;


    public interface Fragment2Listener {
        void onContinueClicked(String name, String email, String gender, String university);
    }

    private Fragment2Listener listener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment2Listener) {
            listener = (Fragment2Listener) context;
        }
    }

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment2Binding = Fragment2Binding.inflate(inflater, container, false);

        fragment2Binding.buttonContinue.setOnClickListener(view -> {
            String name = fragment2Binding.etName.getText().toString().trim();
            String email = fragment2Binding.etEmail.getText().toString().trim();
            String university = fragment2Binding.etUniversity.getText().toString().trim();


            String gender = "";
            int selectedId = fragment2Binding.rgGender.getCheckedRadioButtonId();
            if (selectedId == R.id.rbMale) {
                gender = "Male";
            } else if (selectedId == R.id.rbFemale) {
                gender = "Female";
            }

            if (name.isEmpty()) {
                fragment2Binding.etName.setError("Please enter your name");
                return;
            }


            if (listener != null) {
                listener.onContinueClicked(name, email, gender, university);
            }
        });

        return fragment2Binding.getRoot();
    }
}