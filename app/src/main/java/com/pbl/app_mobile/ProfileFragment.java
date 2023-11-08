package com.pbl.app_mobile;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.pbl.app_mobile.model.BEAN.Profile.Profile;
import com.pbl.app_mobile.model.BEAN.Profile.ProfileRespone;
import com.pbl.app_mobile.model.BEAN.User.UserResponse;
import com.pbl.app_mobile.model.DO.LoginDO;
import com.pbl.app_mobile.model.DO.ProfileDO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {

    TextView name;
    EditText email;
    EditText phone;
    EditText address;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.address);
        ProfileDO.getInstance().getProfileById(LoginDO.userId).enqueue(new Callback<ProfileRespone>() {
            @Override
            public void onResponse(Call<ProfileRespone> call, Response<ProfileRespone> response) {

                Profile data = response.body().getData().getUser();
                name.setText(data.getFullName());
                email.setText(data.getEmail());
                phone.setText(data.getPhNo());
                if(address!=null){
                    address.setText(data.getAddress().toString());
                }


            }

            @Override
            public void onFailure(Call<ProfileRespone> call, Throwable t) {

            }
        });

        return view;
    }
}