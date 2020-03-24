package softwarecity.net.workmanagercalllog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data data = new Data.Builder()
                .putInt("number" , 10)
                .build();
        Constraints constraints =new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true)
                .setRequiresDeviceIdle(true)
                .build();

//        PeriodicWorkRequest periodicWorkRequest =
//                new PeriodicWorkRequest.Builder(WorkMang.class, 15, TimeUnit.MINUTES)
//
//                .setInputData(data)
////                .setConstraints(constraints)
////                .setInitialDelay(15 , TimeUnit.MINUTES)
//                .addTag("MY_WORK")
//                .build();
//
//        WorkManager.getInstance().enqueue(periodicWorkRequest);

    }
}
