package theandroidsuit.examples.asynctaskexample;

/**
 * Created by The Android Suit on 6/03/15.
 */
public class ExampleAsyncTask  extends AbstractAsyncTask<String, Integer, String>{

    public ExampleAsyncTask(String id, TaskChangeListener listener) {
        super(id, listener);
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            Thread.sleep(1000); //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        return "DONE!";
    }
}
