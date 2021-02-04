package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity  {
    Button b1,b2;
    EditText ed1;
    EditText pwd;
    TextView tv;

    String uname_;
    String pwd_;
    private String file = "F:\\ceredentials.txt";
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.textview);
        b1=(Button)findViewById(R.id.save);
        b2=(Button)findViewById(R.id.login);

        ed1=(EditText)findViewById(R.id.username);
        pwd=(EditText)findViewById(R.id.password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fOut=openFileOutput(file, MODE_PRIVATE);
                    data = "Ramya \n17wh1a1243 Ramya\nRamya 1243\n";
                    fOut.write(data.getBytes());



                    fOut.close();
                    Toast.makeText(getBaseContext(), "File is saved successfully!",
                            Toast.LENGTH_SHORT).show();

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Input to load");
                uname_ = ed1.getText().toString();
                pwd_ = pwd.getText().toString();
                try {
                    System.out.println("Before File open");
                    FileInputStream fin = openFileInput(file);
                    System.out.println("After File open");
                    int c;
                    String temp="";
                    while((c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    String file_read[] = temp.split("\n");
                    boolean isFound = false;
                    for(String record : file_read) {
                        String uname_pwd[] = record.split(" ");
                        if(uname_pwd[0].equalsIgnoreCase(uname_) && uname_pwd[1].equals(pwd_)) {
                            isFound = true;
                            break;
                        }
                    }

                    if(isFound) {
                        tv.setText("You have Logged in");
                    } else {
                        tv.setText("Wrong Credenitals");
                    }
                }
                catch(Exception e){
                }
            }
        });
    }
}
