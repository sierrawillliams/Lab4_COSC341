package com.example.lab4_cosc341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteData extends AppCompatActivity {

    EditText studentNum, lastN, firstN;
    RadioGroup gender;
    RadioButton male, female, selectedGender;
    Spinner division;
    Button submit;
    String studentNumber, lastName, firstName, div, gender_choice;
    int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_data);

        studentNum = findViewById(R.id.studentNumberField);
        lastN = findViewById(R.id.lastNameField);
        firstN = findViewById(R.id.firstNameField);
        gender = findViewById(R.id.genderField);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        division = findViewById(R.id.divisionField);
        submit = findViewById(R.id.submit);

        String[] spinner = new String[]{"COSC", "DATA", "MATH"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner);
        division.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (studentNumber.length() != 8) {
                    Toast.makeText(WriteData.this, "Input an 8 digit number", Toast.LENGTH_SHORT).show();
                } else if (lastName.isEmpty()) {
                    Toast.makeText(WriteData.this, "Input last name", Toast.LENGTH_SHORT).show();
                } else if (firstName.isEmpty()) {
                    Toast.makeText(WriteData.this, "Input first name", Toast.LENGTH_SHORT).show();
                }
                studentNumber = studentNum.getText().toString();
                lastName = lastN.getText().toString();
                firstName = firstN.getText().toString();
                selectedId = gender.getCheckedRadioButtonId();
                selectedGender = findViewById(selectedId);
                gender_choice = selectedGender.getText().toString();
                div = division.getSelectedItem().toString();
                String filename = "data.txt";
                File file = new File(filename);
                if(!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String content = studentNumber + ", " + lastName + ", " + firstName + ", " + gender_choice + ", " + div + "\n";
                FileOutputStream outputStream;
                try {
                    outputStream = openFileOutput(filename, Context.MODE_APPEND);
                    outputStream.write(content.getBytes());
                    outputStream.close();
                    Toast.makeText(WriteData.this, "Contents wrote to data.txt", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    }
}
