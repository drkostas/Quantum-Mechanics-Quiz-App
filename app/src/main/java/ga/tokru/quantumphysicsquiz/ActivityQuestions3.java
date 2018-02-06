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
                submission5 = answer1View.getText().toString();
                Log.v("submission5 ", submission5);
                int answer2id = answerGroup2.getCheckedRadioButtonId();
                RadioButton answer2View = (RadioButton) findViewById(answer2id);
                submission6 = answer2View.getText().toString();
                Log.v("submission6 ", submission6);
                int answer3id = answerGroup3.getCheckedRadioButtonId();
                RadioButton answer3View = (RadioButton) findViewById(answer3id);
                submission7 = answer3View.getText().toString();
                Log.v("submission7 ", submission7);
                Intent myIntent = new Intent(ActivityQuestions3.this, ActivityQuestions4.class);
                ActivityQuestions3.this.startActivity(myIntent);
            }
        }
    };

}
