package my.edu.tarc.loancalculatorintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewDP, textViewLP, textViewIR, textViewMP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewDP = (TextView)findViewById(R.id.textViewDownPayment);
        textViewLP = (TextView)findViewById(R.id.textViewLoanPeriod);
        textViewIR = (TextView)findViewById(R.id.textViewInterestRate);
        textViewMP = (TextView)findViewById(R.id.textViewMonthPayment);

        Intent intent = getIntent();
        double dp = intent.getDoubleExtra("Downpayment",0.0);
        double ir = intent.getDoubleExtra("InterestRate",0.0);
        int lp = intent.getIntExtra("LoanPeriod", 0);
        double mp = intent.getDoubleExtra("MonthlyRepayment", 0.0);

        textViewDP.append(": "+String.format("%.2f",dp));
        textViewLP.append(": "+String.format("%d",lp));
        textViewIR.append(": "+String.format("%.2f",ir));
        textViewMP.append(": "+String.format("%.2f",mp));
    }

    public void close(View v){
        finish();
    }



}
