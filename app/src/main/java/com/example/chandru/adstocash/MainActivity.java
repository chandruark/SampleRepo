package com.example.chandru.adstocash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private int gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText Name=(EditText)findViewById(R.id.name);
        final EditText Email=(EditText)findViewById(R.id.email);
        final EditText Pass=(EditText)findViewById(R.id.pass);
        final EditText Phonenum=(EditText)findViewById(R.id.phone);

       radioGroup=(RadioGroup)findViewById(R.id.radiogrp);

        Button button=(Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=radioGroup.getCheckedRadioButtonId();
                radioButton =(RadioButton)findViewById(id);
                if (radioButton.getText().equals("Male")){
                   gender=1;
                    Toast.makeText(MainActivity.this,"1", Toast.LENGTH_SHORT).show();

                }
               else if(radioButton.getText().equals("Female")){
                    gender=2;
                    Toast.makeText(MainActivity.this,"2", Toast.LENGTH_SHORT).show();

                }

                User user =new User(
                        Name.getText().toString(),
                        Email.getText().toString(),
                        Pass.getText().toString(),
                       // Phonenum.getText().toString(),
                        Long.parseLong(Phonenum.getText().toString()),
                        gender
                );

                sendNetworkRequest(user);
            }
        });



    }

    private void sendNetworkRequest(User user){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("base api na upto '.com/' ")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        //client
        UserClient client=retrofit.create(UserClient.class);
        Call<User> call=client.createACcount(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "response="+ response.body().getMessage()+"token ="+response.body().getAuth_token(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "thappu", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
