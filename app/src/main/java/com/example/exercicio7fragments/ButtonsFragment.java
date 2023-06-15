package com.example.exercicio7fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ButtonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ButtonsFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ButtonsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButtonsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ButtonsFragment newInstance(String param1, String param2) {
        ButtonsFragment fragment = new ButtonsFragment();
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
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);
        
        Button btnPreto = view.findViewById(R.id.btnPreto);
        btnPreto.setOnClickListener(this);
        Button btnAzul = view.findViewById(R.id.btnAzul);
        btnAzul.setOnClickListener(this);
        Button btnVerde = view.findViewById(R.id.btnVerde);
        btnVerde.setOnClickListener(this);
        Button btnVermelho = view.findViewById(R.id.btnVermelho);
        btnVermelho.setOnClickListener(this);
        Button btnAmarelo = view.findViewById(R.id.btnAmarelo);
        btnAmarelo.setOnClickListener(this);
        


        return view;
    }

    @Override
    public void onClick(View view) {
        Resources res = getResources();
        if (mListener != null) {
            int color = 0;
            if (view.getId() == R.id.btnPreto) {
                color = res.getColor(R.color.black, null);
            } else if (view.getId() == R.id.btnAzul) {
                color = res.getColor(R.color.blue, null);
            } else if (view.getId() == R.id.btnVerde) {
                color = res.getColor(R.color.green, null);
            } else if (view.getId() == R.id.btnVermelho) {
                color = res.getColor(R.color.red, null);
            } else if (view.getId() == R.id.btnAmarelo) {
                color = res.getColor(R.color.yellow, null);
            }
            mListener.onFragmentInteraction(color);
        }
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(int color);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}