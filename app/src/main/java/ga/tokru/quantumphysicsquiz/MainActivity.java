package ga.tokru.quantumphysicsquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnGo; // The Button that Calls  the next Activity.
    EditText nameView;  //The view in which the user will type his name.
    // These variables will be used for saving the answers of the user.
    public static String playerName = "";
    public static String submission1 = "";
    public static String submission2a = "";
    public static String submission2b = "";
    public static String submission3 = "";
    public static String submission4a = "";
    public static String submission4b = "";
    public static String submission4c = "";
    public static String submission5 = "";
    public static String submission6 = "";
    public static String submission7 = "";
    public static String submission8 = "";
    public static String submission9a = "";
    public static String submission9b = "";
    public static String submission10 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); // This prevents the keyboard from opening automatically.
        nameView = (EditText) findViewById(R.id.editName);
        btnGo = (Button) findViewById(R.id.go);
        btnGo.setOnClickListener(handler); // Click listener for the button Go.
        View pageView = findViewById(R.id.page); // This is the view that contains the whole actvity.
        setupParent(pageView); // A function that sets a listener which will close the keyboard whenever the user clicks outside the EditText.
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnGo){
                playerName = nameView.getText().toString();
                // Log.v("Player name ", playerName);

                // Change Activity
                Intent myIntent = new Intent(MainActivity.this, ActivityQuestions1.class);
                MainActivity.this.startActivity(myIntent); // Calls the First Activity with the Questions.
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
        // Hides the keyboard.
        InputMethodManager inputMethodManager = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(MainActivity.this.getCurrentFocus().getWindowToken(), 0);
    }
}
