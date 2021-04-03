package com.example.bikecliente;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import modelDominio.Bike;

public class BikeAdapter extends RecyclerView.Adapter<BikeAdapter.MyViewHolder> {
    private ArrayList<Bike> listaBikes;
    private BikeOnClickListener BikeOnClickListener;

    public BikeAdapter(ArrayList<Bike> listaBikes, BikeOnClickListener BikeOnClickListener) {
        this.listaBikes = listaBikes;
        this.BikeOnClickListener = BikeOnClickListener;
    }

    @Override
    public BikeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemdalista, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BikeAdapter.MyViewHolder holder, final int position) {
        Bike meuBike = listaBikes.get(position);
        holder.tvModeloBike.setText(meuBike.getModeloBike());
        holder.tvMarcaBike.setText(meuBike.getMarca().getNomeMarca());

        // clique no item do cliente
        if (BikeOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BikeOnClickListener.onClickBike(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaBikes.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvModeloBike, tvMarcaBike;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvModeloBike = itemView.findViewById(R.id.tvModeloBike);
            tvMarcaBike = itemView.findViewById(R.id.tvMarcaBike);
        }
    }

    public interface BikeOnClickListener {
        public void onClickBike(View view, int position);
    }


}