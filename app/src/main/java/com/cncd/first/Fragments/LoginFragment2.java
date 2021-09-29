package com.cncd.first.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cncd.first.R;
import com.cncd.first.UIs.MainActivity;
import com.google.android.material.button.MaterialButton;

public class LoginFragment2 extends Fragment implements View.OnClickListener{

    MaterialButton frag_log2_loginBttn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        frag_log2_loginBttn = view.findViewById(R.id.frag_log2_loginBttn);
        frag_log2_loginBttn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(getActivity(), MainActivity.class));

    }
}
