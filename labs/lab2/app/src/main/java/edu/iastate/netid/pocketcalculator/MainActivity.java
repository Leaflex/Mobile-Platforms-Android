package edu.iastate.netid.pocketcalculator;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO - uncomment the below line after you make your layout. This line locates
           the instance of the calculator display's TextView.  You need to create this TextView
           and set its ID to CalculatorDisplay in your layout resource file.
         */
        mCalculatorDisplay = findViewById(R.id.CalculatorDisplay);

        Button equalsBtn = findViewById(R.id.btnEquals);
        Button clearBtn = findViewById(R.id.clear_btn);
        Button MultiplyBtn = findViewById(R.id.btnMultiply);
        Button DivideBtn = findViewById(R.id.btnDivide);
        Button AddBtn = findViewById(R.id.btnAdd);
        Button SubtractBtn = findViewById(R.id.btnSubtract);
        Button DecimalBtn = findViewById(R.id.btnDecimal);

        equalsBtn.setOnClickListener(view -> {
            try {
                mCalculationStream.calculateResult();
            } finally {
                updateCalculatorDisplay();
            }
        });
        clearBtn.setOnClickListener(view -> {
            try {
                mCalculationStream.clear();
            } finally {
                updateCalculatorDisplay();
            }
        });
        MultiplyBtn.setOnClickListener(view -> {
            try {
                mCalculationStream.inputOperation(CalculationStream.Operation.MULTIPLY);
            } finally {
                updateCalculatorDisplay();
            }
        });
        DivideBtn.setOnClickListener(view -> {
            try {
                mCalculationStream.inputOperation(CalculationStream.Operation.DIVIDE);
            } finally {
                updateCalculatorDisplay();
            }
        });
        AddBtn.setOnClickListener(view -> {
            try {
                mCalculationStream.inputOperation(CalculationStream.Operation.ADD);
            } finally {
                updateCalculatorDisplay();
            }
        });
        SubtractBtn.setOnClickListener(view -> {
            try {
                mCalculationStream.inputOperation(CalculationStream.Operation.SUBTRACT);
            } finally {
                updateCalculatorDisplay();
            }
        });
        DecimalBtn.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.DECIMAL);
            } finally {
                updateCalculatorDisplay();
            }
        });

        Button Btn0 = findViewById(R.id.btn0);
        Button Btn1 = findViewById(R.id.btn1);
        Button Btn2 = findViewById(R.id.btn2);
        Button Btn3 = findViewById(R.id.btn3);
        Button Btn4 = findViewById(R.id.btn4);
        Button Btn5 = findViewById(R.id.btn5);
        Button Btn6 = findViewById(R.id.btn6);
        Button Btn7 = findViewById(R.id.btn7);
        Button Btn8 = findViewById(R.id.btn8);
        Button Btn9 = findViewById(R.id.btn9);

        Btn0.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.ZERO);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn1.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.ONE);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn2.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.TWO);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn3.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.THREE);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn4.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.FOUR);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn5.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.FIVE);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn6.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.SIX);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn7.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.SEVEN);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn8.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.EIGHT);
            } finally {
                updateCalculatorDisplay();
            }


        });
        Btn9.setOnClickListener(view -> {
            try {
                mCalculationStream.inputDigit(CalculationStream.Digit.NINE);
            } finally {
                updateCalculatorDisplay();
            }


        });


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
