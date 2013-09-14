package my.program.resumeemulator;

import java.util.Calendar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;

public class ResumeActivity extends Activity {

	private Button buttonDate, buttonSend;
	private TextView textDate;
	private Spinner spinnerGender;
	private EditText editFIO, editPost, editSalary, editPhone, editEmail;
	private int Year;
	private int Month;
	private int Day;

	static final int DATE_DIALOG_ID = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resume);
		
		buttonDate = (Button) findViewById(R.id.buttonDate);
		buttonSend = (Button) findViewById(R.id.buttonSend);
		textDate = (TextView) findViewById(R.id.textDate);
		spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
		editFIO = (EditText) findViewById(R.id.editFIO);
		editPost = (EditText) findViewById(R.id.editPost);
		editSalary = (EditText) findViewById(R.id.editSalary);
		editPhone = (EditText) findViewById(R.id.editPhone);
		editEmail = (EditText) findViewById(R.id.editEmail);
		
		Calendar c = Calendar.getInstance();
		Year = c.get(Calendar.YEAR);
	    Month = c.get(Calendar.MONTH);
		Day = c.get(Calendar.DAY_OF_MONTH);

		buttonDate.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		        showDialog(DATE_DIALOG_ID);
		    }
	    });
		buttonSend.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ResumeActivity.this, AnswerActivity.class);
				intent.putExtra("Resume", editFIO.getText().toString()+"\n"
						              + textDate.getText().toString()+"\n"
						              + spinnerGender.getSelectedItem().toString()+"\n"
						              + editPost.getText().toString()+"\n"
						              + editSalary.getText().toString()+"\n"
						              + editPhone.getText().toString()+"\n"
						              + editEmail.getText().toString());
			    startActivity(intent);
			}
		});
		updateDisplay();		
	}
	private void updateDisplay() {
	    textDate.setText(
	        new StringBuilder()
	                .append(Day).append(".")
	                .append(Month+1).append(".")
	                .append(Year));
	}
	private DatePickerDialog.OnDateSetListener DateSetListener = 
			new DatePickerDialog.OnDateSetListener() {
	            public void onDateSet(DatePicker view, int year, 
	                    int monthOfYear, int dayOfMonth) {
	                Year = year;
	                Month = monthOfYear;
	                Day = dayOfMonth;
	                updateDisplay();
	            }	            
	        };
	protected Dialog onCreateDialog(int id) {	            
	        return new DatePickerDialog(this, DateSetListener, Year, Month, Day);     
	        }

}
