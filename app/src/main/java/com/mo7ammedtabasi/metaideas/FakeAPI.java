package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FakeAPI extends AppCompatActivity {
    TextView txResultAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_api);
        txResultAPI=findViewById(R.id.textViewAPI);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderAPI jsonPlaceHolderAPI=retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Post>> call = jsonPlaceHolderAPI.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    txResultAPI.setText("Code: "+ response.code());
                }
                List<Post> posts=response.body();
                for (Post post:posts){
                    String content = "";
                    content+="Id: "+post.getId()+"\n";
                    content+="UserId: "+post.getUserId()+"\n";
                    content+="Title: "+post.getTitle()+"\n";
                    content+="Body: "+post.getBody()+"\n";
                    txResultAPI.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                txResultAPI.setText(t.getMessage());
            }
        });
    }
}