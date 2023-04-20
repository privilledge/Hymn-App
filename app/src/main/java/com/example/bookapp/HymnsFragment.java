package com.example.bookapp;

import android.os.Bundle;
import android.view.*;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HymnsFragment extends Fragment {

    private RecyclerView myrecyclerView;
    private List<Hymns> lstHymn;
    public String[] title;
    public int[] number;
    public String[] sContent;

    public HymnsFragment() {
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.hymns_fragment, container, false);
        myrecyclerView=(RecyclerView) rootView.findViewById(R.id.hymns_fragment);
        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(getContext(),lstHymn,title,number,sContent);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         title = getResources().getStringArray(R.array.hymns_titles);
         number=getResources().getIntArray(R.array.hymn_numbers);
         sContent=getResources().getStringArray(R.array.hymn_content);




        lstHymn=new ArrayList<>();
        for(int i=0;i<title.length;i++){
            Hymns temp=new Hymns();
            lstHymn.add(temp);
        }



    }
}