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
import android.util.Log;

import java.util.concurrent.TimeUnit;

import retrofit2.Response;
import softwarecity.net.workmanagercalllog.remote.DataManagerImpl;
import softwarecity.net.workmanagercalllog.remote.RetrofitCallback;

public class MainActivity extends AppCompatActivity {
    DataManagerImpl dataManager;
    static MainActivity mainActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity=this;
        dataManager = new DataManagerImpl();
        Data data = new Data.Builder()
                .putInt("number" , 10)
                .build();
        Constraints constraints =new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .setRequiresCharging(true)
//                .setRequiresDeviceIdle(true)
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

    public String allFilds() {

        String data = "alaaa";
        Log.e("kiokio", "allFilds: "+data );
        callLogs(data);
        return data;
    }

    void callLogs(String data) {

        dataManager.callLogs(new RetrofitCallback() {
            @Override
            public void onSuccess(Object response) {
                CallLogs callLogs = (CallLogs) response;
                if (callLogs.getStatus().equals("success")){
                    Log.e("sassasasasasaas", "onSuccess: " );
                }
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e("sasas", "ererro: " );

            }

            @Override
            public void onErrorCode(Response<Object> response) {
                Log.e("sasas", "sdsdsdsds: " );

            }
        },data);
    }
}
