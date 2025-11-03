package com.example.tfc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class NavFragment extends Fragment {

    public NavFragment() {
        // Constructor vacío
    }

    public static NavFragment newInstance() {
        return new NavFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar solo el layout de contenido del fragment
        return inflater.inflate(R.layout.fragment_nav, container, false);
    }
}
