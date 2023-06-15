package com.example.exercicio7fragments;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonsFragment.OnFragmentInteractionListener{


    private ColorsFragment colorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorFragment = (ColorsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentcolors);
    }

    @Override
    public void onFragmentInteraction(int color) {
        colorFragment.definirColor(color);
    }
}