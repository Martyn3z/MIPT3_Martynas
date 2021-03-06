package com.example.mipt3_martynas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView Result;
    private float FinalResult = 0, Memory = 0;
    boolean OperatorToggle = false, IsActionDone = false, SumOn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Zero = findViewById(R.id.buttonZero);
        Button One = findViewById(R.id.buttonOne);
        Button Two = findViewById(R.id.buttonTwo);
        Button Three = findViewById(R.id.buttonThree);
        Button Four = findViewById(R.id.buttonFour);
        Button Five = findViewById(R.id.buttonFive);
        Button Six = findViewById(R.id.buttonSix);
        Button Seven = findViewById(R.id.buttonSeven);
        Button Eight = findViewById(R.id.buttonEight);
        Button Nine = findViewById(R.id.buttonNine);
        Button Dot = findViewById(R.id.buttonDot);
        Button EmptyAll = findViewById(R.id.buttonEmpty);
        Button Empty = findViewById(R.id.buttonDelete);
        Button Delete = findViewById(R.id.buttonBack);
        Button Plus = findViewById(R.id.buttonPlus);
        Button Count = findViewById(R.id.buttonCount);
        Button Divide = findViewById(R.id.buttonDivide);
        Button Root = findViewById(R.id.buttonRoot);
        Button Sign = findViewById(R.id.buttonSign);
        Button Multiply = findViewById(R.id.buttonMultiply);
        Button Minus = findViewById(R.id.buttonMinus);

        Result = findViewById(R.id.MainScreen);

        Zero.setOnClickListener(this);
        One.setOnClickListener(this);
        Two.setOnClickListener(this);
        Three.setOnClickListener(this);
        Four.setOnClickListener(this);
        Five.setOnClickListener(this);
        Six.setOnClickListener(this);
        Seven.setOnClickListener(this);
        Eight.setOnClickListener(this);
        Nine.setOnClickListener(this);
        Dot.setOnClickListener(this);
        Delete.setOnClickListener(this);
        EmptyAll.setOnClickListener(this);
        Empty.setOnClickListener(this);
        Plus.setOnClickListener(this);
        Count.setOnClickListener(this);
        Divide.setOnClickListener(this);
        Root.setOnClickListener(this);
        Sign.setOnClickListener(this);
        Minus.setOnClickListener(this);
        Multiply.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        String ResultString = (String) Result.getText();

        if ((Result.getText()).charAt(0) == '0' && (findViewById(R.id.buttonDot)).isEnabled() || IsActionDone || Result.getText() == "NaN" || SumOn)
        {
            (findViewById(R.id.buttonZero)).setEnabled(true);
            (findViewById(R.id.buttonEmpty)).setEnabled(true);
            (findViewById(R.id.buttonDelete)).setEnabled(true);
            (findViewById(R.id.buttonBack)).setEnabled(true);
            (findViewById(R.id.buttonRoot)).setEnabled(true);
            (findViewById(R.id.buttonDivide)).setEnabled(true);
            (findViewById(R.id.buttonDot)).setEnabled(true);
            (findViewById(R.id.buttonSign)).setEnabled(true);
            (findViewById(R.id.buttonCount)).setEnabled(true);
            (findViewById(R.id.buttonPlus)).setEnabled(true);
            (findViewById(R.id.buttonMinus)).setEnabled(true);
            (findViewById(R.id.buttonDivide)).setEnabled(true);
            (findViewById(R.id.buttonMultiply)).setEnabled(true);
            (findViewById(R.id.buttonSign)).setEnabled(true);

            SumOn = false;
            IsActionDone = false;

            switch (v.getId()) {
                case R.id.buttonZero:
                    Result.setText("0");
                    break;

                case R.id.buttonOne:
                    Result.setText("1");
                    break;

                case R.id.buttonTwo:
                    Result.setText("2");
                    break;

                case R.id.buttonThree:
                    Result.setText("3");
                    break;

                case R.id.buttonFour:
                    Result.setText("4");
                    break;

                case R.id.buttonFive:
                    Result.setText("5");
                    break;

                case R.id.buttonSix:
                    Result.setText("6");
                    break;

                case R.id.buttonSeven:
                    Result.setText("7");
                    break;

                case R.id.buttonEight:
                    Result.setText("8");
                    break;

                case R.id.buttonNine:
                    Result.setText("9");
                    break;


                case R.id.buttonBack:
                    if ((Result.getText()).charAt((Result.getText()).length() -1) == '.')
                        (findViewById(R.id.buttonDot)).setEnabled(true);
                    if ((Result.getText()).length() > 1 && (Result.getText()).charAt((Result.getText()).length() -1) != '.') {
                        ResultString = ResultString.substring(0, ResultString.length() - 1);
                        Result.setText(ResultString);
                        (findViewById(R.id.buttonZero)).setEnabled(true);
                    }
                    else {
                        Result.setText("0");
                        (findViewById(R.id.buttonZero)).setEnabled(false);
                        (findViewById(R.id.buttonBack)).setEnabled(false);
                        (findViewById(R.id.buttonDelete)).setEnabled(false);
                        (findViewById(R.id.buttonBack)).setEnabled(false);
                    }
                    break;

                case R.id.buttonEmpty:
                    Memory = 0;
                    Result.setText("0");
                    FinalResult = 0;
                    (findViewById(R.id.buttonBack)).setEnabled(false);
                    (findViewById(R.id.buttonZero)).setEnabled(false);
                    (findViewById(R.id.buttonEmpty)).setEnabled(false);
                    (findViewById(R.id.buttonDelete)).setEnabled(false);
                    (findViewById(R.id.buttonDot)).setEnabled(true);
                    break;

                case R.id.buttonDelete:
                    Result.setText("0");
                    FinalResult = 0;
                    (findViewById(R.id.buttonBack)).setEnabled(false);
                    (findViewById(R.id.buttonZero)).setEnabled(false);
                    (findViewById(R.id.buttonDelete)).setEnabled(false);
                    (findViewById(R.id.buttonDot)).setEnabled(true);
                    break;

                case R.id.buttonDot:
                    Result.setText(Result.getText() + ".");
                    (findViewById(R.id.buttonDot)).setEnabled(false);
                    break;

                case R.id.buttonMinus:
                    if (!SumOn)
                        FinalResult = FinalResult - Float.parseFloat((Result.getText()).toString());
                    Result.setText("0");
                    break;

                case R.id.buttonPlus:
                    if (!SumOn)
                    FinalResult = FinalResult + Float.parseFloat((Result.getText()).toString());
                    Result.setText("0");
                    break;

                case R.id.buttonMultiply:
                    if (FinalResult == 0)
                        FinalResult = Float.parseFloat((Result.getText()).toString());
                    else {
                        IsActionDone = true;
                        FinalResult = FinalResult * Float.parseFloat((Result.getText()).toString());
                    }
                    Result.setText("0");
                    break;

                case R.id.buttonDivide:
                    if (Result.getText().toString().equals("0"))
                        Result.setText("NaN");
                    else {
                        if (FinalResult == 0)
                            FinalResult = Float.parseFloat((Result.getText()).toString());
                        else {
                            IsActionDone = true;
                            FinalResult = FinalResult / Float.parseFloat((Result.getText()).toString());
                        }
                        Result.setText("0");
                    }
                    break;

                case R.id.buttonCount:
                    (findViewById(R.id.buttonPlus)).setEnabled(false);
                    (findViewById(R.id.buttonMinus)).setEnabled(false);
                    (findViewById(R.id.buttonDivide)).setEnabled(false);
                    (findViewById(R.id.buttonMultiply)).setEnabled(false);
                    (findViewById(R.id.buttonDot)).setEnabled(false);

                    if (FinalResult == 0)
                    {
                        FinalResult = Float.parseFloat((Result.getText()).toString());
                    }
                    Result.setText(Float.toString(FinalResult));
                    (findViewById(R.id.buttonCount)).setEnabled(false);
                    SumOn = true;
                    break;

                case R.id.buttonRoot:
                    if (Float.parseFloat(Result.getText().toString()) < 0)
                        Result.setText("NaN");
                    else
                        Result.setText(Float.toString(((float) Math.sqrt(Float.parseFloat(Result.getText().toString())))));
                    break;

                case R.id.buttonSign:
                    (findViewById(R.id.buttonDot)).setEnabled(false);

                    FinalResult = FinalResult * -1;
                    Result.setText(Float.toString(FinalResult));

                    SumOn = true;
                    break;
            }

        }
        else {
            switch (v.getId()) {
                case R.id.buttonZero:
                    Result.setText(Result.getText() + "0");
                    break;

                case R.id.buttonOne:
                    Result.setText(Result.getText() + "1");
                    break;

                case R.id.buttonTwo:
                    Result.setText(Result.getText() + "2");
                    break;

                case R.id.buttonThree:
                    Result.setText(Result.getText() + "3");
                    break;

                case R.id.buttonFour:
                    Result.setText(Result.getText() + "4");
                    break;

                case R.id.buttonFive:
                    Result.setText(Result.getText() + "5");
                    break;

                case R.id.buttonSix:
                    Result.setText(Result.getText() + "6");
                    break;

                case R.id.buttonSeven:
                    Result.setText(Result.getText() + "7");
                    break;

                case R.id.buttonEight:
                    Result.setText(Result.getText() + "8");
                    break;

                case R.id.buttonNine:
                    Result.setText(Result.getText() + "9");
                    break;

                case R.id.buttonBack:
                    if ((Result.getText()).charAt((Result.getText()).length() -1) == '.')
                        (findViewById(R.id.buttonDot)).setEnabled(true);
                    if ((Result.getText()).length() > 1 && (Result.getText()).charAt((Result.getText()).length() -1) != '.') {
                        ResultString = ResultString.substring(0, ResultString.length() - 1);
                        Result.setText(ResultString);
                        (findViewById(R.id.buttonZero)).setEnabled(true);
                    }
                    else {
                        Result.setText("0");
                        (findViewById(R.id.buttonZero)).setEnabled(false);
                        (findViewById(R.id.buttonBack)).setEnabled(false);
                        (findViewById(R.id.buttonDelete)).setEnabled(false);
                        (findViewById(R.id.buttonBack)).setEnabled(false);
                    }
                    break;

                case R.id.buttonEmpty:
                    Memory = 0;
                    Result.setText("0");
                    FinalResult = 0;
                    (findViewById(R.id.buttonBack)).setEnabled(false);
                    (findViewById(R.id.buttonZero)).setEnabled(false);
                    (findViewById(R.id.buttonEmpty)).setEnabled(false);
                    (findViewById(R.id.buttonDelete)).setEnabled(false);
                    (findViewById(R.id.buttonDot)).setEnabled(true);
                    break;

                case R.id.buttonDelete:
                    Result.setText("0");
                    FinalResult = 0;
                    (findViewById(R.id.buttonBack)).setEnabled(false);
                    (findViewById(R.id.buttonZero)).setEnabled(false);
                    (findViewById(R.id.buttonDelete)).setEnabled(false);
                    (findViewById(R.id.buttonDot)).setEnabled(true);
                    break;

                case R.id.buttonDot:
                    Result.setText(Result.getText() + ".");
                    (findViewById(R.id.buttonDot)).setEnabled(false);
                    break;

                case R.id.buttonMultiply:
                    if (FinalResult == 0)
                        FinalResult = Float.parseFloat((Result.getText()).toString());
                    else {
                        IsActionDone = true;
                        FinalResult = FinalResult * Float.parseFloat((Result.getText()).toString());
                    }
                    Result.setText("0");
                    break;

                case R.id.buttonMinus:
                    IsActionDone = true;
                    if (FinalResult == 0)
                        FinalResult = Float.parseFloat((Result.getText()).toString());
                    else
                        FinalResult = FinalResult - Float.parseFloat((Result.getText()).toString());
                    Result.setText("0");
                    break;

                case R.id.buttonPlus:
                    IsActionDone = true;
                    FinalResult = FinalResult + Float.parseFloat((Result.getText()).toString());
                    Result.setText("0");
                    break;

                case R.id.buttonRoot:
                    IsActionDone = true;
                    if (Float.parseFloat(Result.getText().toString()) < 0)
                        Result.setText("NaN");
                    else
                        Result.setText(Float.toString(((float) Math.sqrt(Float.parseFloat(Result.getText().toString())))));
                    break;

                case R.id.buttonDivide:
                    if (Result.getText().toString().equals("0"))
                        Result.setText("NaN");
                    else {
                        if (FinalResult == 0)
                            FinalResult = Float.parseFloat((Result.getText()).toString());
                        else {
                            IsActionDone = true;
                            FinalResult = FinalResult / Float.parseFloat((Result.getText()).toString());
                        }
                        Result.setText("0");
                    }
                    break;

                case R.id.buttonCount:
                    (findViewById(R.id.buttonPlus)).setEnabled(false);
                    (findViewById(R.id.buttonMinus)).setEnabled(false);
                    (findViewById(R.id.buttonDivide)).setEnabled(false);
                    (findViewById(R.id.buttonMultiply)).setEnabled(false);
                    (findViewById(R.id.buttonDot)).setEnabled(false);

                    if (FinalResult == 0)
                    {
                        FinalResult = Float.parseFloat((Result.getText()).toString());
                    }
                    Result.setText(Float.toString(FinalResult));
                    SumOn = true;
                    (findViewById(R.id.buttonCount)).setEnabled(false);
                    break;

                case R.id.buttonSign:
                    (findViewById(R.id.buttonDot)).setEnabled(false);

                    Result.setText(Float.toString(Float.parseFloat((Result.getText()).toString()) * -1));

                    SumOn = true;
                    break;
            }
        }
    }
}