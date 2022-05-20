package com.example.testfinal1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.testfinal1.R;

public class Fragment3 extends Fragment {

    public Fragment3(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle saved){

        return inflater.inflate(R.layout.fragment3,container, false);
    }




}
