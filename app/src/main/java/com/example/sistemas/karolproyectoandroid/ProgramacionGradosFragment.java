package com.example.sistemas.karolproyectoandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sistemas.karolproyectoandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramacionGradosFragment extends Fragment {


    public ProgramacionGradosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programacion_grados, container, false);
    }

}
