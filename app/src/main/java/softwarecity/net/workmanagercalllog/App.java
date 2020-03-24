package softwarecity.net.workmanagercalllog;

import android.app.Application;

import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PeriodicWorkRequest periodicWorkRequest =
                new PeriodicWorkRequest.Builder(WorkMang.class, 15, TimeUnit.MINUTES)
                .build();
        WorkManager.getInstance(this)
                .enqueueUniquePeriodicWork("work" , ExistingPeriodicWorkPolicy.KEEP,periodicWorkRequest);

    }
}
