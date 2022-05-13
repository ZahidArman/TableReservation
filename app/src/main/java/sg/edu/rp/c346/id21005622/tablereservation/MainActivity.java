package sg.edu.rp.c346.id21005622.tablereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNum;
    EditText etPax;
    CheckBox cbSeat;
    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    Button btnReserve;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etNum = findViewById(R.id.editTextNumber);
        etPax = findViewById(R.id.editTextPax);
        cbSeat = findViewById(R.id.checkBoxSeat);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReset = findViewById(R.id.buttonReset);
        btnReserve = findViewById(R.id.buttonReserve);
        tvOutput = findViewById(R.id.textViewOutput);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        dp.updateDate(2020,5,01);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smoking = "";
                if(cbSeat.isChecked()){
                    smoking = "Yes";
                }
                else{
                    smoking = "No";
                }
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                int Hour = tp.getCurrentHour();
                int Minute = tp.getCurrentMinute();
                String smallMinute;
                if(Minute < 10) {
                    smallMinute = "0" + Minute;
                }
                else {
                    smallMinute = ""+Minute;
                }

                String information = "Booking for "+etName.getText()+" for "+etPax.getText()+" Pax is Successful!\nMobile: "+etNum.getText()+"\nSmoking Area: "+smoking+"\nDate: "+day+"/"+month+"/"+year+"\nTime: "+Hour+":"+smallMinute;
                Toast.makeText(MainActivity.this, information, Toast.LENGTH_LONG).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);

                dp.updateDate(2020,0,01);
                etName.setText("");
                etNum.setText("");
                etPax.setText("");
                if(cbSeat.isChecked()){
                    cbSeat.toggle();
                }
                tvOutput.setText("");
            }
        });
    }
}