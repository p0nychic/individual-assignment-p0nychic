package au.edu.unsw.borrowingcapacity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText incomeEditText; //user input into the incomeTEditText
    EditText expensesEditText; //user input into the expensesEditText
    EditText interestRateEditText; //user input into the interestRateEditText
    EditText loanTermEditText; //user input into the loanTermEditText
    Button  resultButton; // action button to generate results of the user inputs above upon a single click
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeEditText = (EditText) findViewById(R.id.incomeEditText);
        expensesEditText = (EditText) findViewById(R.id.expensesEditText);
        interestRateEditText = (EditText) findViewById(R.id.interestRateEditText);
        loanTermEditText = (EditText) findViewById(R.id.loanYearsEditText);
        resultButton = (Button) findViewById(R.id.resultButton);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBorrowingPower();
            }
        });
    }

    public void calculateBorrowingPower() { // assigning the numeric data types for the user inputs
        double income = Double.parseDouble(incomeEditText.getText().toString());
        double expenses = Double.parseDouble(expensesEditText.getText().toString());
        double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
        int loanTerm = Integer.parseInt(loanTermEditText.getText().toString());


        double borrowingPower = calculateBorrowingPower(income, expenses, interestRate, loanTerm);


        // When user data input has been performed in the activity_main.xml and now that data has to
        // be transferred to the next user interface on activity_main2.xml
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("BORROWING_POWER", borrowingPower);
        intent.putExtra("INCOME", income);
        intent.putExtra("EXPENSES", expenses);
        intent.putExtra("INTEREST_RATE", interestRate);
        intent.putExtra("LOAN_TERM", loanTerm);
        startActivity(intent);

    }

    // formula derived for calculating Borrowing Power of the user
    private double calculateBorrowingPower(double income, double expenses, double interestRate, int loanTerm) {
        double borrowingPower = (income - expenses) * (interestRate / 100) * loanTerm;

        return borrowingPower;
    }
}