package com.example.bookapp;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MoreFragment extends Fragment{

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.more_fragment, container, false);

        return rootView;
    }


}