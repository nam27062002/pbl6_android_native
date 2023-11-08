package com.pbl.app_mobile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class HomeFragment extends Fragment {

    MapsFragment mapsFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mapsFragment = new MapsFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.container,mapsFragment).commit();
        return view;
    }


}