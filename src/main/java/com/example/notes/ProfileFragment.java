package com.example.notes;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.service.controls.actions.ModeAction;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notes.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public AppSharedPref sharedPreferences;
public TextView  viewNamehere;  //using bunble from the register activity to this fragment to view requested data
  public  TextView viewEmailhere;
    public TextView viewPhonehere;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView2=inflater.inflate(R.layout.fragment_profile, container, false);

        binding = FragmentProfileBinding.bind(fragView2);

                    //////////////////////////////////////// getting the data from Register to this fragment by bundle
        //Bundle bundle = getArguments();
        // String viewName= bundle.getString("mname");
        //viewNamehere.setText(viewName);
        //String viewEmail= bundle.getString("memail");
        //viewEmailhere.setText(viewEmail);
        //String viewPhone= bundle.getString("mphone");
        //viewPhonehere.setText(viewPhone);
        //viewNamehere=getActivity();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


         binding.viewname.setText(AppSharedPref.getName(getContext()));
       binding.viewemail.setText(AppSharedPref.getemail(getContext()));
       binding.viewphone.setText(AppSharedPref.getphone(getContext()));
       Button btnremove=binding.removeaccount;
Button btnedit=binding.editdata;


      //showname=AppSharedPref.getName(getContext("name"));
        //showemail=viewEmailhere;
        //showphone=viewPhonehere;

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppSharedPref.getSharedPref(getContext()).edit().clear().apply();
                startActivity(new Intent(getActivity(),RegisterScreen.class));

                Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_profile_to_editUser);

                Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();

            }
        });



    }



}