package com.example.frankson.zikapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class PrevencaoScreen extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prevencao_screen, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.button_prevencao)
    public void AbreInfo(){
        Intent abrirInfo;
        abrirInfo = new Intent(getContext(), PrevencaoInfo.class);
        startActivity(abrirInfo);
    }
}
