package com.ex.android22_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user,password,confirm_password;
    private Button next;
    private TextView errors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText) findViewById(R.id.editText_ttk);
        password=(EditText) findViewById(R.id.editText_nmk_main);
        confirm_password=(EditText) findViewById(R.id.editText_nlmk);
        next= (Button) findViewById(R.id.btn_tieptuc_main);
        errors= (TextView) findViewById(R.id.tv_baoloi_main);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(MainActivity.this, nhapThongTinCaNhanActivity.class);
//                startActivity(intent);
                String user_s = user.getText().toString();
                String password_s= password.getText().toString();
                String comfirm_password_s= confirm_password.getText().toString();
                String error ="";
                user.setBackgroundResource(R.drawable.botron);
                password.setBackgroundResource(R.drawable.botron);
                confirm_password.setBackgroundResource(R.drawable.botron);
                if (user_s.indexOf(" ")>0){
                    error+="Tên tài khoản không được chứa khoảng trắng\n";
                    user.setBackgroundResource(R.drawable.botron_pink);
                }
                if (user_s.length()<6){
                    error+="Tên tài khoản phải dài hơn 6 ký tự\n";
                    user.setBackgroundResource(R.drawable.botron_pink);
                }
                if (password_s.length()<8){
                    error+="mật khẩu phải tối thiểu 8 ký tự\n";
                    password.setBackgroundResource(R.drawable.botron_pink);
                }
                if(!password_s.equals(comfirm_password_s)){
                    error+="mật khẩu phải trùng nhau";
                    password.setBackgroundResource(R.drawable.botron_pink);
                    confirm_password.setBackgroundResource(R.drawable.botron_pink);
                }
                if (error.length()<1){
                    Toast.makeText(MainActivity.this,"đăng nhập thành công",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(MainActivity.this, NhapThongTinCaNhanActivity.class);
                    startActivity(intent);

                }else {
                    errors.setText(error);
                }

            }
        });

    }



}