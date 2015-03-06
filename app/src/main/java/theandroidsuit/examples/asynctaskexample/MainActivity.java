package theandroidsuit.examples.asynctaskexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by The Android Suit on 6/03/15.
 */
public class MainActivity extends ActionBarActivity implements TaskChangeListener{

    private String taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskId = UUID.randomUUID().toString();
        ExampleAsyncTask eAT = new ExampleAsyncTask(taskId, this);
        eAT.execute();

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

    @Override
    public void onTaskCompleted(String id, Object result) {

        if (id.equals(taskId)){
            String message = (String) result;
            TextView tv = (TextView) findViewById(R.id.textViewMsg);
            tv.setText(message);
        }

    }
}
