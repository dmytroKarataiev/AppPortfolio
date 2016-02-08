package karataiev.dmytro.myappportfolio;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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

        Button popMovies = (Button) findViewById(R.id.popMovie);
        popMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp(getApplicationContext(), "karataiev.dmytro.popularmovies");
            }
        });

        Button alexandria = (Button) findViewById(R.id.alexandria);
        alexandria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp(getApplicationContext(), "it.jaschke.alexandria");
            }
        });

        Button football_scores = (Button) findViewById(R.id.football_scores);
        football_scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApp(getApplicationContext(), "barqsoft.footballscores");
            }
        });


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

    /**
     * Method to show name of the button on the screen
     * @param view to present the Toast on
     */
    public void blankActivity(View view) {
        // Toast shows text on the pressed button
        String textOnButton = ((Button) view).getText().toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, textOnButton, duration);
        toast.show();
    }

    /** Open another app intent
     * @param context current Context, like Activity, App, or Service
     * @param packageName the full package name of the app to open
     * @return true if likely successful, false if unsuccessful
     */
    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();

        Intent i = manager.getLaunchIntentForPackage(packageName);
        if (i == null) {
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, packageName, duration);
            toast.show();

            return false;
        }
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        context.startActivity(i);
        return true;

    }
}
