package com.example.bookapp;

import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HymnsFragment extends Fragment {

    private RecyclerView myrecyclerView;
    private ArrayList<Hymns> lstHymn;
    public String[] title;
    public int[] number;
    public String[] sContent;
    RecyclerViewAdapter recyclerAdapter;

    public HymnsFragment() {
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.hymns_fragment, container, false);
        myrecyclerView=(RecyclerView) rootView.findViewById(R.id.hymns_fragment);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setHasOptionsMenu(true);

        title = getResources().getStringArray(R.array.hymns_titles);
        number=getResources().getIntArray(R.array.hymn_numbers);
        sContent=getResources().getStringArray(R.array.hymn_content);

        lstHymn=new ArrayList<>();
        for(int i=0;i<title.length;i++){
            Hymns temp=new Hymns(title,number,sContent);
            lstHymn.add(temp);
        }
        recyclerAdapter=new RecyclerViewAdapter(getContext(),lstHymn,title,number,sContent);
        myrecyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
       inflater.inflate(R.menu.actionbar_menu,menu);
       MenuItem menuItem=menu.findItem(R.id.search);
       SearchView searchView=(SearchView) menuItem.getActionView();
       searchView.setMaxWidth(Integer.MAX_VALUE);
       searchView.setQueryHint("Search hymn...");

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               Log.d("typed",newText);

               recyclerAdapter.getFilter().filter(newText);

               return false;
           }
       });

    }
}