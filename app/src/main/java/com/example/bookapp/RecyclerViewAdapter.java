package com.example.bookapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable{
    Context mContext;
    ArrayList<Hymns> lstHymn;
    ArrayList<Hymns> hymnsArrayListFull;
    private String[] sTitles;
    private int[] sNumbers;
    private String[] sContent;

    RecyclerViewAdapter(Context mContext, ArrayList<Hymns> lstHymn, String[] title, int[] sNumbers, String[] sContent) {
        this.mContext = mContext;
        this.sTitles = title;
        this.sNumbers = sNumbers;
        this.sContent = sContent;
        this.hymnsArrayListFull = lstHymn;
        this.lstHymn=new ArrayList<>(lstHymn);

    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_hymn, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        String title = sTitles[position];
        int numbers = sNumbers[position];
        holder.tv_title.setText(title);
        holder.tv_number.setText(Integer.toString(numbers));

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title,hymn_content;
        private TextView tv_number;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // implement onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Details.class);
                    // send hymns title and contents through recyclerview to detail activity
                    i.putExtra("titleOfStory",sTitles[getAdapterPosition()]);
                    i.putExtra("contentOfStory",sContent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });

            tv_title=(TextView) itemView.findViewById(R.id.hymn_title);
            tv_number=(TextView) itemView.findViewById(R.id.hymn_number);
            hymn_content=(TextView) itemView.findViewById(R.id.contentOfStory);
        }
    }

    @Override
    public int getItemCount() {
        return lstHymn.size();
    }

    public Filter getFilter() {
        return hymnFilter;
    }
    private Filter hymnFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Hymns> filteredList=new ArrayList<>();
            if(constraint==null || constraint.length()==0){
                filteredList.addAll(hymnsArrayListFull);
            }else{
                String filterPattern=constraint.toString().toLowerCase().trim();
                for(Hymns item:hymnsArrayListFull){
                    if(Arrays.toString(item.getTitle()).toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filteredList;
            results.count=filteredList.size();
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
        lstHymn.clear();
        lstHymn.addAll((ArrayList) results.values);
        notifyDataSetChanged();
        }
    };

}
