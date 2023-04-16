package com.example.bookapp;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HymnsFragment extends Fragment {

    private RecyclerView myrecyclerView;
    private List<Favourite> lstHymn;
    public HymnsFragment() {
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.hymns_fragment, container, false);
        myrecyclerView=(RecyclerView) rootView.findViewById(R.id.hymns_fragment);
        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(getContext(),lstHymn);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstHymn=new ArrayList<>();
        lstHymn.add(new Favourite("Mutsvene mutsvene Mwari wesimba","1"));
        lstHymn.add(new Favourite("kudzai mambo ano utsvene","2"));
        lstHymn.add(new Favourite("Imi mose muri pasi","3"));
        lstHymn.add(new Favourite("Mwari muri zuva redu","4"));
        lstHymn.add(new Favourite("Ngatmukudze Mwari","5"));
        lstHymn.add(new Favourite("Jehovha unamasimba","6"));

        lstHymn.add(new Favourite("Mutsvene mutsvene Mwari wesimba","7"));
        lstHymn.add(new Favourite("kudzai mambo ano utsvene","8"));
        lstHymn.add(new Favourite("Imi mose muri pasi","9"));
        lstHymn.add(new Favourite("Mwari muri zuva redu","10"));
        lstHymn.add(new Favourite("Ngatmukudze Mwari","11"));
        lstHymn.add(new Favourite("Jehovha unamasimba","12"));
    }
}