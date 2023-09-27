package com.example.allnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button top_30_btn, sports_btn, science_btn, technology_btn, health_btn, business_btn;
    private EditText search_bar;
    private ListView listView;
    private ProgressBar progressBar;
    private final String API_KEY = "d4ea897a6ac245d38377c25e591e0beb";
    private ArrayList<NewsData> data_list = new ArrayList<>();
    private NewsApiClient newsApiClient = new NewsApiClient(API_KEY);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_30_btn = findViewById(R.id.top_30_btn);
        sports_btn = findViewById(R.id.sports_btn);
        science_btn = findViewById(R.id.science_btn);
        technology_btn = findViewById(R.id.technology_btn);
        health_btn = findViewById(R.id.health_btn);
        business_btn = findViewById(R.id.business_btn);
        listView = findViewById(R.id.list_view_id);
        progressBar = findViewById(R.id.progress_bar_id);
        getTopHeadline();

        top_30_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getTopHeadline();
            }
        });

        sports_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getSports();
            }
        });

        science_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getScience();
            }
        });

        technology_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getTechnology();
            }
        });

        health_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getHealth();
            }
        });

        business_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                getBusiness();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Loading...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Web_view_activity.class);
                intent.putExtra("url",data_list.get(i).getNews_url());
                startActivity(intent);
            }
        });

    }

    void getTopHeadline(){
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        data_list.clear();
                        int n = response.getArticles().size();
                        for(int i=0;i<n;i++){
                            NewsData data = new NewsData();
                            data.setNews_title(response.getArticles().get(i).getTitle());
                            String author = response.getArticles().get(i).getAuthor();
                            data.setNews_author(author);
                            data.setNews_date(response.getArticles().get(i).getPublishedAt().substring(0,10));
                            data.setNews_image(response.getArticles().get(i).getUrlToImage());
                            data.setNews_url(response.getArticles().get(i).getUrl());
                            data_list.add(data);
                        }
                        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),data_list);
                        listView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    void getSports(){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("sports")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        data_list.clear();
                        int n = response.getArticles().size();
                        for(int i=0;i<n;i++){
                            NewsData data = new NewsData();
                            data.setNews_title(response.getArticles().get(i).getTitle());
                            String author = response.getArticles().get(i).getAuthor();
                            data.setNews_author(author);
                            data.setNews_date(response.getArticles().get(i).getPublishedAt().substring(0,10));
                            data.setNews_image(response.getArticles().get(i).getUrlToImage());
                            data.setNews_url(response.getArticles().get(i).getUrl());
                            data_list.add(data);
                        }
                        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),data_list);
                        listView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    void getTechnology(){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("technology")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        data_list.clear();
                        int n = response.getArticles().size();
                        for(int i=0;i<n;i++){
                            NewsData data = new NewsData();
                            data.setNews_title(response.getArticles().get(i).getTitle());
                            String author = response.getArticles().get(i).getAuthor();
                            data.setNews_author(author);
                            data.setNews_date(response.getArticles().get(i).getPublishedAt().substring(0,10));
                            data.setNews_image(response.getArticles().get(i).getUrlToImage());
                            data.setNews_url(response.getArticles().get(i).getUrl());
                            data_list.add(data);
                        }
                        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),data_list);
                        listView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    void getHealth(){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("health")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        data_list.clear();
                        int n = response.getArticles().size();
                        for(int i=0;i<n;i++){
                            NewsData data = new NewsData();
                            data.setNews_title(response.getArticles().get(i).getTitle());
                            String author = response.getArticles().get(i).getAuthor();
                            data.setNews_author(author);
                            data.setNews_date(response.getArticles().get(i).getPublishedAt().substring(0,10));
                            data.setNews_image(response.getArticles().get(i).getUrlToImage());
                            data.setNews_url(response.getArticles().get(i).getUrl());
                            data_list.add(data);
                        }
                        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),data_list);
                        listView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    void getScience(){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("science")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        data_list.clear();
                        int n = response.getArticles().size();
                        for(int i=0;i<n;i++){
                            NewsData data = new NewsData();
                            data.setNews_title(response.getArticles().get(i).getTitle());
                            String author = response.getArticles().get(i).getAuthor();
                            data.setNews_author(author);
                            data.setNews_date(response.getArticles().get(i).getPublishedAt().substring(0,10));
                            data.setNews_image(response.getArticles().get(i).getUrlToImage());
                            data.setNews_url(response.getArticles().get(i).getUrl());
                            data_list.add(data);
                        }
                        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),data_list);
                        listView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    void getBusiness(){
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("business")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        data_list.clear();
                        int n = response.getArticles().size();
                        for(int i=0;i<n;i++){
                            NewsData data = new NewsData();
                            data.setNews_title(response.getArticles().get(i).getTitle());
                            String author = response.getArticles().get(i).getAuthor();
                            data.setNews_author(author);
                            data.setNews_date(response.getArticles().get(i).getPublishedAt().substring(0,10));
                            data.setNews_image(response.getArticles().get(i).getUrlToImage());
                            data.setNews_url(response.getArticles().get(i).getUrl());
                            data_list.add(data);
                        }
                        CustomAdapter adapter = new CustomAdapter(getApplicationContext(),data_list);
                        listView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


}