package com.example.android.justaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.justaid.info.Student;

import org.litepal.crud.DataSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               EditText idedit=(EditText) findViewById(R.id.tv_szsd_username);
                EditText pwdedit=(EditText) findViewById(R.id.tv_szsd_password);
                String pwdstr=pwdedit.getText().toString();
                String str = idedit.getText().toString();
                List<Student> students= DataSupport.findAll(Student.class);
                boolean flag=false;
                for(Student s:students){
                    try {
                        if (s.getStudentId() == Long.parseLong(str)){
                            if(s.getPassword().equals(pwdstr)){
                                flag=true;
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("accountId", s.getName());
                                intent.putExtra("studentid",s.getStudentId()+"");
                                startActivity(intent);
                                LoginActivity.this.finish();
                            }else {
                                Toast.makeText(LoginActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }


                }
                if(flag==false){
                Toast.makeText(LoginActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();}
               /* Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("accountId", str);
                startActivity(intent);
                LoginActivity.this.finish();*/
            }
        });
    }


}
