package com.example.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notes.databinding.FragmentFavoriteBinding;
import com.example.notes.databinding.FragmentHomeBinding;


public class favoriteFragment extends Fragment {

private FragmentFavoriteBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView=inflater.inflate(R.layout.fragment_favorite, container, false);
        binding=FragmentFavoriteBinding.bind(fragView);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}