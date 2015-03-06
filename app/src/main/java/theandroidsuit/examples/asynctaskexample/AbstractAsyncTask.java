package theandroidsuit.examples.asynctaskexample;

import android.os.AsyncTask;

/**
 * Created by The Android Suit on 6/03/15.
 */
public abstract class AbstractAsyncTask <Params, Progress, Result> extends AsyncTask<Params, Progress, Result>{

    private TaskChangeListener callback;
    private String uniqueID;


    public AbstractAsyncTask(String id, TaskChangeListener callback) {
        this.callback = callback;
        this.uniqueID = id;
    }

    @Override
    protected void onPostExecute(Result result) {
        // CallBack to Activity (UI Thread)
        callback.onTaskCompleted(this.uniqueID, result);
    }

    protected TaskChangeListener getListener() {
        return callback;
    }
}
