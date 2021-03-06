package my.edu.tarc.loancalculatorintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextVP, editTextD, editTextLP, editTextIR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextVP = (EditText) findViewById(R.id.editTextVehiclePrice);
        editTextD = (EditText) findViewById(R.id.editTextDownpayment);
        editTextIR = (EditText) findViewById(R.id.editTextInterestRate);
        editTextLP = (EditText) findViewById(R.id.editTextLoanPeriod);
    }

    public void calculate(View v) {
        Intent intent = new Intent(this,ResultActivity.class);

        try {
            double vp, dp, ir, mp;
            int lp;
            vp = Double.parseDouble(editTextVP.getText().toString());
            dp = Double.parseDouble(editTextD.getText().toString());
            ir = Double.parseDouble(editTextIR.getText().toString()) / 100;
            lp = Integer.parseInt(editTextLP.getText().toString());
            if (ir > 1.0)
                Toast.makeText(getApplication().getBaseContext(), "Interest Rate should not more than 100!", Toast.LENGTH_SHORT).show();
            else if (vp < dp)
                Toast.makeText(getApplication().getBaseContext(), "Vehicle price should be larger than downpayment!", Toast.LENGTH_SHORT).show();
            else {
                mp = ((vp-dp)+((vp-dp)*ir*lp))/ lp/12;
                intent.putExtra("Downpayment",dp);
                intent.putExtra("InterestRate",ir);
                intent.putExtra("LoanPeriod", lp);
                intent.putExtra("MonthlyRepayment", mp);
                startActivity(intent);
            }
        } catch (Exception e) {
            Toast.makeText(getApplication().getBaseContext(), "Enter a value!", Toast.LENGTH_SHORT).show();
        }

    }
}
