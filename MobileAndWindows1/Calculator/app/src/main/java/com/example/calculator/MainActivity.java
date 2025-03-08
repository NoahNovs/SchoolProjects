package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalText;
    Button zero, one, two, three, four, five, six, seven, eight, nine;
    Button clear, switchSign, percent, divide, multiply, subtract, add, total, decimal;
    //only available in landscape mode
    Button sine,cosine,tangent, log,natLog;

    //for when people click operations, this stores the first number
    double operandOne = 0;
    double operandTwo = 0;
    int count = 0;

    //need to know when to change totalText with operands, so make booleans
    boolean addition = false;
    boolean sub = false;
    boolean mult = false;
    boolean div = false;
    boolean isSecondNumber;

    mainActivityViewModel mainViewModel;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalText = findViewById(R.id.totalValue);

        mainViewModel = new ViewModelProvider(this).get((mainActivityViewModel.class));
        totalText.setText(Double.toString(mainViewModel.total));

        sine = findViewById(R.id.sinButton);
        if(sine != null)
            sine.setOnClickListener(this);
        cosine = findViewById(R.id.cosButton);
        if(cosine != null)
            cosine.setOnClickListener(this);
        tangent = findViewById(R.id.tanButton);
        if(tangent != null)
            tangent.setOnClickListener(this);
        log = findViewById(R.id.logButton);
        if(log != null)
            log.setOnClickListener(this);
        natLog = findViewById(R.id.lnButton);
        if(natLog != null)
            natLog.setOnClickListener(this);


        zero = findViewById(R.id.zeroButton);
        zero.setOnClickListener(this);

        one = findViewById(R.id.oneButton);
        one.setOnClickListener(this);

        two = findViewById(R.id.twoButton);
        two.setOnClickListener(this);

        three = findViewById(R.id.threeButton);
        three.setOnClickListener(this);

        four = findViewById(R.id.fourButton);
        four.setOnClickListener(this);

        five = findViewById(R.id.fiveButton);
        five.setOnClickListener(this);

        six = findViewById(R.id.sixButton);
        six.setOnClickListener(this);

        seven = findViewById(R.id.sevenButton);
        seven.setOnClickListener(this);

        eight = findViewById(R.id.eightButton);
        eight.setOnClickListener(this);

        nine = findViewById(R.id.nineButton);
        nine.setOnClickListener(this);

        clear = findViewById(R.id.clearButton);
        clear.setOnClickListener(this);

        switchSign = findViewById(R.id.oppSign);
        switchSign.setOnClickListener(this);

        percent = findViewById(R.id.percentButton);
        percent.setOnClickListener(this);

        divide = findViewById(R.id.divideButton);
        divide.setOnClickListener(this);

        multiply = findViewById(R.id.multiplyButton);
        multiply.setOnClickListener(this);

        subtract = findViewById(R.id.subtractButton);
        subtract.setOnClickListener(this);

        add = findViewById(R.id.addButton);
        add.setOnClickListener(this);

        total = findViewById(R.id.equalsButton);
        total.setOnClickListener(this);

        decimal = findViewById(R.id.decimalButton);
        decimal.setOnClickListener(this);

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        double temp;

        //clear the zero at first
        if((!view.equals(total)) && (totalText.getText().equals("0") || isSecondNumber || totalText.getText().equals("0.0"))) {
            totalText.setText("");
            isSecondNumber = false;
        }

        //make the numbers display
        if(view.equals(zero)) {
            totalText.setText(totalText.getText() + "0");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("ZERO", "Zero button clicked!");
        }
        else if(view.equals(one)) {
            totalText.setText(totalText.getText() + "1");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("ONE", "One button clicked!");
        }
        else if(view.equals(two)) {
            totalText.setText(totalText.getText() + "2");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("TWO", "Zero button clicked!");
        }
        else if(view.equals(three)) {
            totalText.setText(totalText.getText() + "3");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("THREE", "THREE button clicked!");
        }
        else if(view.equals(four)) {
            totalText.setText(totalText.getText() + "4");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("FOUR", "FOUR button clicked!");
        }
        else if(view.equals(five)) {
            totalText.setText(totalText.getText() + "5");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("FIVE", "FIVE button clicked!");
        }
        else if(view.equals(six)) {
            totalText.setText(totalText.getText() + "6");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("SIX", "SIX button clicked!");
        }
        else if(view.equals(seven)) {
            totalText.setText(totalText.getText() + "7");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("SEVEN", "SEVEN button clicked!");
        }
        else if(view.equals(eight)) {
            totalText.setText(totalText.getText() + "8");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("EIGHT", "EIGHT button clicked!");
        }
        else if(view.equals(nine)) {
            totalText.setText(totalText.getText() + "9");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("NINE", "NINE button clicked!");
        }
        else if (view.equals(decimal))
        {
            Log.d("DECIMAL", "DECIMAL button clicked!");
            if(!(totalText.getText().toString().contains(".")))
            {
                totalText.setText(totalText.getText() + ".");
                mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            }
        }

        //purpose for the C button
        else if(view.equals(clear)) {
            Log.d("CLEAR", "CLEAR button clicked!");
            totalText.setText("0");
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            operandOne = 0;
            operandTwo = 0;
        }

        //using switch signs button
        else if(view.equals(switchSign))
        {
            temp = Double.parseDouble(totalText.getText().toString());
            temp = temp * -1;
            totalText.setText(Double.toString(temp));
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            Log.d("SIGN", "SIGN button clicked!");
        }

        //gives percent (divides number by 100 and displays)
        else if(view.equals(percent))
        {
            Log.d("PERCENT", "PERCENT button clicked!");
            temp = Double.parseDouble(totalText.getText().toString());
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            temp /= 100;
            totalText.setText(Double.toString(temp));
        }

        //calculating material
        else if(view.equals(add))
        {
            Log.d("ADD", "ADD button clicked!");
            if(count > 0)
            {
                operandTwo = Double.parseDouble(totalText.getText().toString());
                if(addition)
                {
                    operandOne += operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(sub)
                {
                    operandOne -= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(mult)
                {
                    operandOne *= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(div)
                {
                    operandOne /= operandTwo;
                    totalText.setText(Double.toString(operandOne));
                }

            }else
            {
                operandOne = Double.parseDouble(totalText.getText().toString());
            }
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            addition = true;
            sub = false;
            div = false;
            mult = false;
            count++;
            isSecondNumber = true;
        }
        else if (view.equals(subtract))
        {
            Log.d("MINUS", "MINUS button clicked!");
            if(count > 0)
            {
                operandTwo = Double.parseDouble(totalText.getText().toString());
                if(addition)
                {
                    operandOne += operandTwo;
                    totalText.setText(Double.toString(operandOne));
                }
                else if(sub)
                {
                    operandOne -= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(mult)
                {
                    operandOne *= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(div)
                {
                    operandOne /= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
            }else
            {
                operandOne = Double.parseDouble(totalText.getText().toString());
            }
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            sub = true;
            addition = false;
            div = false;
            mult = false;
            count++;
            isSecondNumber = true;
        }
        else if (view.equals(multiply))
        {
            Log.d("MULTIPLY", "X button clicked!");
            if(count > 0)
            {
                operandTwo = Double.parseDouble(totalText.getText().toString());
                if(addition)
                {
                    operandOne += operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(sub)
                {
                    operandOne -= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(mult)
                {
                    operandOne *= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
                else if(div)
                {
                    operandOne /= operandTwo;
                    totalText.setText(Double.toString(operandOne));

                }
            }else
            {
                operandOne = Double.parseDouble(totalText.getText().toString());
            }
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            mult = true;
            div = false;
            addition = false;
            sub = false;
            count++;
            isSecondNumber = true;
        }
        else if (view.equals(divide))
        {
            Log.d("DIVIDE", "DIVIDE button clicked!");
            if(count > 0)
            {
                operandTwo = Double.parseDouble(totalText.getText().toString());
                if(addition)
                {
                    operandOne += operandTwo;
                    totalText.setText(Double.toString(operandOne));
                }
                else if(sub)
                {
                    operandOne -= operandTwo;
                    totalText.setText(Double.toString(operandOne));
                }
                else if(mult)
                {
                    operandOne *= operandTwo;
                    totalText.setText(Double.toString(operandOne));
                }
                else if(div)
                {
                    operandOne /= operandTwo;
                    totalText.setText(Double.toString(operandOne));
                }
            }else
            {
                operandOne = Double.parseDouble(totalText.getText().toString());
            }
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            div = true;
            addition = false;
            sub = false;
            mult = false;
            count++;
            isSecondNumber = true;
        }

        //functionality for equals
        else if(view.equals(total))
        {
            Log.d("EQUALS", "EQUALS button clicked!");
            operandTwo = Double.parseDouble(totalText.getText().toString());
            if(addition)
            {
                operandOne += operandTwo;
                totalText.setText(Double.toString(operandOne));
                addition = false;
            }
            else if(sub)
            {
                operandOne -= operandTwo;
                totalText.setText(Double.toString(operandOne));
                sub = false;
            }
            else if(mult)
            {
                operandOne *= operandTwo;
                totalText.setText(Double.toString(operandOne));
                mult = false;
            }
            else if(div)
            {
                operandOne /= operandTwo;
                totalText.setText(Double.toString(operandOne));
                div = false;
            }
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
            count = 0;
        }
        else if(view.equals(sine))
        {
            Log.d("SIN", "onClick: SIN button clicked!");
            operandTwo = Double.parseDouble(totalText.getText().toString());
            operandOne = Math.sin(operandTwo);
            totalText.setText(Double.toString(operandOne));
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
        }
        else if(view.equals(cosine))
        {
            Log.d("COS", "onClick: COS button clicked!");
            operandTwo = Double.parseDouble(totalText.getText().toString());
            operandOne = Math.cos(operandTwo);
            totalText.setText(Double.toString(operandOne));
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
        }
        else if(view.equals(tangent))
        {
            Log.d("TAN", "onClick: tangent button clicked!");
            operandTwo = Double.parseDouble(totalText.getText().toString());
            operandOne = Math.tan(operandTwo);
            totalText.setText(Double.toString(operandOne));
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
        }
        else if(view.equals(log))
        {
            Log.d("LOG", "onClick: LOG button clicked!");
            operandTwo = Double.parseDouble(totalText.getText().toString());
            operandOne = Math.log10(operandTwo);
            totalText.setText(Double.toString(operandOne));
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
        }
        else if(view.equals(natLog))
        {
            Log.d("ln", "onClick: NATURAL LOG button clicked!");
            operandTwo = Double.parseDouble(totalText.getText().toString());
            operandOne = Math.log(operandTwo);
            totalText.setText(Double.toString(operandOne));
            mainViewModel.total = Double.parseDouble(totalText.getText().toString());
        }



    }
}
