package com.takeoffandroid.tabwithrecyclerview.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.takeoffandroid.tabwithrecyclerview.R;
import com.takeoffandroid.tabwithrecyclerview.fragment.TabFragment;
import com.takeoffandroid.tabwithrecyclerview.utils.Util;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

public class MaterialTabActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    String[] tabs = {"Tab 1","Tab 2","Tab 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_tab);

        findViews();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Drawable plusDrawable = Util.setIconForViews(MaterialTabActivity.this, MaterialDrawableBuilder.IconValue.PLUS,Color.WHITE,24);
        fabAdd.setImageDrawable(plusDrawable);


        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position) {

                    case 0:

                        return TabFragment.newInstance();

                    case 1:

                        return TabFragment.newInstance();

                    case 2:

                        return TabFragment.newInstance();

                }
                return null;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }

            @Override
            public int getCount() {
                return tabs.length;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void findViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        fabAdd = (FloatingActionButton)findViewById(R.id.fab_add);
        mViewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_stocks, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }




}