package softwarecity.net.workmanagercalllog;

import android.app.Application;
import android.content.Context;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        setWorkManager();
    }

    private void setWorkManager() {
        Constraints mConstraints =new Constraints.Builder()
//                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .setRequiresCharging(true)
//                .setRequiresDeviceIdle(true)
                .build();

        PeriodicWorkRequest periodicWorkRequest =
                new PeriodicWorkRequest.Builder(WorkMang.class, 1, TimeUnit.HOURS)
//                        .setConstraints(mConstraints)
                        .build();

//        WorkManager.getInstance(this)
//                .enqueueUniquePeriodicWork("work" , ExistingPeriodicWorkPolicy.KEEP,periodicWorkRequest);
        WorkManager.getInstance(this).enqueue(periodicWorkRequest);

    }

}
