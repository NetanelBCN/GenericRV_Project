package dev.netanelbcn.genericrv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

import dev.netanelbcn.myrv.RecyclerViewUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Create a list of custom objects instead of just strings
        List<CardItem> items = Arrays.asList(
                new CardItem(R.drawable.image1, "Item 1", "Description 1"),
                new CardItem(R.drawable.image2, "Item 2", "Description 2"),
                new CardItem(R.drawable.image3, "Item 3", "Description 3"),
                new CardItem(R.drawable.image4, "Item 4", "Description 4"),
                new CardItem(R.drawable.image5, "Item 5", "Description 5")
        );

        RecyclerViewUtils.setupRecyclerView(
                recyclerView,
                items,
                R.layout.my_card,
                (holder, item, position) -> {
                    ImageView imageView = holder.itemView.findViewById(R.id.itemImage);
                    TextView titleView = holder.itemView.findViewById(R.id.itemTitle);
                    TextView descriptionView = holder.itemView.findViewById(R.id.itemDescription);

                    imageView.setImageResource(item.getImageResId());
                    titleView.setText(item.getTitle());
                    descriptionView.setText(item.getDescription());

                    holder.itemView.findViewById(R.id.itemButton).setOnClickListener(v ->
                            Toast.makeText(this, "Button clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show()
                    );
                },
                (item, position) -> Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show()
        );
    }
}