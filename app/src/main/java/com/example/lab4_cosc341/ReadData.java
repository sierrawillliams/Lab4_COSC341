package com.example.lab4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData extends AppCompatActivity {

    TextView studentId, name, division, gender;
    Button prev, next, mainScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        studentId = findViewById(R.id.studentId_read);
        name = findViewById(R.id.name_read);
        division = findViewById(R.id.division_read2);
        gender = findViewById(R.id.gender_read2);
        prev = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        mainScreen = findViewById(R.id.mainScreen);

        int counter = 0;
        String data = null;
        try {
            String file = "data.txt";
            FileInputStream fis = openFileInput(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                data += (counter + 1) + "\t" + line + "\n";
                counter++;
                String[] splits = line.split(", ");
                String Division = splits[splits.length - 1];
                String StudentID = splits[0];
                String Name = splits[1];
                String Gender = splits[2];
                studentId.setText(StudentID);
                name.setText(Name);
                gender.setText(Gender);
                division.setText(Division);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}