package au.edu.unsw.borrowingcapacity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

// borrowing power calculating factors on activity_main2.xml interface
public class MainActivity2 extends AppCompatActivity {
    private TextView incomeTextView;
    private TextView expensesTextView;
    private TextView interestRateTextView;
    private TextView loanTermTextView;
    private TextView borrowingPowerTextView;

    private Button tryAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // applying the user data input into the activity_main2 interface that was generated from the activity_main interface initially
        double borrowingPower = getIntent().getDoubleExtra("BORROWING_POWER", 0.0);
        double income = getIntent().getDoubleExtra("INCOME", 0.0);
        double expenses = getIntent().getDoubleExtra("EXPENSES", 0.0);
        double interestRate = getIntent().getDoubleExtra("INTEREST_RATE", 0.0);
        int loanTerm = getIntent().getIntExtra("LOAN_TERM", 0);


        incomeTextView = findViewById(R.id.incomeTextView);
        expensesTextView = findViewById(R.id.expensesTextView);
        interestRateTextView = findViewById(R.id.interestRateTextView);
        loanTermTextView = findViewById(R.id.loanTermTextView);
        borrowingPowerTextView = findViewById(R.id.borrowingPowerTextView);
        tryAgainButton = (Button)findViewById(R.id.tryAgainButton);


        // expressing all the user data inputs for borrowing power derivation as string data type
        incomeTextView.setText(String.valueOf(income));
        expensesTextView.setText(String.valueOf(expenses));
        interestRateTextView.setText(String.valueOf(interestRate));
        loanTermTextView.setText(String.valueOf(loanTerm));
        borrowingPowerTextView.setText(String.valueOf(borrowingPower));

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
