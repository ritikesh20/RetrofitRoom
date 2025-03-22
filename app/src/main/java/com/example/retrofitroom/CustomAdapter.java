package com.example.retrofitroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitroom.Listeners.SelectListener;
import com.example.retrofitroom.model.NewsHeadline;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<NewsHeadline> headlineList;
    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadline> headlineList, SelectListener listener) {
        this.context = context;
        this.headlineList = headlineList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headkube_list_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        NewsHeadline currentHeadline = headlineList.get(position);

        holder.text_title.setText(currentHeadline.getTitle());

        String imageUrl = currentHeadline.getUrlToImage();
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.not_available)
                    .error(R.drawable.not_available)
                    .fit()
                    .centerCrop()
                    .into(holder.img_headline);
        } else {
            Picasso.get()
                    .load(R.drawable.not_available)  // Placeholder for missing images
                    .into(holder.img_headline);
        }

        // Set the author name
        //holder.text_author.setText(currentHeadline.getSource().getName());
        if (currentHeadline.getSource() != null && currentHeadline.getSource().getName() != null) {
            holder.text_author.setText(currentHeadline.getSource().getName());
        } else {
            holder.text_author.setText("Unknown Source");
        }

        // Set click listener on CardView
        holder.cardView.setOnClickListener(v -> listener.OnNewsClicked(currentHeadline));

    }

    @Override
    public int getItemCount() {
        return headlineList.size();
    }
}
