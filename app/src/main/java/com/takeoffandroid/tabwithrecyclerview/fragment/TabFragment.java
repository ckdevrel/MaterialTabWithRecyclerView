package com.takeoffandroid.tabwithrecyclerview.fragment;

import android.app.SearchManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.takeoffandroid.tabwithrecyclerview.R;
import com.takeoffandroid.tabwithrecyclerview.adapters.RecyclerViewAdapter;
import com.takeoffandroid.tabwithrecyclerview.models.ModelObject;

import java.util.ArrayList;
import java.util.List;


public class TabFragment extends Fragment {
    private RecyclerViewAdapter mAdapter;
    private ArrayList<ModelObject> mArrList = new ArrayList<ModelObject>();

    public static TabFragment newInstance() {
        TabFragment tabFragment = new TabFragment();
        return tabFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        for(int i = 0; i<20;i++){
            mArrList.add(new ModelObject("list"+ i));
        }

        mAdapter = new RecyclerViewAdapter(getActivity(),mArrList);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ModelObject modelObject) {

                Toast.makeText(getActivity(),"Name: "+modelObject.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_actionbar, menu);
        final SearchView searchView = (SearchView) MenuItemCompat
                .getActionView(menu.findItem(R.id.action_search));

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(getActivity().SEARCH_SERVICE);
        searchView.setSearchableInfo (searchManager.getSearchableInfo (getActivity().getComponentName()));

        //changing edittext color
        EditText searchEdit = ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text));
        searchEdit.setTextColor(Color.WHITE);
        searchEdit.setHint("Search...");
        searchEdit.setHintTextColor(Color.WHITE);
        searchEdit.setCursorVisible(true);
        searchEdit.setFocusable(true);
        searchEdit.setFocusableInTouchMode(true);

        View v = searchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
        v.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                ArrayList<ModelObject> filterList = new ArrayList<ModelObject>();
                if(s.length()>0){
                    for(int i = 0; i<mArrList.size();i++){

                        if(mArrList.get(i).getName().toLowerCase().contains(s.toString().toLowerCase())){

                            filterList.add(mArrList.get(i));
                            mAdapter.updateList(filterList);
                        }
                    }

                }else{

                    mAdapter.updateList(mArrList);

                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId ()) {


            case R.id.action_search:


                return true;

            case android.R.id.home:

                return true;

            default:
                return super.onOptionsItemSelected (item);
        }
    }

}