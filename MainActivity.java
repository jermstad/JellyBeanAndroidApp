package edu.jermstadsbvcu.jellybeanestimator;
/**************************************************************************************************
 * Steven Jermstad
 * Jelly Bean Estimator
 * CMSC 355 String 2017
 *************************************************************************************************/

// imports
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import java.text.DecimalFormat;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


// Main class
public class MainActivity extends AppCompatActivity {
    // initialize all used variables from the app
    private final DecimalFormat FORMAT = new DecimalFormat("#.##");
    private EditText length;
    private EditText diameter;
    private EditText jarSize;
    private TextView result;
    private Button button;
    private int beans;  // Variable to store final answer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        length = (EditText) findViewById(R.id.length);
        diameter = (EditText) findViewById(R.id.diameter);
        jarSize = (EditText) findViewById(R.id.jarSize);
        //result = (EditText) findViewById(R.id.result);
        button = (Button) findViewById(R.id.button);
        beans = 0;
        result = (TextView) findViewById(R.id.textView8);

        // Class to start the program after the calculate button is pressed
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                double len = Double.parseDouble(length.getText().toString());
                double dia = Double.parseDouble(diameter.getText().toString());
                double jar = Double.parseDouble(jarSize.getText().toString());
                if (len == 0 | dia == 0 | jar == 0)  // Checks for 0s as inputs, gives error message
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid input, please enter a positive number";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {   // if the data is all possitve numbers, calculate solution
                    double result2 = (Math.PI / 6) * (dia * dia) * len;
                    double loadFactor = jar * 0.698;
                    double test = Math.abs(jar / result2);   // math.abs used to get the nearest whole number
                    beans = (int) test;

                    // Print the output
                    result.setText("There are approximatly " + FORMAT.format(beans) + " jelly beans in the jar");
                }


            }

        });


    }
}
