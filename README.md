
# Generic Recycler View


## Overview

A library designed to simplify working with RecyclerView in Android applications. It provides basic Adapters and ViewHolders that are easy to adapt and expand as needed. The goal is to make it easier for developers to build scrolling lists quickly and simply, without getting involved with complex code.




## Installation

Install the library by Gradle

To include the Generic RV Library in your Android project, add the following dependency to your project's build.gradle file:

#### If you dowanload the library manually:

```
    implementation(project(":MyRV"))


```



## Usage/Examples

### create a layout_item for example:


```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    app:cardCornerRadius="8dp"
    app:cardElevation="4dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <ImageView
            android:id="@+id/itemImage"
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:scaleType="centerCrop"
            tools:src="@tools:sample/backgrounds/scenic"
            tools:ignore="ContentDescription" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="16dp">

            <TextView
                android:id="@+id/itemTitle"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="18sp"
                android:textStyle="bold"
                tools:text="Item Title" />

            <TextView
                android:id="@+id/itemDescription"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="8dp"
                tools:text="This is a description of the item. It can be a bit longer and will wrap to multiple lines if needed." />

            <Button
                android:id="@+id/itemButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="8dp"
                android:text="View Details" />

        </LinearLayout>

    </LinearLayout>

</androidx.cardview.widget.CardView>
```

### In your main xml layout add a RV:
```java
  <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

```
### Create an item class if needed, for example:
```java
  public class CardItem {
    private int imageResId;
    private String title;
    private String description;

    public CardItem(int imageResId, String title, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
    }

    public int getImageResId() { return imageResId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
```
### And now you can use the library features in the main activity

```java

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
```
## Screenshots

![image](https://github.com/user-attachments/assets/3ce901d8-cc70-41aa-8ff4-9cb4d6e54a54)
![image](https://github.com/user-attachments/assets/6439b483-3820-4e1d-b512-7ce272bec027)
![image](https://github.com/user-attachments/assets/a1436aee-7051-4b15-9338-89ddc28c00eb)

## Watch me!

https://github.com/user-attachments/assets/40b9182a-cb5b-48e7-8ae8-8fa9a28ec476


## License

Copyright (c) 2024 Netanel Boris Cohen Niazov




## Authors

- Netanel Boris Cohen Niazov

