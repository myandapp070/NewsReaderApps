package com.example.newsreaderapps.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsreaderapps.NewActivity;
import com.example.newsreaderapps.R;
import com.example.newsreaderapps.models.Article;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mContext;
    private List<Article> mArticle = new ArrayList<>();

    public NewsAdapter(Context context, List<Article> articles) {
        this.mContext = context;
        this.mArticle = articles;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_row_items, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        Glide.with(mContext).load(mArticle.get(position).getUrlToImage()).into(holder.getUrlToImage());
        holder.getTitle().setText(mArticle.get(position).getTitle());
        holder.getPublishedAt().setText(mArticle.get(position).getPublishedAt());
        holder.getDescription().setText(mArticle.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NewActivity.class);
                intent.putExtra("URL_TO_IMAGE", mArticle.get(position).getUrlToImage());
                intent.putExtra("TITLE", mArticle.get(position).getTitle());
                intent.putExtra("PUBLISHED_AT", mArticle.get(position).getPublishedAt());
                intent.putExtra("DESCRIPTION", mArticle.get(position).getDescription());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mArticle.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView urlToImage;
        TextView title, publishedAt, description;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            urlToImage = itemView.findViewById(R.id.news_image);
            title = itemView.findViewById(R.id.news_title);
            publishedAt = itemView.findViewById(R.id.news_published_at);
            description = itemView.findViewById(R.id.news_description);
        }

        public ImageView getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(ImageView urlToImage) {
            this.urlToImage = urlToImage;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(TextView publishedAt) {
            this.publishedAt = publishedAt;
        }

        public TextView getDescription() {
            return description;
        }

        public void setDescription(TextView description) {
            this.description = description;
        }
    }
}
