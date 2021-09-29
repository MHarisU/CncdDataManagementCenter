package com.cncd.first.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.cncd.first.R;

public class LoginFragment1 extends Fragment implements View.OnClickListener {
    Button gotoFragment2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);


        gotoFragment2 = view.findViewById(R.id.fragment_fragment1_gotofragment2);
        gotoFragment2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment22);
    }
}
