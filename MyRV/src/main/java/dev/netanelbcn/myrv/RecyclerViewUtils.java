package dev.netanelbcn.myrv;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewUtils {

    public static <T> void setupRecyclerView(RecyclerView recyclerView,
                                             List<T> items,
                                             int layoutId,
                                             GenericAdapter.BindViewHolder<T> bindViewHolder,
                                             GenericAdapter.OnItemClickListener<T> itemClickListener) {
        GenericAdapter<T> adapter = new GenericAdapter<>(items, layoutId, bindViewHolder);
        adapter.setOnItemClickListener(itemClickListener);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }
}
