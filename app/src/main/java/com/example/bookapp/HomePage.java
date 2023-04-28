package com.example.bookapp;

import android.os.Bundle;
import android.view.MenuInflater;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.bookapp.ui.main.SectionsPagerAdapter;
import com.example.bookapp.databinding.ActivityHomePageBinding;
import org.jetbrains.annotations.NotNull;

public class HomePage extends AppCompatActivity {

    private TabLayout tabLayout;
    private ActivityHomePageBinding binding;
    RecyclerViewAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getSupportActionBar().setElevation(0);

        super.onCreate(savedInstanceState);


        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
//        tabLayout=(TabLayout) findViewById(R.id.tabs);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setIcon(R.drawable.music_icon);
        tabs.getTabAt(1).setIcon(R.drawable.heart_icon);
        tabs.getTabAt(2).setIcon(R.drawable.more_icon);


    }
    //Search Function


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}