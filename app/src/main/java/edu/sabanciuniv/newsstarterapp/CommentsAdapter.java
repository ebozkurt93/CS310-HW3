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

import edu.sabanciuniv.newsstarterapp.model.CommentItem;

/**
 * Created by erdem on 2.05.2017.
 */

    public class CommentsAdapter extends ArrayAdapter<CommentItem> {

        public CommentsAdapter(@NonNull Context context, @NonNull List<CommentItem> objects) {
            super(context,android.R.layout.simple_list_item_1 , objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            edu.sabanciuniv.newsstarterapp.CommentsAdapter.MyHolder holder = null;
            View row = convertView;

            if(row == null){

                row = ((Activity)getContext()).getLayoutInflater()
                        .inflate(R.layout.comments_card,
                                parent,false);

                holder = new edu.sabanciuniv.newsstarterapp.CommentsAdapter.MyHolder(row);
                row.setTag(holder);

            }else{

                holder = (edu.sabanciuniv.newsstarterapp.CommentsAdapter.MyHolder) row.getTag();


            }

            //
            holder.getCommentAuthor().setText(getItem(position).getName());
            holder.getCommentText().setText(String.valueOf(getItem(position).getMessage()));

            return row;



        }

        class MyHolder{
            private View base;
            private TextView newsTitle;
            private TextView newsDate;


            public MyHolder(View base) {
                this.base = base;
            }

            public TextView getCommentAuthor() {
                if(newsTitle == null){
                    newsTitle = (TextView)base.findViewById(R.id.comments_card_author);
                }


                return newsTitle;
            }

            public TextView getCommentText() {
                if(newsDate == null){
                    newsDate = (TextView)base.findViewById(R.id.comments_card_text);
                }
                return newsDate;
            }

        }

    }
