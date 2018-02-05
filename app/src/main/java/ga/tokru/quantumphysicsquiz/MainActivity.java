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
    public String playerName;
    public String answer1 = "Things having mass";
    public String answer2a = "position";
    public String answer2b = "momentum";
    public String answer3 = "Top quark";
    public String answer4a = "Tau";
    public String answer4b = "Muon";
    public String answer4c = "Electron";
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
                Log.i("Content "," Main layout ");
            }
        }
    };

}
