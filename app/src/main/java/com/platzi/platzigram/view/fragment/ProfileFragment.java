package com.platzi.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.platzigram.R;
import com.platzi.platzigram.adapter.PictureAdapterRecyclerView;
import com.platzi.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://orig03.deviantart.net/9657/f/2010/281/4/6/summer_forrest_by_willowhisperer-d30bgb2.jpg", "Joseph Carhuaz", "4 días", "3 Me gusta"));
        pictures.add(new Picture("http://tnstateparks.com/assets/images/content-images/101/nathan-bedford-forrest__full.jpg", "Darwin Villagomez", "3 días", "10 Me gusta"));
        pictures.add(new Picture("https://media-cdn.tripadvisor.com/media/photo-s/08/1f/83/34/forrest-hills-mountain.jpg", "Anibal Gutiérrez", "2 días", "9 Me gusta"));
        pictures.add(new Picture("https://www.google.com/logos/doodles/2016/mothers-day-2016-argentina-6535321338511360-hp2x.jpg", "Resilente Trend", "5 días", "14 Me gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
