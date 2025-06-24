package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import com.example.quiz.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private String rightAnswer;
    private int rightAnswerCount;
    private int quizCount =1 ;

    private final ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    private final String[][] quizData = {
            //{"都道府県名","正解","選択肢１","選択肢２","選択肢３"}
            {"北海道","札幌市","長崎市","福島市","前橋市"},
            {"青森県","青森市","広島市","甲府市","岡山市"},
            {"岩手県","盛岡市","大分市","秋田市","福岡市",},
            {"宮城県","仙台市","水戸市","岐阜市","福井市",},
            {"秋田県","秋田市","横浜市","鳥取市","仙台市",},
            {"山形県","山形市","青森市","山口市","奈良市",},
            {"福島市","福島市","盛岡市","新宿区","京都市",},
            {"茨城県","水戸市","金沢市","名古屋市","奈良市",},
            {"栃木県","宇都宮市","札幌市","岡山市","奈良市",},
            {"群馬県","前橋市","福岡市","松江市","福井市",}

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        binding.answerBtn1.setOnClickListener(this);
        binding.answerBtn2.setOnClickListener(this);
        binding.answerBtn3.setOnClickListener(this);
        binding.answerBtn4.setOnClickListener(this);

        for (String[] quizDatum : quizData) {
            //一時的に使うArrayListを作成
            ArrayList<String> tempArray = new ArrayList<>();

            //tempArrayに「問題・解答・選択肢３つを入れていく」
            tempArray.add(quizDatum[0]);
            tempArray.add(quizDatum[1]);
            tempArray.add(quizDatum[2]);
            tempArray.add(quizDatum[3]);
            tempArray.add(quizDatum[4]);

            //tempArrayをquizArrayに追加
            quizArray.add(tempArray);

        }

        Collections.shuffle(quizArray);

        showNextQuiz();
    }

    //クイズを出題する
    @SuppressLint("StringFormatInvalid")

    private void showNextQuiz() {

        //countLabel.setText("第"+quizCount+"問");
        binding.countLabel.setText(getString(R.string.count_label, quizCount));

        //クイズを１問取り出す
        ArrayList<String> quiz = quizArray.get(0);

        //問題を表示
        binding.questionLabal.setText(quiz.get(0));

        //正解を用意

        rightAnswer = quiz.get(1);

        //問題を削除

        quiz.remove(0);

        //正解と選択肢３つをシャッフル

        Collections.shuffle(quiz);

        //正解と選択肢をボタンに表示
        binding.answerBtn1.setText(quiz.get(0));
        binding.answerBtn2.setText(quiz.get(1));
        binding.answerBtn3.setText(quiz.get(2));
        binding.answerBtn4.setText(quiz.get(3));

        quizArray.remove(0);


    }

    @Override
    public void onClick(View v) {
        //押されたボタンのテキストを取得
        Button answerBtn = findViewById(v.getId());
        String btnText = answerBtn.getText().toString();

        String dialogTitle;

        if(rightAnswer.equals(btnText)){
            //正解
            dialogTitle="正解！";
            rightAnswerCount++;

        }else{
           //不正解
            dialogTitle="不正解...";
        }

        //ダイアログオブジェクトを作成
        DialogFragment dialogFragment = new AnswerDialogFragment();

        //ダイアログに値を渡す
        Bundle args = new Bundle();
        args.putString("TITLE",dialogTitle);
        args.putString("MESSAGE",rightAnswer);
        dialogFragment.setArguments(args);

        //ダイアログが閉じないようにする

        dialogFragment.setCancelable(false);

        //ダイアログの表示

        dialogFragment.show(getSupportFragmentManager(),"answer_dialog");



    }

    public void checkQuizCount(){

        if(quizCount==5){

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
            startActivity(intent);

        }else{
            quizCount++;
            showNextQuiz();

        }

    }
}
