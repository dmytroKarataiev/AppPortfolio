package karataiev.dmytro.myappportfolio;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adds red color filter to the button
        Button capstone = (Button) findViewById(R.id.capstone1);
        Button capstone2 = (Button) findViewById(R.id.capstone2);

        capstone.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
        capstone2.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void blankActivity(View view) {
        // Toast shows text on the pressed button
        String textOnButton = ((Button) view).getText().toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, textOnButton, duration);
        toast.show();
    }
}
