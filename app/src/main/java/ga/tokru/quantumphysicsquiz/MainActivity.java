package ga.tokru.quantumphysicsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnGo;
    EditText nameView;
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
        nameView = (EditText) findViewById(R.id.editName);
        btnGo = (Button) findViewById(R.id.go);
        btnGo.setOnClickListener(handler);
    }

    View.OnClickListener handler = new View.OnClickListener(){
        public void onClick(View v) {
            if(v==btnGo){
                playerName = nameView.getText().toString();
                Log.v("Player name ", playerName);
                Intent myIntent = new Intent(MainActivity.this, ActivityQuestions1.class);
                MainActivity.this.startActivity(myIntent);
            }
        }
    };

}
