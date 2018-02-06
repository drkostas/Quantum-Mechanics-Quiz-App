package ga.tokru.quantumphysicsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityQuestions1 extends MainActivity {
    private Button btnNext;
    private RadioGroup answerGroup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions1);
        setTitle("Questions 1-2");
        btnNext = (Button) findViewById(R.id.next);
        btnNext.setOnClickListener(handler);
        answerGroup1 = (RadioGroup) findViewById(R.id.answerGroup1);
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            Log.v("Next ", "Clicked");
            if(v==btnNext){
                int answer1id = answerGroup1.getCheckedRadioButtonId();
                RadioButton answer1View = (RadioButton) findViewById(answer1id);
                submission1 = answer1View.getText().toString();
                Log.v("Submission1 ", submission1);
//                Intent myIntent = new Intent(ActivityQuestions1.this, ActivityQuestions2.class);
//                ActivityQuestions1.this.startActivity(myIntent);
            }
        }
    };

}
