package ga.tokru.quantumphysicsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityQuestions2 extends MainActivity {
    private Button btnNext; // The Button that Calls  the next Activity.
    private RadioGroup answerGroup1; // This is the first Group in this activity with avariable answers.
    private LinearLayout answerGroup2; // This is the second Group in this activity with avariable answers.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setTitle("Questions 3-4"); // Changes the title of the activity.
        btnNext = (Button) findViewById(R.id.next);
        btnNext.setOnClickListener(handler); // Click listener for the button Next.
        answerGroup1 = (RadioGroup) findViewById(R.id.answerGroup1);
        answerGroup2 = (LinearLayout) findViewById(R.id.answerGroup2);
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnNext){
                // Take the value of the selected radio button and submit it, if exists.
                try {
                    int answer1id = answerGroup1.getCheckedRadioButtonId();
                    RadioButton answer1View = (RadioButton) findViewById(answer1id);
                    MainActivity.submission3 = answer1View.getText().toString();
                    // Log.v("Submission3 ", MainActivity.submission3);
                }
                catch(Exception e){
                    Log.v("Error", "No Radio Button Checked.");
                }

                // Take the value of the selected Check Boxes them.
                int numOfCheckBoxes = answerGroup2.getChildCount(); // How many children(CheckBoxes) does this view have?
                int found = 0;
                for (int i = 0; i < numOfCheckBoxes; i++) { // Iterate in CheckBoxes
                    CheckBox checkBoxView = (CheckBox) answerGroup2.getChildAt(i);
                    if (checkBoxView.isChecked()) { // If Checkbox is checked, submit the answers and erase them if he checked more.
                        if (found<1){
                            MainActivity.submission4a = checkBoxView.getText().toString();
                            // Log.v("submission4a ", MainActivity.submission4a);
                            found += 1;
                        }
                        else if (found<2){
                            MainActivity.submission4b = checkBoxView.getText().toString();
                            // Log.v("submission4b ", MainActivity.submission4b);
                            found += 1;
                        }
                        else if (found<3){
                            MainActivity.submission4c = checkBoxView.getText().toString();
                            // Log.v("submission4c ", MainActivity.submission4c);
                            found += 1;
                        }
                        else{
                            MainActivity.submission4a = "";
                            MainActivity.submission4b = "";
                            MainActivity.submission4c = "";
                            // Log.v("Submissions Erased! ", "Selected More");
                        }
                    }
                }

                // Change Activity
                Intent myIntent = new Intent(ActivityQuestions2.this, ActivityQuestions3.class);
                ActivityQuestions2.this.startActivity(myIntent); // Calls the Third Activity with the Questions.
            }
        }
    };
}
