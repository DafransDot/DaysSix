package com.example.dayssix;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    private ArrayList<ListModel> listModels;
    private OnItemClickListener mListener;

    public AdapterList(ArrayList<ListModel> listModels) {
        this.listModels = listModels;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false );
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.ViewHolder holder, int position) {
        holder.namaPlayer.setText(listModels.get(position).getNamaPlayer());
        holder.logo.setImageResource(listModels.get(position).getFotoPlayer());
        holder.umurPlayer.setText(listModels.get(position).getUmurPlayer());
        holder.negaraPlayer.setText(listModels.get(position).getNegaraPlayer());
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaPlayer, umurPlayer, negaraPlayer;
        ImageView logo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaPlayer = itemView.findViewById(R.id.nama);
            logo = itemView.findViewById(R.id.logo);
            umurPlayer = itemView.findViewById(R.id.umur);
            negaraPlayer = itemView.findViewById(R.id.negara);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null ){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION ){
                            mListener.onItemClick(position);
                        }
                    }

                }
            });

        }
    }
}
