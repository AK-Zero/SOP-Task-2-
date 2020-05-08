package com.example.rockpaperscissors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    ImageView rock, paper, scissors;
    TextView tvp1, tvp2 ,tv2;
    Button btn;
    static int sp1 = 0, sp2 = 0, stat = 0, nr, n = 0,stat1=0,pr=0,play,player=1,over=0;
    static String np1, np2;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout);
        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);
        tvp1 = findViewById(R.id.tvp1);
        tvp2 = findViewById(R.id.tvp2);
        tv2 = findViewById(R.id.tv2);
        btn = findViewById(R.id.ta);
        Intent intent = getIntent();
        SharedPreferences pref = getSharedPreferences("ABC",MODE_PRIVATE);
        np1 = pref.getString("p1","P1");
        stat1=intent.getIntExtra("stat",0);
        nr = pref.getInt("nor", 5);
        play = pref.getInt("play", 2);
        if(play==2 && n==0){
            np2 = pref.getString("p2","P2");
        }
        pr=0;
        final Random rand = new Random();
        tvp1.setText("P1 : "+sp1);
        if(play==2) {
            tvp2.setText("P2 : " + sp2);
        }else{
            tvp2.setText("AI : " + sp2);
        }
        rock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lay.setBackgroundColor(Color.WHITE);
                    if(player==1){
                        stat = 1;
                        over=1;
                    }
                    else if(player==2){
                        stat1=1;
                        over=0;
                    }

                    if(play==1&&player==1) {
                        player=2;
                        tv2.setText("AI's Turn");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                stat1 = rand.nextInt(3);
                                stat1++;
                                if (stat1 == 1) {
                                    paper.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                } else if (stat1 == 2) {
                                    rock.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                } else if (stat1 == 3) {
                                    paper.setVisibility(View.INVISIBLE);
                                    rock.setVisibility(View.INVISIBLE);
                                }
                            }
                        }, 1000);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rock.setVisibility(View.VISIBLE);
                                paper.setVisibility(View.VISIBLE);
                                scissors.setVisibility(View.VISIBLE);
                                over=0;
                                if(n<=nr&&over==0){
                                    if(stat==stat1&&n!=0){
                                        Toast t = Toast.makeText(Main2Activity.this , "Draw!!" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                    }
                                    if (stat == 1 && stat1 == 3) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 3 && stat1 == 1) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }
                                    if (stat == 2 && stat1 == 1) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this, np1 + " wins this round", Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 1 && stat1 == 2) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }
                                    if (stat == 3 && stat1 == 2) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 2 && stat1 == 3) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }

                                }
                                tvp1.setText("P1 : "+sp1);
                                if(play==2) {
                                    tvp2.setText("P2 : " + sp2);
                                }else{
                                    tvp2.setText("AI : " + sp2);
                                }

                                if(n==nr&&over==0){
                                    lay.setBackgroundColor(Color.WHITE);
                                    if(sp1>sp2) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        Toast t = Toast.makeText(Main2Activity.this, np1 + " wins!!", Toast.LENGTH_LONG);
                                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                        t.show();
                                    }
                                    else if(sp2>sp1){
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins!!", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins!!", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                    }
                                    else{
                                        Toast t = Toast.makeText(Main2Activity.this , "It's a Draw!!" , Toast.LENGTH_LONG);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                    }


                                    rock.setVisibility(View.INVISIBLE);
                                    paper.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                    tv2.setVisibility(View.INVISIBLE);
                                    btn.setVisibility(View.VISIBLE);
                                    sp1=0;
                                    sp2=0;
                                    n=0;
                                }
                                tv2.setText("P1's Turn");
                            }
                        }, 2500);
                    }
                        if(player==1){
                            player=2;
                        }
                        else if(player==2){
                            player=1;
                        }
                        if(player==1&&play==2){
                            tv2.setText("P1's Turn");
                        }
                        else{
                            if(play==2){
                                tv2.setText("P2's Turn");
                            }
                        }
                    if(n<=nr&&over==0){
                        if(stat==stat1&&n!=0){
                            Toast t = Toast.makeText(Main2Activity.this , "Draw!!" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                        }
                        if (stat == 1 && stat1 == 3) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                            n++;
                        }
                        if (stat == 3 && stat1 == 1) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }
                        if (stat == 2 && stat1 == 1) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this, np1 + " wins this round", Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                            n++;
                        }
                        if (stat == 1 && stat1 == 2) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }
                        if (stat == 3 && stat1 == 2) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                            n++;
                        }
                        if (stat == 2 && stat1 == 3) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }

                    }
                    tvp1.setText("P1 : "+sp1);
                    if(play==2) {
                        tvp2.setText("P2 : " + sp2);
                    }else{
                        tvp2.setText("AI : " + sp2);
                    }

                    if(n==nr&&over==0){
                        lay.setBackgroundColor(Color.WHITE);
                        if(sp1>sp2) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            Toast t = Toast.makeText(Main2Activity.this, np1 + " wins!!", Toast.LENGTH_LONG);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                        }
                        else if(sp2>sp1){
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins!!", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins!!", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                        }
                        else{
                            Toast t = Toast.makeText(Main2Activity.this , "It's a Draw!!" , Toast.LENGTH_LONG);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                        }


                        rock.setVisibility(View.INVISIBLE);
                        paper.setVisibility(View.INVISIBLE);
                        scissors.setVisibility(View.INVISIBLE);
                        tv2.setVisibility(View.INVISIBLE);
                        btn.setVisibility(View.VISIBLE);
                        sp1=0;
                        sp2=0;
                        n=0;
                    }
                }
            });
            paper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lay.setBackgroundColor(Color.WHITE);
                    if(player==1){
                        stat = 2;
                        over=1;
                    }
                    else if(player==2){
                        stat1=2;
                        over=0;
                    }

                    if(play==1&&player==1) {
                        player=2;
                        tv2.setText("AI's Turn");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                stat1 = rand.nextInt(3);
                                stat1++;
                                if (stat1 == 1) {
                                    paper.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                } else if (stat1 == 2) {
                                    rock.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                } else if (stat1 == 3) {
                                    paper.setVisibility(View.INVISIBLE);
                                    rock.setVisibility(View.INVISIBLE);
                                }
                            }
                        }, 1000);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rock.setVisibility(View.VISIBLE);
                                paper.setVisibility(View.VISIBLE);
                                scissors.setVisibility(View.VISIBLE);
                                tv2.setText("P1's Turn");
                                over=0;
                                if(n<=nr&&over==0){
                                    if(stat==stat1&&n!=0){
                                        Toast t = Toast.makeText(Main2Activity.this , "Draw!!" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                    }
                                    if (stat == 1 && stat1 == 3) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 3 && stat1 == 1) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }
                                    if (stat == 2 && stat1 == 1) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this, np1 + " wins this round", Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 1 && stat1 == 2) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }
                                    if (stat == 3 && stat1 == 2) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 2 && stat1 == 3) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }

                                }
                                tvp1.setText("P1 : "+sp1);
                                if(play==2) {
                                    tvp2.setText("P2 : " + sp2);
                                }else{
                                    tvp2.setText("AI : " + sp2);
                                }

                                if(n==nr&&over==0){
                                    lay.setBackgroundColor(Color.WHITE);
                                    if(sp1>sp2) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        Toast t = Toast.makeText(Main2Activity.this, np1 + " wins!!", Toast.LENGTH_LONG);
                                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                        t.show();
                                    }
                                    else if(sp2>sp1){
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins!!", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins!!", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                    }
                                    else{
                                        Toast t = Toast.makeText(Main2Activity.this , "It's a Draw!!" , Toast.LENGTH_LONG);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                    }


                                    rock.setVisibility(View.INVISIBLE);
                                    paper.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                    tv2.setVisibility(View.INVISIBLE);
                                    btn.setVisibility(View.VISIBLE);
                                    sp1=0;
                                    sp2=0;
                                    n=0;
                                }
                            }
                        }, 2500);
                    }
                        if(player==1){
                            player=2;
                        }
                        else if(player==2){
                            player=1;
                        }
                        if(player==1&&play==2){
                            tv2.setText("P1's Turn");
                        }
                        else{
                            if(play==2){
                                tv2.setText("P2's Turn");
                            }
                        }
                    if(n<=nr&&over==0){
                        if(stat==stat1&&n!=0){
                            Toast t = Toast.makeText(Main2Activity.this , "Draw!!" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                        }
                        if (stat == 1 && stat1 == 3) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                            n++;
                        }
                        if (stat == 3 && stat1 == 1) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }
                        if (stat == 2 && stat1 == 1) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this, np1 + " wins this round", Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                            n++;
                        }
                        if (stat == 1 && stat1 == 2) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }
                        if (stat == 3 && stat1 == 2) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                            n++;
                        }
                        if (stat == 2 && stat1 == 3) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }

                    }
                    tvp1.setText("P1 : "+sp1);
                    if(play==2) {
                        tvp2.setText("P2 : " + sp2);
                    }else{
                        tvp2.setText("AI : " + sp2);
                    }

                    if(n==nr&&over==0){
                        lay.setBackgroundColor(Color.WHITE);
                        if(sp1>sp2) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            Toast t = Toast.makeText(Main2Activity.this, np1 + " wins!!", Toast.LENGTH_LONG);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                        }
                        else if(sp2>sp1){
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins!!", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins!!", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                        }
                        else{
                            Toast t = Toast.makeText(Main2Activity.this , "It's a Draw!!" , Toast.LENGTH_LONG);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                        }


                        rock.setVisibility(View.INVISIBLE);
                        paper.setVisibility(View.INVISIBLE);
                        scissors.setVisibility(View.INVISIBLE);
                        tv2.setVisibility(View.INVISIBLE);
                        btn.setVisibility(View.VISIBLE);
                        sp1=0;
                        sp2=0;
                        n=0;
                    }
                }
            });
            scissors.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lay.setBackgroundColor(Color.WHITE);
                    if(player==1){
                        stat =3;
                        over=1;
                    }
                    else if(player==2){
                        stat1=3;
                        over=0;
                    }

                    if(play==1&&player==1) {
                        player=2;
                        tv2.setText("AI's Turn");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                stat1 = rand.nextInt(3);
                                stat1++;
                                if (stat1 == 1) {
                                    paper.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                } else if (stat1 == 2) {
                                    rock.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                } else if (stat1 == 3) {
                                    paper.setVisibility(View.INVISIBLE);
                                    rock.setVisibility(View.INVISIBLE);
                                }
                            }
                        }, 1000);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rock.setVisibility(View.VISIBLE);
                                paper.setVisibility(View.VISIBLE);
                                scissors.setVisibility(View.VISIBLE);
                                tv2.setText("P1's Turn");
                                over=0;
                                if(n<=nr&&over==0){
                                    if(stat==stat1&&n!=0){
                                        Toast t = Toast.makeText(Main2Activity.this , "Draw!!" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                    }
                                    if (stat == 1 && stat1 == 3) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 3 && stat1 == 1) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }
                                    if (stat == 2 && stat1 == 1) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this, np1 + " wins this round", Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 1 && stat1 == 2) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }
                                    if (stat == 3 && stat1 == 2) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        sp1++;
                                        Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                        n++;
                                    }
                                    if (stat == 2 && stat1 == 3) {
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        sp2++;
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                        n++;
                                    }

                                }
                                tvp1.setText("P1 : "+sp1);
                                if(play==2) {
                                    tvp2.setText("P2 : " + sp2);
                                }else{
                                    tvp2.setText("AI : " + sp2);
                                }

                                if(n==nr&&over==0){
                                    lay.setBackgroundColor(Color.WHITE);
                                    if(sp1>sp2) {
                                        pr=1;
                                        lay.setBackgroundColor(Color.YELLOW);
                                        Toast t = Toast.makeText(Main2Activity.this, np1 + " wins!!", Toast.LENGTH_LONG);
                                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                        t.show();
                                    }
                                    else if(sp2>sp1){
                                        pr=2;
                                        lay.setBackgroundColor(Color.CYAN);
                                        if(play==2) {
                                            Toast t = Toast.makeText(Main2Activity.this, np2 + " wins!!", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }else{
                                            Toast t = Toast.makeText(Main2Activity.this, "AI wins!!", Toast.LENGTH_SHORT);
                                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                            t.show();
                                        }
                                    }
                                    else{
                                        Toast t = Toast.makeText(Main2Activity.this , "It's a Draw!!" , Toast.LENGTH_LONG);
                                        t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                                        t.show();
                                    }


                                    rock.setVisibility(View.INVISIBLE);
                                    paper.setVisibility(View.INVISIBLE);
                                    scissors.setVisibility(View.INVISIBLE);
                                    tv2.setVisibility(View.INVISIBLE);
                                    btn.setVisibility(View.VISIBLE);
                                    sp1=0;
                                    sp2=0;
                                    n=0;
                                }
                            }
                        }, 2500);
                    }
                        if(player==1){
                            player=2;
                        }
                        else if(player==2){
                            player=1;
                        }
                        if(player==1&&play==2){
                            tv2.setText("P1's Turn");
                        }
                        else{
                            if(play==2){
                                tv2.setText("P2's Turn");
                            }
                        }
                    if(n<=nr&&over==0){
                        if(stat==stat1&&n!=0){
                            Toast t = Toast.makeText(Main2Activity.this , "Draw!!" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                        }
                        if (stat == 1 && stat1 == 3) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                            n++;
                        }
                        if (stat == 3 && stat1 == 1) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }
                        if (stat == 2 && stat1 == 1) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this, np1 + " wins this round", Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                            n++;
                        }
                        if (stat == 1 && stat1 == 2) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }
                        if (stat == 3 && stat1 == 2) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            sp1++;
                            Toast t = Toast.makeText(Main2Activity.this , np1+" wins this round" , Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                            n++;
                        }
                        if (stat == 2 && stat1 == 3) {
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            sp2++;
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins this round", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                            n++;
                        }

                    }
                    tvp1.setText("P1 : "+sp1);
                    if(play==2) {
                        tvp2.setText("P2 : " + sp2);
                    }else{
                        tvp2.setText("AI : " + sp2);
                    }

                    if(n==nr&&over==0){
                        lay.setBackgroundColor(Color.WHITE);
                        if(sp1>sp2) {
                            pr=1;
                            lay.setBackgroundColor(Color.YELLOW);
                            Toast t = Toast.makeText(Main2Activity.this, np1 + " wins!!", Toast.LENGTH_LONG);
                            t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                            t.show();
                        }
                        else if(sp2>sp1){
                            pr=2;
                            lay.setBackgroundColor(Color.CYAN);
                            if(play==2) {
                                Toast t = Toast.makeText(Main2Activity.this, np2 + " wins!!", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }else{
                                Toast t = Toast.makeText(Main2Activity.this, "AI wins!!", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                                t.show();
                            }
                        }
                        else{
                            Toast t = Toast.makeText(Main2Activity.this , "It's a Draw!!" , Toast.LENGTH_LONG);
                            t.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                            t.show();
                        }


                        rock.setVisibility(View.INVISIBLE);
                        paper.setVisibility(View.INVISIBLE);
                        scissors.setVisibility(View.INVISIBLE);
                        tv2.setVisibility(View.INVISIBLE);
                        btn.setVisibility(View.VISIBLE);
                        sp1=0;
                        sp2=0;
                        n=0;
                    }
                }
            });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int a=1;
        a=3;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sp1",sp1);
        outState.putInt("sp2",sp2);
        outState.putInt("stat",stat);
        outState.putInt("nr",nr);
        outState.putInt("nr1",nr);
        outState.putInt("n",n);
        outState.putInt("play",play);
        outState.putInt("stat1",stat1);
        outState.putString("np1",np1);
        outState.putString("np2",np2);
        outState.putInt("pr",pr);
        outState.putInt("stat1",stat1);
        outState.putInt("player",player);
        outState.putInt("over",over);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        sp1 = savedInstanceState.getInt("sp1");
        sp2 = savedInstanceState.getInt("sp2");
        stat = savedInstanceState.getInt("stat");
        nr = savedInstanceState.getInt("nr");
        nr = savedInstanceState.getInt("nr1");
        stat1 = savedInstanceState.getInt("stat1");
        n = savedInstanceState.getInt("n");
        play = savedInstanceState.getInt("play");
        np1 = savedInstanceState.getString("np1");
        np2 = savedInstanceState.getString("np2");
        pr = savedInstanceState.getInt("pr");
        stat1 = savedInstanceState.getInt("stat1");
        player = savedInstanceState.getInt("player");
        over = savedInstanceState.getInt("over");
        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.layout);
        if(pr==1){
            lay.setBackgroundColor(Color.YELLOW);
        }
        else if(pr==2){
            lay.setBackgroundColor(Color.CYAN);
        }
        tvp1.setText("P1 : "+sp1);
        if(play==1) {
            tvp2.setText("AI : " + sp2);
        }
        else{
            tvp2.setText("P2 : " + sp2);
        }
    }
}