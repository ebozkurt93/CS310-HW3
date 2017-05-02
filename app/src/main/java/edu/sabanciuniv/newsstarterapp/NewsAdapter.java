package edu.sabanciuniv.newsstarterapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.sabanciuniv.newsstarterapp.model.NewsItem;

/**
 * Created by erdem on 2.05.2017.
 */

public class NewsAdapter extends ArrayAdapter<NewsItem> {

    public NewsAdapter(@NonNull Context context, @NonNull List<NewsItem> objects) {
        super(context,android.R.layout.simple_list_item_1 , objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MyHolder holder = null;
        View row = convertView;

        if(row == null){

            row = ((Activity)getContext()).getLayoutInflater()
                    .inflate(R.layout.news_card,
                            parent,false);

            holder = new MyHolder(row);
            row.setTag(holder);

        }else{

            holder = (MyHolder) row.getTag();


        }


        holder.getNewsImage().setImageResource(getItem(position).getImageId());
        holder.getNewsTitle().setText(getItem(position).getTitle());
        holder.getNewsDate().setText(String.valueOf(getItem(position).getNewsDate()));

        return row;



    }

    class MyHolder{
        private View base;
        private TextView newsTitle;
        private TextView newsDate;
        private ImageView newsImage;


        public MyHolder(View base) {
            this.base = base;
        }

        public TextView getNewsTitle() {
            if(newsTitle == null){
                newsTitle = (TextView)base.findViewById(R.id.news_card_news_title);
            }


            return newsTitle;
        }

        public TextView getNewsDate() {
            if(newsDate == null){
                newsDate = (TextView)base.findViewById(R.id.news_card_news_date);
            }
            return newsDate;
        }

        public ImageView getNewsImage() {

            if(newsImage == null){
                newsImage = (ImageView)base.findViewById(R.id.news_card_news_image);
            }
            return newsImage;
        }
    }



}
