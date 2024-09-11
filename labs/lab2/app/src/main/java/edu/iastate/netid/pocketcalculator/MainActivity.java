package edu.iastate.netid.pocketcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /**
     * The instance of the calculator model for use by this controller.
     */
    private final CalculationStream mCalculationStream = new CalculationStream();

    /*
     * The instance of the calculator display TextView. You can use this to update the calculator display.
     */
    private TextView mCalculatorDisplay;

    private Button ClearBtn;
    private Button EqualsBtn;
    private Button DecimalBtn;
    private Button DivideBtn;
    private Button AddBtn;
    private Button SubtractBtn;
    private Button MultiplyBtn;
    private Button Btn1;
    private Button Btn2;
    private Button Btn3;
    private Button Btn4;
    private Button Btn5;
    private Button Btn6;
    private Button Btn7;
    private Button Btn8;
    private Button Btn9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO - uncomment the below line after you make your layout. This line locates
           the instance of the calculator display's TextView.  You need to create this TextView
           and set its ID to CalculatorDisplay in your layout resource file.
         */
        mCalculatorDisplay = findViewById(R.id.CalculatorDisplay);
        EqualsBtn = findViewById(R.id.btnEquals);
        ClearBtn = findViewById(R.id.clear_btn);
        MultiplyBtn = findViewById(R.id.btnMultiply);
        DivideBtn = findViewById(R.id.btnDivide);
        AddBtn = findViewById(R.id.btnAdd);
        SubtractBtn = findViewById(R.id.btnSubtract);
        DecimalBtn = findViewById(R.id.btnDecimal);
        Btn1 = findViewById(R.id.btn1);
        Btn2 = findViewById(R.id.btn2);
        Btn3 = findViewById(R.id.btn3);
        Btn4 = findViewById(R.id.btn4);
        Btn5 = findViewById(R.id.btn5);
        Btn6 = findViewById(R.id.btn6);
        Btn7 = findViewById(R.id.btn7);
        Btn8 = findViewById(R.id.btn8);
        Btn9 = findViewById(R.id.btn9);

    }

    /* TODO - add event listeners for your calculator's buttons. See the model's API to figure out
       what methods should be called. The equals button event listener has been done for you. Once
       you've created the layout, you'll need to add these methods as the onClick() listeners
       for the corresponding buttons in the XML layout. */

    public void onEqualClicked(View view) {
        try {
            mCalculationStream.calculateResult();
        } finally {
            updateCalculatorDisplay();
        }
    }

    /**
     * Call this method after every button press to update the text display of your calculator.
     */
    public void updateCalculatorDisplay() {
        String value = getString(R.string.empty);
        try {
            value = Double.toString(mCalculationStream.getCurrentOperand());
        } catch(NumberFormatException e) {
            value = getString(R.string.error);
        } finally {
            // TODO: this value may need to be formatted first so it fits on one line... try 0.8 - 0.2
            mCalculatorDisplay.setText(value);
        }
    }
}
