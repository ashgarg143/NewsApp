package com.example.ashis.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listItem;
    private Context context;

    public MyAdapter(List<ListItem> listItem) {
        this.listItem = listItem;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {


        final ListItem currentListItem = listItem.get(position);
        Picasso.get().load(currentListItem.getImageUrl()).into(holder.imageView);
        holder.titleView.setText(currentListItem.getTitle());
        holder.descView.setText(currentListItem.getDesc());
        String source="- by  ";
        holder.sourceView.setText(currentListItem.getSource());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = currentListItem.getNewsUrl();
                Uri newsUri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, newsUri);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleView;
        private TextView descView;
        private TextView sourceView;

        ViewHolder(View listItemView) {
            super(listItemView);
            context=listItemView.getContext();
            imageView = listItemView.findViewById(R.id.image_view);
            titleView = listItemView.findViewById(R.id.text_view_title);
            descView = listItemView.findViewById(R.id.text_view_desc);
            sourceView = listItemView.findViewById(R.id.text_view_source);


        }
    }
}
