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

public class ActivityQuestions4 extends MainActivity {
    private Button btnSubmit;
    private RadioGroup answerGroup1;
    private LinearLayout answerGroup2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions4);
        setTitle("Questions 8-10");
        btnSubmit = (Button) findViewById(R.id.submit);
        btnSubmit.setOnClickListener(handler);
        answerGroup1 = (RadioGroup) findViewById(R.id.answerGroup1);
        answerGroup2 = (LinearLayout) findViewById(R.id.answerGroup2);
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnSubmit){
                int answer1id = answerGroup1.getCheckedRadioButtonId();
                RadioButton answer1View = (RadioButton) findViewById(answer1id);
                submission8 = answer1View.getText().toString();
                Log.v("submission8 ", submission8);
                int numOfCheckBoxes = answerGroup2.getChildCount();
                int found = 0;
                for (int i = 0; i < numOfCheckBoxes; i++) {
                    CheckBox checkBoxView = (CheckBox) answerGroup2.getChildAt(i);
                    if (checkBoxView.isChecked()) {
                        if (found<1){
                            submission9a = checkBoxView.getText().toString();
                            Log.v("submission9a ", submission9a);
                            found += 1;
                        }
                        else if (found<2){
                            submission9b = checkBoxView.getText().toString();
                            Log.v("submission9b ", submission9b);
                            found += 1;
                        }
                        else{
                            submission9a = "";
                            submission9b = "";
                            Log.v("Submissions Erased! ", "Selected More");
                        }
                    }
                }
                EditText answer3View = (EditText) findViewById(R.id.answer3);
                submission10 = answer3View.getText().toString();
                Log.v("submission10 ", submission10);
                try{
                    Log.v("submission1 ", submission1);
                }
                catch (Exception e){
                    Log.v("Exception ", "!!!");
                }

            }
        }
    };

}
