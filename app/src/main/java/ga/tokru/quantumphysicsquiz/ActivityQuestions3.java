package ga.tokru.quantumphysicsquiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityQuestions3 extends MainActivity {
    private Button btnNext; // The Button that Calls  the next Activity.
    private RadioGroup answerGroup2; // This is the second Group in this activity with avariable answers.
    private RadioGroup answerGroup3; // This is the third Group in this activity with avariable answers.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions3);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setTitle("Questions 5-7"); // Changes the title of the activity.
        btnNext = (Button) findViewById(R.id.next);
        btnNext.setOnClickListener(handler); // Click listener for the button Next.
        answerGroup2 = (RadioGroup) findViewById(R.id.answerGroup2);
        answerGroup3 = (RadioGroup) findViewById(R.id.answerGroup3);
        View pageView = findViewById(R.id.page); // This is the view that contains the whole actvity.
        setupParent(pageView); // A function that sets a listener which will close the keyboard whenever the user clicks outside the EditText.
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnNext){
                // Take the value of the EditText and submit it.
                EditText answer1View = (EditText) findViewById(R.id.answer1);
                MainActivity.submission5 = answer1View.getText().toString();
                // Log.v("submission5 ", MainActivity.submission5);

                // Take the value of the selected radio button and submit it, if exists.
                try {
                    int answer2id = answerGroup2.getCheckedRadioButtonId();
                    RadioButton answer2View = (RadioButton) findViewById(answer2id);
                    MainActivity.submission6 = answer2View.getText().toString();
                    // Log.v("submission6 ", MainActivity.submission6);
                }
                catch(Exception e){
                    // Log.v("Error", "No Radio Button Checked.");
                }

                // Take the value of the selected radio button and submit it, if exists.
                try{
                    int answer3id = answerGroup3.getCheckedRadioButtonId();
                    RadioButton answer3View = (RadioButton) findViewById(answer3id);
                    MainActivity.submission7 = answer3View.getText().toString();
                    // Log.v("submission7 ", MainActivity.submission7);
                }
                catch(Exception e){
                    Log.v("Error", "No Radio Button Checked.");
                }

                // Change Activity
                Intent myIntent = new Intent(ActivityQuestions3.this, ActivityQuestions4.class);
                ActivityQuestions3.this.startActivity(myIntent); // Calls the Fourth Activity with the Questions.
            }
        }
    };

    protected void setupParent(View view) {
        //Set up touch listener for non-text box views to hide keyboard.
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard();
                    return false;
                }
            });
        }
        //If a layout container, iterate over children
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupParent(innerView);
            }
        }
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) ActivityQuestions3.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(ActivityQuestions3.this.getCurrentFocus().getWindowToken(), 0);
    }
}
