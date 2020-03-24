package softwarecity.net.workmanagercalllog;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import softwarecity.net.workmanagercalllog.remote.DataManagerImpl;

public class WorkMang extends Worker {

private static final String TAG ="WorkMang";
    private DataManagerImpl dataManager;


    public WorkMang(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e("done", "doWork: number ");
        MainActivity.mainActivity.allFilds();
        Toast.makeText(getApplicationContext() , "done" , Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Result.success();
    }




}
