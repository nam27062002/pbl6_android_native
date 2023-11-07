package com.pbl.app_mobile;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pbl.app_mobile.model.BEAN.Profile.Profile;


public class MenuFragment extends Fragment {

    LinearLayout profile;
    ProfileFragment profileFragment;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        profile = view.findViewById(R.id.profile);
        profileFragment = new ProfileFragment();
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.frag,profileFragment).commit();
            }
        });

        return view;
    }
}