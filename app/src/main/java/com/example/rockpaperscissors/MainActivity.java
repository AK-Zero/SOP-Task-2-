package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ev1,ev2,evn3;
    Button btn;
    int play;
    String evt2;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ev1 = findViewById(R.id.ev1);
        ev2 = findViewById(R.id.ev2);
        evn3 = findViewById(R.id.evn3);
        btn = findViewById(R.id.btn);
        tv2 = findViewById(R.id.textView2);

        Intent intent1 = getIntent();
        play = intent1.getIntExtra("play",2);
        if(play==1){
            ev2.setVisibility(View.INVISIBLE);
            tv2.setVisibility(View.INVISIBLE);

        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(play==2) {
                    if (!(TextUtils.isEmpty(ev1.getText().toString())) && !(TextUtils.isEmpty(ev2.getText().toString())) && !(TextUtils.isEmpty(evn3.getText().toString())) && Integer.parseInt(evn3.getText().toString()) > 0) {
                        final String evt1 = ev1.getText().toString().trim();
                        evt2 = ev2.getText().toString().trim();
                        SharedPreferences pref = getSharedPreferences("ABC",MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("p1",evt1);
                        edit.putString("p2",evt2);
                        edit.putInt("nor",Integer.parseInt(evn3.getText().toString()));
                        edit.putInt("play", play);
                        edit.apply();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        finish();
                        startActivity(intent);
                    } else if(Integer.parseInt(evn3.getText().toString()) == 0){
                        Toast t = Toast.makeText(MainActivity.this, "Number of Rounds can't be Zero!!", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                        t.show();
                    }
                    else{
                        Toast t = Toast.makeText(MainActivity.this, "Please Fill All The Fields!!", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                        t.show();
                    }
                }
                    else{
                        if (!(TextUtils.isEmpty(ev1.getText().toString())) && !(TextUtils.isEmpty(evn3.getText().toString())) && Integer.parseInt(evn3.getText().toString()) > 0) {
                            final String evt1 = ev1.getText().toString().trim();
                            SharedPreferences pref = getSharedPreferences("ABC",MODE_PRIVATE);
                            SharedPreferences.Editor edit = pref.edit();
                            edit.putString("p1",evt1);
                            edit.putInt("nor",Integer.parseInt(evn3.getText().toString()));
                            edit.putInt("play", play);
                            edit.apply();
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            finish();
                            startActivity(intent);
                        } else if(Integer.parseInt(evn3.getText().toString()) == 0){
                            Toast t = Toast.makeText(MainActivity.this, "Number of Rounds can't be Zero!!", Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                        }
                        else{
                            Toast t = Toast.makeText(MainActivity.this, "Please Fill All The Fields!!", Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                        }

                }
            }
        });
    }

}
