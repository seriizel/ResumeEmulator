package my.program.resumeemulator;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class AnswerActivity extends Activity {
	
	private TextView textResume;
	private Button buttonAnswer;
	private EditText editLetter;
	private AlertDialog.Builder dialogAnswer;
	private Context context;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer);
		
		textResume = (TextView) findViewById(R.id.textResume);
		buttonAnswer = (Button) findViewById(R.id.buttonAnswer);
		editLetter = (EditText) findViewById(R.id.editLetter);
		context = AnswerActivity.this;
		String title = "Ответ работодателя";
		String buttonString = "Закрыть";
		
		
		textResume.setText(getIntent().getExtras().getString("Resume"));		
		dialogAnswer = new AlertDialog.Builder(context);
		dialogAnswer.setTitle(title);			
		dialogAnswer.setPositiveButton(buttonString, new OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.cancel();
                Intent intent = new Intent(AnswerActivity.this, ResumeActivity.class);
				startActivity(intent);
            }
        });
		
		buttonAnswer.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				dialogAnswer.setMessage(editLetter.getText().toString());				
				dialogAnswer.show();
			}
		});
	}
	
}
