package com.example.bookapp;

import android.os.Bundle;
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

public class HomePage extends AppCompatActivity {

    private TabLayout tabLayout;
    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
}