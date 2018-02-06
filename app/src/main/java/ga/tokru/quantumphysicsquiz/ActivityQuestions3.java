package ga.tokru.quantumphysicsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityQuestions3 extends MainActivity {
    private Button btnNext;
    private RadioGroup answerGroup2;
    private RadioGroup answerGroup3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions3);
        setTitle("Questions 5-7");
        btnNext = (Button) findViewById(R.id.next);
        btnNext.setOnClickListener(handler);
        answerGroup2 = (RadioGroup) findViewById(R.id.answerGroup2);
        answerGroup3 = (RadioGroup) findViewById(R.id.answerGroup3);
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnNext){
                EditText answer1View = (EditText) findViewById(R.id.answer1);
                MainActivity.submission5 = answer1View.getText().toString();
                Log.v("submission5 ", MainActivity.submission5);
                try {
                    int answer2id = answerGroup2.getCheckedRadioButtonId();
                    RadioButton answer2View = (RadioButton) findViewById(answer2id);
                    MainActivity.submission6 = answer2View.getText().toString();
                    Log.v("submission6 ", MainActivity.submission6);
                }
                catch(Exception e){
                    Log.v("Error", "No Radio Button Checked.");
                }
                try{
                    int answer3id = answerGroup3.getCheckedRadioButtonId();
                    RadioButton answer3View = (RadioButton) findViewById(answer3id);
                    MainActivity.submission7 = answer3View.getText().toString();
                    Log.v("submission7 ", MainActivity.submission7);
                }
                catch(Exception e){
                    Log.v("Error", "No Radio Button Checked.");
                }

                Intent myIntent = new Intent(ActivityQuestions3.this, ActivityQuestions4.class);
                ActivityQuestions3.this.startActivity(myIntent);
            }
        }
    };

}
