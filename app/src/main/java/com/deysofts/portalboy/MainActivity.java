package com.deysofts.portalboy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity  {

    private DatabaseReference mDatabase;
    // ...
    private RecyclerView mRecyclerView;
    TextView attendance_data,status_textView,figure_textView;
    DatabaseReference reff;
    ConstraintLayout layout;
    Button fetch_data;
    EditText figure_editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //attendance_data = (TextView) findViewById(R.id.attendance_data);
        layout = findViewById(R.id.layout);
        figure_editText=(EditText)findViewById(R.id.figure_editText);
        status_textView=(TextView)findViewById(R.id.status_textView);
        figure_textView=(TextView)findViewById(R.id.figure_textView);


        status_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

///////////////////////////////////////////////////////////////////////////////////
                String fig=figure_editText.getText().toString();
                //System.out.println("ENTER THE STRING");
                Scanner ob=new Scanner(System.in);
                //String fig=ob.nextLine();
                //System.out.println(fig);
                int pos=0;

                String[] arrOfStr = fig.split("/", 2);




                int counter=0;
                double num=Double.parseDouble(arrOfStr[0]);
                double den=Double.parseDouble(arrOfStr[1]);
                while((num/den)<=0.75)
                {
                    num+=7;
                    den+=7;
                    counter+=1;
                }

                status_textView.setText("You have to go "+String.valueOf(counter)+" more days to make your attendance above 75%");
                System.out.println("You have to go "+counter+" more days to make your attendance above 75%");
    ///////////////////////////////////////////////////////////////////////




            }
        });



        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview_data);
        new FirebaseDatabaseHelper().readData(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<helper> help, List<String> keys) {
                new RecyclerView_config().setConfig(mRecyclerView,MainActivity.this,help,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });


        }

    public void bind2(helper help)
    {

        figure_textView.setText(help.getFigure());
        String gg=figure_textView.getText().toString();
        figure_editText.setText(gg);


    }




    }

