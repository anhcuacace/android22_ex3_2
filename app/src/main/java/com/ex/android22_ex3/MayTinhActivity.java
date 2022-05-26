package com.ex.android22_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MayTinhActivity extends AppCompatActivity {
    private Button cong,tru,nhan,chia;
    private EditText nhapSo1,nhapSo2, kq;
    private double nhapSo1_s,nhapSo2_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maytinh);
        this.anhxa();
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layText();
                kq.setText(nhapSo1_s+ nhapSo2_s+"");
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layText();
                kq.setText(nhapSo1_s- nhapSo2_s+"");
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layText();
                kq.setText(nhapSo1_s* nhapSo2_s+"");
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layText();
                kq.setText(nhapSo1_s/ nhapSo2_s+"");
            }
        });

    }
    private void layText(){
        nhapSo1_s= Double.parseDouble(nhapSo1.getText().toString());
        nhapSo2_s= Double.parseDouble(nhapSo2.getText().toString());
    }
    private void anhxa(){
        nhapSo1= (EditText) findViewById(R.id.editText_nstren);
        nhapSo2= (EditText) findViewById(R.id.editText_nsduoi);
        kq=(EditText) findViewById(R.id.editText_kq);
        cong= (Button) findViewById(R.id.btn_cong);
        tru= (Button) findViewById(R.id.btn_tru);
        nhan= (Button) findViewById(R.id.btn_nhan);
        chia= (Button) findViewById(R.id.btn_chia);

    }


}