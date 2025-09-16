package com.example.dish;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {
    private final List<Dish> dishes;

    public DishAdapter(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dish, parent, false);
        return new DishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        Dish dish = dishes.get(position);
        holder.imageView.setImageResource(dish.imageResId);
        holder.nameTextView.setText(dish.name);
        holder.timeTextView.setText(dish.cookTime);
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    static class DishViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, timeTextView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewDish);
            nameTextView = itemView.findViewById(R.id.textViewName);
            timeTextView = itemView.findViewById(R.id.textViewCookTime);
        }
    }
}

