package com.example.bookapp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Hymns> mData;
    private String[] sTitles;
    private int[] sNumbers;
    private String[] sContent;

    RecyclerViewAdapter(Context mContext, List<Hymns> mData, String[] title, int[] sNumbers,String[] sContent) {
        this.mContext = mContext;
        this.mData = mData;
        this.sTitles = title;
        this.sNumbers = sNumbers;
        this.sContent=sContent;
    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_hymn,parent,false);
        MyViewHolder vHolder=new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        String title =sTitles[position];
        int numbers = sNumbers[position];
//        String content=sContent[position];
    holder.tv_title.setText(title);
    holder.tv_number.setText(Integer.toString(numbers));
//    holder.hymn_content.setText(content);

//        holder.number.setText(String.valueOf(title.charAt(0)));
    }

    @Override
    public int getItemCount() {
        return mData.size();
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
                    // send story title and contents through recyclerview to detail activity
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
}
