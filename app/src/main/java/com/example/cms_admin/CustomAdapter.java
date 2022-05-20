package com.example.cms_admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder>
{

    ArrayList<Club_Details> arrayList;
    OnItemClickListner listner;

    public CustomAdapter(ArrayList<Club_Details> arrayList,OnItemClickListner listner) {
        this.arrayList = arrayList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.club_row,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.logo.setImageResource(arrayList.get(position).getLogo());
        holder.textName.setText(arrayList.get(position).getName());
        holder.textType.setText(arrayList.get(position).getType());
        holder.bind(arrayList.get(position),listner);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class Holder extends RecyclerView.ViewHolder
    {

        ImageView logo;
        TextView textName;
        TextView textType;

        public Holder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.img);
            textName = itemView.findViewById(R.id.txt_club_name);
            textType = itemView.findViewById(R.id.txt_club_type);
        }

        public void bind(final Club_Details item, final OnItemClickListner listener) {
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }

    public void filterList(ArrayList<Club_Details> filterllist) {
        arrayList = filterllist;
        notifyDataSetChanged();
    }
}
