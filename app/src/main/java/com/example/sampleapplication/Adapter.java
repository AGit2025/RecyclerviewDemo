package com.example.sampleapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.NameViewHolder>{
    List<String> listdata;

    public Adapter(List<String> listdata) {
        this.listdata=listdata;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NameViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.names_list,parent,false)
          );
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
      holder.tv1.setText(listdata.get(position));
      holder.tv2.setText(listdata.get(position));
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public class NameViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tvname);
            tv2=itemView.findViewById(R.id.tvsur);
        }
    }
}
