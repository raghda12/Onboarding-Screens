package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
        implements Fragment2.Fragment2Listener, Fragment3.Fragment3Listener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Fragment1 fragment1 = Fragment1.newInstance(null, null);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment1)
                .commit();


        binding.buttonContinue.setOnClickListener(view -> {
            Fragment2 fragment2 = Fragment2.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .addToBackStack(null)
                    .commit();


            binding.buttonContinue.setVisibility(android.view.View.GONE);
        });
    }


    @Override
    public void onContinueClicked(String name, String email, String gender, String university) {

        Fragment3 fragment3 = Fragment3.newInstance(name);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment3)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onCheckboxChanged(boolean isChecked) {
        // Fragment3 بيتحكم بزره الخاص، مش محتاجين نعمل شي هون
    }
}