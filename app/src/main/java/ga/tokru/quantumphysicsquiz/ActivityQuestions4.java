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
import android.widget.Toast;

public class ActivityQuestions4 extends MainActivity {
    private Button btnSubmit;
    private RadioGroup answerGroup1;
    private LinearLayout answerGroup2;
    public String answer1 = "Things having mass";
    public String answer2a = "The position";
    public String answer2b = "The momentum";
    public String answer3 = "Top quark";
    public String answer4a = "Tau";
    public String answer4b = "Electron";
    public String answer4c = "Muon";
    public String answer5 = "fusion";
    public String answer6 = "Graviton";
    public String answer7 = "None";
    public String answer8 = "Cosmic microwave background radiation";
    public String answer9a = "Quarks";
    public String answer9b = "Gluons";
    public String answer10 = "big bang";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions4);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setTitle("Questions 8-10");
        btnSubmit = (Button) findViewById(R.id.submit);
        btnSubmit.setOnClickListener(handler);
        answerGroup1 = (RadioGroup) findViewById(R.id.answerGroup1);
        answerGroup2 = (LinearLayout) findViewById(R.id.answerGroup2);
        View pageView = findViewById(R.id.page);
        setupParent(pageView);
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnSubmit){
                try{
                    int answer1id = answerGroup1.getCheckedRadioButtonId();
                    RadioButton answer1View = (RadioButton) findViewById(answer1id);
                    MainActivity.submission8 = answer1View.getText().toString();
                    Log.v("submission8 ", MainActivity.submission8);
                }
                catch(Exception e){
                    Log.v("Error", "No Radio Button Checked.");
                }
                int numOfCheckBoxes = answerGroup2.getChildCount();
                int found = 0;
                for (int i = 0; i < numOfCheckBoxes; i++) {
                    CheckBox checkBoxView = (CheckBox) answerGroup2.getChildAt(i);
                    if (checkBoxView.isChecked()) {
                        if (found<1){
                            MainActivity.submission9a = checkBoxView.getText().toString();
                            Log.v("submission9a ", MainActivity.submission9a);
                            found += 1;
                        }
                        else if (found<2){
                            MainActivity.submission9b = checkBoxView.getText().toString();
                            Log.v("submission9b ", MainActivity.submission9b);
                            found += 1;
                        }
                        else{
                            MainActivity.submission9a = "";
                            MainActivity.submission9b = "";
                            Log.v("Submissions Erased! ", "Selected More");
                        }
                    }
                }
                EditText answer3View = (EditText) findViewById(R.id.answer3);
                MainActivity.submission10 = answer3View.getText().toString();
                Log.v("submission10 ", MainActivity.submission10);
                try{
                    Log.v("submission1 ", MainActivity.submission1);
                }
                catch (Exception e){
                    Log.v("Exception ", "!!!");
                }
                int score = calculateScore();
                String prefix;
                if (score>7){
                    prefix = "Congratulations";
                }
                else if (score>4){
                    prefix = "Not bad";
                }
                else{
                    prefix = "Your brain's particles are fuzzy";
                }
                showToast(score, prefix);

            }
        }
    };

    public void showToast(int score, String prefix){
        String show = prefix + " " + MainActivity.playerName + "!\n";
        show += "You did " + Integer.toString(score) + "/10.";
        Toast.makeText(ActivityQuestions4.this, show,
                Toast.LENGTH_LONG).show();
    }

    public int calculateScore(){
        int correct = 0;
        if (MainActivity.submission1.equals(this.answer1)){
            correct += 1;
        }
        if (MainActivity.submission2a.equals(this.answer2a) && MainActivity.submission2b.equals(this.answer2b)){
            correct += 1;
        }
        if (MainActivity.submission3.equals(this.answer3)){
            correct += 1;
        }
        if (MainActivity.submission4a.equals(this.answer4a) && MainActivity.submission4b.equals(this.answer4b) && MainActivity.submission4c.equals(this.answer4c)){
            correct += 1;
        }
        if (MainActivity.submission5.equals(this.answer5)){
            correct += 1;
        }
        if (MainActivity.submission6.equals(this.answer6)){
            correct += 1;
        }
        if (MainActivity.submission7.equals(this.answer7)){
            correct += 1;
        }
        if (MainActivity.submission8.equals(this.answer8)){
            correct += 1;
        }
        if (MainActivity.submission9a.equals(this.answer9a) && MainActivity.submission9b.equals(this.answer9b)){
            correct += 1;
        }
        if (MainActivity.submission10.equals(this.answer10)){
            correct += 1;
        }
        return correct;
    }

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
        InputMethodManager inputMethodManager = (InputMethodManager) ActivityQuestions4.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(ActivityQuestions4.this.getCurrentFocus().getWindowToken(), 0);
    }
}
