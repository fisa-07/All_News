package com.example.allnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<NewsData> newsData;
    LayoutInflater layoutInflater;


    public CustomAdapter(Context context, ArrayList<NewsData> newsData){
        this.context = context;
        this.newsData = newsData;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return newsData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.list_view_item,null);
        TextView title = (TextView) view.findViewById(R.id.news_title_id);
        TextView date = (TextView) view.findViewById(R.id.news_date_id);
        TextView author = (TextView) view.findViewById(R.id.news_author_id);
        ImageView image = (ImageView) view.findViewById(R.id.news_image_id);

        title.setText(newsData.get(i).getNews_title());
        date.setText(newsData.get(i).getNews_date());
        author.setText(newsData.get(i).getNews_author());
        Picasso.get().load(newsData.get(i).getNews_image()).error(R.drawable.no_image_foreground).into(image);
        return view;
    }
}

//public class CustomAdapter extends ArrayAdapter<NewsData> {
//
//    Context context;
//    ArrayList<NewsData> newsData;
//    LayoutInflater inflater;
//
//    public CustomAdapter( Context context, ArrayList<NewsData> newsData) {
//        super(context, 0,newsData);
//        context = this.context;
//        newsData = this.newsData;
//    }
//
//    public int getCount(){
//        return newsData.size();
//    }
//
//    public View getView(int position, View view, ViewGroup parent){
//        view = inflater.inflate(R.layout.list_view_item,null);
//        TextView title = (TextView) view.findViewById(R.id.news_title_id);
//        TextView author = (TextView) view.findViewById(R.id.news_author_id);
//        TextView date = (TextView) view.findViewById(R.id.news_date_id);
//        ImageView news_image = (ImageView) view.findViewById(R.id.news_image_id);
//
//        title.setText(newsData.get(position).getNews_title());
//        author.setText(newsData.get(position).getNews_author());
//        date.setText(newsData.get(position).getNews_date());
//        Picasso.get().load(newsData.get(position).getNews_image()).error(R.drawable.no_image_foreground).into(news_image);
//        return view;
//    }
//}
