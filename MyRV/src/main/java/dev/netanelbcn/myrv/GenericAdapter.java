package dev.netanelbcn.myrv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GenericAdapter<T> extends RecyclerView.Adapter<GenericAdapter.GenericViewHolder> {

    private List<T> items;
    private int layoutId;
    private BindViewHolder<T> bindViewHolder;
    private OnItemClickListener<T> itemClickListener;

    public GenericAdapter(List<T> items, int layoutId, BindViewHolder<T> bindViewHolder) {
        this.items = items;
        this.layoutId = layoutId;
        this.bindViewHolder = bindViewHolder;
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new GenericViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        T item = items.get(position);
        bindViewHolder.onBind(holder, item, position);

        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(item, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.itemClickListener = listener;
    }

    public static class GenericViewHolder extends RecyclerView.ViewHolder {
        public GenericViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface BindViewHolder<T> {
        void onBind(GenericViewHolder holder, T item, int position);
    }

    public interface OnItemClickListener<T> {
        void onItemClick(T item, int position);
    }
}