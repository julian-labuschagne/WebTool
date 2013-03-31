package za.co.jlweb.webtool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /**
     * When the button to convert to Em is clicked
     */
    public void launchConvertToEmActivity(View view) {
    	Intent launchEmConverter = new Intent(this, ConvertToEmActivity.class);
    	startActivity(launchEmConverter);
    }
    
    /**
     * When the button to Calculate Percentage is clicked
     */
    public void launchCalculatePercentageActivity(View view) {
    	Intent launchCalculatePercentage = new Intent(this, CalculatePercentageActivity.class);
    	startActivity(launchCalculatePercentage);
    }
    
}
