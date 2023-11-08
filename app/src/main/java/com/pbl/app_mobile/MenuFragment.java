package com.pbl.app_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.pbl.app_mobile.data.User;
import com.pbl.app_mobile.model.BEAN.Profile.Profile;


public class MenuFragment extends Fragment {

    LinearLayout profile;
    ProfileFragment profileFragment;
    Button aboutUsButton;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        profile = view.findViewById(R.id.profile);
        aboutUsButton = view.findViewById(R.id.aboutButton);
        profileFragment = new ProfileFragment();
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.frag,profileFragment).commit();
            }
        });

        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getActivity(), AboutUsActivity.class);
                 startActivity(intent);
            }
        });

        return view;
    }
}