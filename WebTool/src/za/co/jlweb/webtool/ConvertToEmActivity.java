package za.co.jlweb.webtool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertToEmActivity extends Activity {
	float sizeInPx;
	float sizeInEm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convert_to_em);
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
		getMenuInflater().inflate(R.menu.convert_to_em, menu);
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
	 * When the Convert Button is clicked
	 * @param view
	 */
	public void convertPxToEm(View view) {
		EditText fontSize = (EditText) findViewById(R.id.fontSize);
		TextView textConvertToEmResult = (TextView) findViewById(R.id.text_convert_em_result);
		if (fontSize.getText().length() == 0) {
			Toast.makeText(this, "You need to provide a font size in pixels", Toast.LENGTH_LONG).show();
		} else {
			sizeInPx = Float.parseFloat(fontSize.getText().toString());
			sizeInEm = sizeInPx / 16;
			String result = Float.toString(sizeInEm);
			textConvertToEmResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeInPx);
			textConvertToEmResult.setText(result + "em");
			Toast.makeText(this, result + "em", Toast.LENGTH_LONG).show();
		}
	}

}
