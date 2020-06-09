package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    Button btnSubmit;
    TextView tvResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idnumber = etID.getText().toString().trim();
                String dob = idnumber.substring(0,6);
                int gender = Integer.parseInt(Character.toString(idnumber.charAt(6)));
                String sgender;
                if(gender < 5)
                    sgender = "Female";
                else
                    sgender = "Male";
                int nationality = Integer.parseInt(Character.toString(idnumber.charAt(6)));
                String snationality;
                if(nationality == 0)
                    snationality = "SA citizen";
                else
                    snationality = "Permanent Residence";
                tvResults.setText(getString(R.string.dob) + dob + getString(R.string.newline) + getString(R.string.gender) + sgender + "\n" + getString(R.string.nationality) + snationality);
                tvResults.setVisibility(View.VISIBLE);
            }
        });


    }
}
