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
    private RadioGroup answerGroup1; // This is the first Group in this activity with avariable answers.
    private LinearLayout answerGroup2; // This is the second Group in this activity with avariable answers.
    // These variables are the correct answers that will be cross checked with the answers of the user.
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
        setTitle("Questions 8-10"); // Changes the title of the activity.
        btnSubmit = (Button) findViewById(R.id.submit);
        btnSubmit.setOnClickListener(handler); // Click listener for the button Submit.
        answerGroup1 = (RadioGroup) findViewById(R.id.answerGroup1);
        answerGroup2 = (LinearLayout) findViewById(R.id.answerGroup2);
        View pageView = findViewById(R.id.page); // This is the view that contains the whole actvity.
        setupParent(pageView); // A function that sets a listener which will close the keyboard whenever the user clicks outside the EditText.
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnSubmit){
                // Take the value of the selected radio button and submit it, if exists.
                try{
                    int answer1id = answerGroup1.getCheckedRadioButtonId();
                    RadioButton answer1View = (RadioButton) findViewById(answer1id);
                    MainActivity.submission8 = answer1View.getText().toString();
                    // Log.v("submission8 ", MainActivity.submission8);
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
                            MainActivity.submission9a = checkBoxView.getText().toString();
                            // Log.v("submission9a ", MainActivity.submission9a);
                            found += 1;
                        }
                        else if (found<2){
                            MainActivity.submission9b = checkBoxView.getText().toString();
                            // Log.v("submission9b ", MainActivity.submission9b);
                            found += 1;
                        }
                        else{
                            MainActivity.submission9a = "";
                            MainActivity.submission9b = "";
                            // Log.v("Submissions Erased! ", "Selected More");
                        }
                    }
                }

                // Take the value of the EditText and submit it.
                EditText answer3View = (EditText) findViewById(R.id.answer3);
                MainActivity.submission10 = answer3View.getText().toString();
                // Log.v("submission10 ", MainActivity.submission10);
                int score = calculateScore(); // Calculate the score/
                String prefix; // Change the prefix depending on the score.
                if (score>7){
                    prefix = "Congratulations";
                }
                else if (score>4){
                    prefix = "Not bad";
                }
                else{
                    prefix = "Your brain's particles are fuzzy";
                }
                showToast(score, prefix); // Show a toast message to the use with the score.
            }
        }
    };

    public void showToast(int score, String prefix){
        String show = prefix + " " + MainActivity.playerName + "!\n";
        show += "You did " + Integer.toString(score) + "/10.";
        Toast.makeText(ActivityQuestions4.this, show,
                Toast.LENGTH_LONG).show();
    }

    public int calculateScore(){ // Cross check the user's answers with the correct ones and count them.
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
