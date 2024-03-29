package za.co.jlweb.webtool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatePercentageActivity extends Activity {
	float parentWidth;
	float elementWidth;
	float percentage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate_percentage);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculate_percentage, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * When the Calculate Button is clicked
	 * @param view
	 */
	 public void calculatePercentage(View view) {
		 EditText parentWidthText = (EditText) findViewById(R.id.calcPercentageParentWidth);
		 EditText elementWidthText = (EditText) findViewById(R.id.calcPercentageElementWidth);
		 TextView calculateResult = (TextView) findViewById(R.id.calculatePercentageResult);
		 
		 
		 
		 if (parentWidthText.getText().length() == 0) {
			 Toast.makeText(this, "You need to provide a width for the parent element in pixels", Toast.LENGTH_LONG).show();
		 } else if (elementWidthText.getText().length() == 0) {
			 Toast.makeText(this, "You need to provide a width for the element in pixels", Toast.LENGTH_LONG).show();
		 } else {
			 
			 parentWidth = Float.parseFloat(parentWidthText.getText().toString());
			 elementWidth = Float.parseFloat(elementWidthText.getText().toString());
			 percentage = (elementWidth / parentWidth) * 100;
			 String result = Float.toString(percentage);
			 calculateResult.setText(result + "%");
			 Toast.makeText(this, result + "%", Toast.LENGTH_LONG).show();
		 }
		 
	 }

}
