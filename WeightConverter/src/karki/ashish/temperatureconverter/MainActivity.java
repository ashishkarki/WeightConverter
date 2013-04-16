package karki.ashish.temperatureconverter;

import karki.ashish.weightconverter.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	private EditText text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * 
	 * @param view
	 */
	public void onClick(View view) {
		if (view.getId() == R.id.button1) {
			RadioButton celsiusRadioButton = (RadioButton) findViewById(R.id.radioButton1);
			RadioButton fahrenheitRadioButton = (RadioButton) findViewById(R.id.radioButton2);

			double inputValue = Double.parseDouble(text.getText().toString());
			if (celsiusRadioButton.isChecked()) {
				text.setText(String.valueOf(kgsToPounds(inputValue)));
				celsiusRadioButton.setChecked(false);
				fahrenheitRadioButton.setChecked(true);
			} else {
				text.setText(String.valueOf(PoundsToKgs(inputValue)));
				fahrenheitRadioButton.setChecked(false);
				celsiusRadioButton.setChecked(true);
			}
		}
	}

	private double kgsToPounds(double kgs) {
		return (kgs * 2.2);
	}

	private double PoundsToKgs(double pounds) {
		return (pounds / 2.2);
	}
}
