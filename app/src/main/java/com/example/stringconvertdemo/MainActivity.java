package com.example.stringconvertdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

//去除ＡＰＩ回覆字串中的反斜線 \

public class MainActivity extends AppCompatActivity {
    String str,strlbl;
    JSONObject ob;
    private View.OnClickListener btn1_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            str = txt1.getText().toString();
            strlbl=str.replace ("\\","");

            try {
            ob = new JSONObject(strlbl);
            lbl1.setText(ob.getString("ReturnCode"));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
    }

    private void InitialComponent() {
        txt1 = findViewById(R.id.txt1);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(btn1_click);
        lbl1=findViewById(R.id.lbl1);
    }

    EditText txt1;
    TextView lbl1;
    Button btn1;
}
