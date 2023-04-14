package com.example.notes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class editUser extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragview=inflater.inflate(R.layout.fragment_edit_user, container, false);
        EditText name=fragview.findViewById(R.id.edtname);
        EditText email=fragview.findViewById(R.id.edtemail);
        EditText phone=fragview.findViewById(R.id.edtphone);
        Button btnsubmit=fragview.findViewById(R.id.submit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!name.toString().isEmpty()&&!email.toString().isEmpty()&&!phone.toString().isEmpty()) {
                    String name_data = name.getText().toString();
                    String email_data = email.getText().toString();
                    String phone_data=phone.getText().toString();

                    AppSharedPref.writeToSharedPref(getActivity(),name_data,email_data,phone_data);
                    Navigation.findNavController(fragview).navigate(R.id.action_editUser_to_profile);



                } else {
                    Toast.makeText(getActivity(), "All Data is Required there is wrong data", Toast.LENGTH_SHORT).show();

                }
            }
        });

        // Inflate the layout for this fragment
        return fragview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}