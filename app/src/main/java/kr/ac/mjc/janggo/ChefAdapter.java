package kr.ac.mjc.janggo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.ac.mjc.janggo.dto.Chef;

public class ChefAdapter extends RecyclerView.Adapter<ChefAdapter.ChefViewHolder> {

    private List<Chef> chefList;
    private OnItemClickListener onItemClick;

    public interface OnItemClickListener {
        void onClick(Chef chef);
    }

    public ChefAdapter(List<Chef> chefList, OnItemClickListener onItemClick) {
        this.chefList = chefList;
        this.onItemClick = onItemClick;
    }

    public static class ChefViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView description;

        public ChefViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.chef_image);
            name = itemView.findViewById(R.id.chef_name);
            description = itemView.findViewById(R.id.chef_description);
        }
    }

    @NonNull
    @Override
    public ChefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chef, parent, false);
        return new ChefViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChefViewHolder holder, int position) {
        Chef chef = chefList.get(position);

        holder.image.setImageResource(chef.getImage());
        holder.name.setText(chef.getName());
        holder.description.setText(chef.getDescription());

        holder.itemView.setOnClickListener(v -> {
            if (onItemClick != null) {
                onItemClick.onClick(chef);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chefList.size();
    }
}