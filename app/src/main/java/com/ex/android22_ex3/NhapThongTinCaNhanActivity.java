package com.ex.android22_ex3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NhapThongTinCaNhanActivity extends AppCompatActivity {
    private EditText phone,email,fullname,companyname,password;
    private Button next;
    private TextView error;
    private ImageButton imageButton_back;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_nhapthongtincanhan);
         phone = (EditText) findViewById(R.id.editText_nsdt);
         email = (EditText) findViewById(R.id.editText_nemail);
         fullname = (EditText) findViewById(R.id.editText_ntdd);
         companyname = (EditText) findViewById(R.id.editText_ntcq);
         password = (EditText) findViewById(R.id.editText_nmk);
         next=(Button) findViewById(R.id.btn_tieptuc);
         error =(TextView) findViewById(R.id.tv_baoloi);
         imageButton_back=(ImageButton) findViewById(R.id.btn_back);
         imageButton_back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent= new Intent(NhapThongTinCaNhanActivity.this,MainActivity.class);
                    startActivity(intent);
             }
         });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone_s= phone.getText().toString();
                String email_s= email.getText().toString();
                String fullname_s= fullname.getText().toString();
                String companyname_s= companyname.getText().toString();
                String password_s= password.getText().toString();
                String error_s="";
                phone.setBackgroundResource(R.drawable.botron);
                email.setBackgroundResource(R.drawable.botron);
                fullname.setBackgroundResource(R.drawable.botron);
                companyname.setBackgroundResource(R.drawable.botron);
                password.setBackgroundResource(R.drawable.botron);

                if(phone_s.indexOf("0")!=0||phone_s.length()!=10){
                    error_s+="Nhập sai số điện thoại\n";
                    phone.setBackgroundResource(R.drawable.botron_pink);
                }

                if(!kiemtraemail(email_s)){
                    error_s+="Email không hợp lệ\n";
                    email.setBackgroundResource(R.drawable.botron_pink);
                }
                if(password_s.length()<8){
                    error_s+="Mật khẩu không đủ 8 ký tự";
                    password.setBackgroundResource(R.drawable.botron_pink);
                }
                if (error_s.length()<1){
                    Toast.makeText(NhapThongTinCaNhanActivity.this,"nhập thông tin thành công",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(NhapThongTinCaNhanActivity.this,MayTinhActivity.class);
                    startActivity(intent);
                }else {
                    error.setText(error_s);
                }
            }
        });


    }
    public boolean kiemtraemail(String s) {
        boolean temp = true;
        if (s.length() > 128) {
            temp = false;
        } else if (s.indexOf(" ") > 0) {
            temp = false;
        } else if (s.indexOf("@") < 0 || s.indexOf(".") < 0) {
            temp = false;
        } else if (s.indexOf("@") != s.lastIndexOf("@")) {
            temp = false;
        } else if (s.indexOf("@") > s.lastIndexOf(".")) {
            temp = false;
        }
        return temp;
    }
}

