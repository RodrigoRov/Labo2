package com.rovelo.labo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView1,txtView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void changeText(View v){
        txtView1 = findViewById(R.id.textView1);
        txtView2 = findViewById(R.id.textView2);
        String aux;
        aux = txtView1.getText().toString();
        txtView1.setText(txtView2.getText().toString());
        txtView2.setText(aux);
    }
}
