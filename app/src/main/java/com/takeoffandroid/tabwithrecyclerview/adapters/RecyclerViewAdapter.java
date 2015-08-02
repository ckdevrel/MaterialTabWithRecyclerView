package com.takeoffandroid.tabwithrecyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.takeoffandroid.tabwithrecyclerview.R;
import com.takeoffandroid.tabwithrecyclerview.models.ModelObject;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private OnItemClickListener clickListener;
    private ArrayList<ModelObject>mArrList;


    public RecyclerViewAdapter(Context context, ArrayList<ModelObject> arrList) {
        this.context = context;
        this.mArrList = arrList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder ViewHolder, int position) {
            ViewHolder.title.setText(mArrList.get(position).getName());
    }

    @Override
    public int getItemCount() {

        return mArrList==null ? 0:mArrList.size();
    }



    public void updateList(ArrayList<ModelObject> filterList) {

        this.mArrList = filterList;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            title = (TextView) itemView.findViewById(R.id.txt_name);

           itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v, mArrList.get(getAdapterPosition()));
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, ModelObject modelObject);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}