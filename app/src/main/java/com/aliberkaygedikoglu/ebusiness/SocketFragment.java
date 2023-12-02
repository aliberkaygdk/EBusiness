package com.aliberkaygedikoglu.ebusiness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliberkaygedikoglu.ebusiness.databinding.FragmentSocketBinding;


public class SocketFragment extends Fragment {

   private FragmentSocketBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSocketBinding.inflate(inflater, container, false);




        return binding.getRoot();
    }
}