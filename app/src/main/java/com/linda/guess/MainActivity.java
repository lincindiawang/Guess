package com.linda.guess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int guessTime;
    String TAG = MainActivity.class.getSimpleName();
    private EditText number;
    int secret = new Random().nextInt(10) +1;
    private TextView inform;
    private TextView times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number = findViewById( R.id.ed_num);
        Log.d(TAG,"Secret : "+ secret);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    public void resert(View view){
        secret= new Random().nextInt(10)+1;
        guessTime = 0;
        number.setText(String.valueOf(guessTime));
        times.setText("");
    }

    public void Guess(View view){
        guessTime +=1;
        inform = findViewById(R.id.inform);
        times = findViewById(R.id.times);
        int num = Integer.parseInt(String.valueOf(number.getText().toString()));

        if (num > secret){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Wrong number~")
                    .setMessage("Smaller!!")
                    .setPositiveButton("OK",null)
                    .show();
            times.setText("Guess  " +  guessTime  +"  time(s)");

        }else if (num < secret){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Wrong number~")
                    .setMessage("Bigger!!")
                    .setPositiveButton("OK" , null)
                    .show();
            times.setText("Guess  " +  guessTime  +"  time(s)");

        }else {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("You Got it ~")
                    .setMessage("The number is : " + secret)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            resert(null);
//                            secret= new Random().nextInt(10)+1;
//                            guessTime = 0;
//                            number.setText(String.valueOf(guessTime));
//                            times.setText("");
                        }
                    })
                    .show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}