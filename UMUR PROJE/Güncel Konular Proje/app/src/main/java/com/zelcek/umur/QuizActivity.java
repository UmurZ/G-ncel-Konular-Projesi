package com.zelcek.umur;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private List<Question> questionList;

    private ImageView questionImage;
    private TextView questionTextView;
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;
    private Button option4Button;

    private int currentQuestionIndex;

    private int wrongAnswerCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        currentQuestionIndex = 0;
        wrongAnswerCount = 0;
        LoadQuestions();

        questionImage = findViewById(R.id.imageView);
        questionTextView = findViewById(R.id.quiz_question_text);
        option1Button = findViewById(R.id.btn_a);
        option2Button = findViewById(R.id.btn_b);
        option3Button = findViewById(R.id.btn_c);
        option4Button = findViewById(R.id.btn_d);

        UpdateQuestion();

        option1Button.setOnClickListener(v -> {
            if (option1Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
        option2Button.setOnClickListener(v -> {
            if (option2Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
        option3Button.setOnClickListener(v -> {
            if (option3Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
        option4Button.setOnClickListener(v -> {
            if (option4Button.getText().equals(questionList.get(currentQuestionIndex).getCorrectAnswer())) {
                NextQuestion();
            } else {
                ShowAlertDialog(questionList.get(currentQuestionIndex).getDescription());
            }
        });
    }

    private void ShowAlertDialog(String description) {
        wrongAnswerCount++;
        AlertDialog alertDialog = new AlertDialog.Builder(QuizActivity.this).create();
        alertDialog.setTitle("Dikkat!" + (wrongAnswerCount > 2 ? " Detaylı bir göz muayenesi olmanızda fayda var." : ""));
        alertDialog.setMessage(description);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Devam et",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(wrongAnswerCount > 3) {
                            Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            dialog.dismiss();
                            NextQuestion();
                        }
                    }
                });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    // Listener for the new question button
    private void NextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex >= questionList.size()) {
            currentQuestionIndex = 0;
        }
        UpdateQuestion();
    }

    private void LoadQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question(R.drawable.img_1, "Ne görüyorsun?", "12", new String[]{"1", "2", "Hiçbir şey"}, "Renk körü olanlar ve normal görenler 12 görürler."));
        questionList.add(new Question(R.drawable.img_2, "Ne görüyorsun?", "5", new String[]{"6", "2", "Hiçbir şey"}, "Normal görenler 5 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_3, "Ne görüyorsun?", "7", new String[]{"5", "2", "Hiçbir şey"}, "Normal görenler 7 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_4, "Ne görüyorsun?", "16", new String[]{"1", "6", "Hiçbir şey"}, "Normal görenler 16 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez"));
        questionList.add(new Question(R.drawable.img_5, "Ne görüyorsun?", "73", new String[]{"3", "7", "Hiçbir şey"}, "Normal görenler 73 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_6, "Ne görüyorsun?", "Hiçbir şey", new String[]{"5", "7", "2"}, "Kırmızı ve Yeşil renk körü olanlar 5 olarak görür. Normal görenler hiçbir şey okuyamazlar."));
        questionList.add(new Question(R.drawable.img_7, "Ne görüyorsun?", "Hiçbir şey", new String[]{"5", "4", "45"}, "Kırmızı ve Yeşil renk körü olanlar 45 olarak görür. Normal görenler hiçbir şey okuyamazlar."));
        questionList.add(new Question(R.drawable.img_8, "Ne görüyorsun?", "26", new String[]{"2", "6", "Hiçbir şey"}, "Renk körü olanlar 2 veya 6 olarak görürler. Normal görenler 26 olarak okurlar."));
        questionList.add(new Question(R.drawable.img_9, "Ne görüyorsun?", "42", new String[]{"2", "4", "Hiçbir şey"}, "Renk körü olanlar 2 veya 4 olarak görürler. Normal görenler 42 olarak okurlar."));
        questionList.add(new Question(R.drawable.img_10, "Ne görüyorsun?", "8", new String[]{"3", "6", "Hiçbir şey"}, "Kırmızı - Yeşil renk körü olanlar 3 olarak okur. Normal görenler 8 olarak görür."));
        questionList.add(new Question(R.drawable.img_11, "Ne görüyorsun?", "29", new String[]{"79", "9", "Hiçbir şey"}, "Kırmızı - Yeşil renk körü olanlar 79 olarak okur. Normal görenler 29 olarak görür."));
        questionList.add(new Question(R.drawable.img_12, "Ne görüyorsun?", "5", new String[]{"2", "25", "Hiçbir şey"}, "Kırmızı - Yeşil renk körü olanlar 2 olarak okur. Normal görenler 5 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_12, "Ne görüyorsun?", "5", new String[]{"2", "25", "Hiçbir şey"}, "Kırmızı - Yeşil renk körü olanlar 2 olarak okur. Normal görenler 5 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_13, "Ne görüyorsun?", "3", new String[]{"5", "35", "Hiçbir şey"}, "Kırmızı - Yeşil renk körü olanlar 5 olarak okur. Normal görenler 3 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_14, "Ne görüyorsun?", "15", new String[]{"17", "7", "Hiçbir şey"}, "Kırmızı - Yeşil renk körü olanlar 17 olarak okur. Normal görenler 15 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_15, "Ne görüyorsun?", "74", new String[]{"21", "6", "Hiçbir şey"}, "Kırmızı - Yeşil renk körü olanlar 21 olarak okur. Normal görenler 74 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_16, "Ne görüyorsun?", "6", new String[]{"3", "9", "Hiçbir şey"}, "Normal görenler 6 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
        questionList.add(new Question(R.drawable.img_17, "Ne görüyorsun?", "45", new String[]{"4", "5", "Hiçbir şey"}, "Normal görenler 45 olarak görür. Tüm renklere karşı renk körü olanlar hiçbir şey göremez."));
    }

    private void UpdateQuestion() {
        Question question = questionList.get(currentQuestionIndex);
        questionImage.setImageResource(question.getImageId());
        questionTextView.setText(question.getQuestion());
        String[] options = new String[4];
        options[0] = question.getCorrectAnswer();
        options[1] = question.getWrongAnswers()[0];
        options[2] = question.getWrongAnswers()[1];
        options[3] = question.getWrongAnswers()[2];

        for (int i = 0; i < options.length; i++) {
            int randomIndex = (int) (Math.random() * options.length);
            String temp = options[i];
            options[i] = options[randomIndex];
            options[randomIndex] = temp;
        }

        option1Button.setText(options[0]);
        option2Button.setText(options[1]);
        option3Button.setText(options[2]);
        option4Button.setText(options[3]);
    }

    @Override
    public void onBackPressed() {
    }
}