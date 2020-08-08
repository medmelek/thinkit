package com.example.think_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.think_it.Databse.AppDatabaseInstance;
import com.example.think_it.entity.user;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button next ;
    EditText name ;
    Intent intent;
    user  myUser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = (Button) findViewById(R.id.next);
        name = (EditText) findViewById(R.id.name);
        intent = new Intent(getApplicationContext(), rooms.class);
        this.getUser(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((name!=null)&&(name.getText().toString().length()!=0)){
                   saveUser(name.getText().toString(),intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Verify your name !",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void saveUser(String name, final Intent intent){
        final user myuser = new user();
        myuser.setFullname(name);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                AppDatabaseInstance.getInstance(getApplicationContext()).getAppDatabase()
                        .userDao()
                        .insert(myuser);
                startActivity(intent);
            }
        });
    }

    public void getUser(final Intent intent){
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    List<user> name = AppDatabaseInstance.getInstance(getApplicationContext()).getAppDatabase()
                            .userDao()
                            .getAll() ;
                    if(name.size()>0){
                        Log.i("getuser",name.get(0).getFullname());
                        //toast(name.get(0).getFullname());
                        startActivity(intent);
                    }

                }
            });
    }
    /*public void toast(final String msg){
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();

            }
        });

    }*/
}
