package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.main);
        txt = this.findViewById(R.id.textView);
        //txt.setText("実験中です");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //日本語ボタン
    public void japButton(View view){
        txt.setText(R.string.jap_message);
    }

    //次へボタン
    public void subButton(View view){
        Intent intent = new Intent(this,SubActivity.class);
        intent.putExtra("message", txt.getText().toString());
        startActivity(intent);
    }

    //Englishボタン
    public void engButton(View view){
        txt.setText(R.string.eng_message);
    }

    //終了ボタンの処理
    public void exitButton(View view){
        super.finish();

    }
    //終了画面へ
    public void endButton(View view){
        setContentView(R.layout.end);
    }
}
