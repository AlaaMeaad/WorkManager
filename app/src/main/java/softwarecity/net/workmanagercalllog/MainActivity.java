package softwarecity.net.workmanagercalllog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.Settings;
import android.util.Log;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import retrofit2.Response;
import softwarecity.net.workmanagercalllog.remote.DataManagerImpl;
import softwarecity.net.workmanagercalllog.remote.RetrofitCallback;

public class MainActivity extends AppCompatActivity {
    static MainActivity mainActivity;
    public static StringBuffer sb;
    DataManagerImpl dataManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data data = new Data.Builder()
                .putInt("number" , 10)
                .build();
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_CALL_LOG)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_CALL_LOG} , 1);
            }else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_CALL_LOG}, 1);
            }
        }else  {
//                getCallDetails();
        }

    }


//
//    public String getCallDetails() {
//
//        sb = new StringBuffer();
//        String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
//
//        Date c = Calendar.getInstance().getTime();
//        DateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MMM-dd");
////        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd");
//        String formattedDate = simpleDateFormat.format(c);
//        Log.e("date" , "ssss" + formattedDate);
//        Date newDate = new Date(c.getTime() - 172800000); // 7 * 24 * 60 * 60 * 1000
//        Calendar calender = Calendar.getInstance();
//        calender.setTime(newDate);
//        String fromDate = String.valueOf(calender.getTimeInMillis());
//
//        calender.setTime(c);
//        String toDate = String.valueOf(calender.getTimeInMillis());
//
//        String[] whereValue = {fromDate,toDate};
//        Cursor managedCursor = managedQuery( CallLog.Calls.CONTENT_URI,null, android.provider.CallLog.Calls.DATE + " BETWEEN ? AND ?", whereValue, strOrder);
//        int number = managedCursor.getColumnIndex( CallLog.Calls.NUMBER );
//        int type = managedCursor.getColumnIndex( CallLog.Calls.TYPE );
//        int date = managedCursor.getColumnIndex( CallLog.Calls.DATE);
//        int duration = managedCursor.getColumnIndex( CallLog.Calls.DURATION);
////        sb.append( "Call Details :");
//        while ( managedCursor.moveToNext() ) {
//            String phNumber = managedCursor.getString( number );
//            String callType = managedCursor.getString( type );
//            String callDate = managedCursor.getString( date );
//            Date callDayTime = new Date(Long.valueOf(callDate));
//            String callDuration = managedCursor.getString( duration );
//            String dir = null;
//            int dircode = Integer.parseInt( callType );
//            switch( dircode ) {
//                case CallLog.Calls.OUTGOING_TYPE:
//                    dir = "OUTGOING";
//                    break;
//
//                case CallLog.Calls.INCOMING_TYPE:
//                    dir = "INCOMING";
//                    break;
//
//                case CallLog.Calls.MISSED_TYPE:
//                    dir = "MISSED";
//                    break;
//            }
//            String android_id = Settings.Secure.getString(this.getContentResolver(),
//                    Settings.Secure.ANDROID_ID);
//            sb.append( "{'Phone Number':'"+phNumber+"','Call Type':'"+dir+"','Call Date':'"+callDayTime+"','Phone ID':'"+ android_id+"','Call duration in sec':'"+callDuration+"},");
//
//            Log.e("hfhfhfhfasasasaf", android_id);
//        }
//        managedCursor.close();
//
//        return  sb.toString();
//    }
//    public String allFilds() {
//        getCallDetails();
//        String data =sb.toString() ;
//        Log.e("kiokio", "allFilds: "+data );
//        callLogs(data);
//        return data;
//    }
//
//    void callLogs(String data) {
//        dataManager = new DataManagerImpl();
//        dataManager.callLogs(new RetrofitCallback() {
//            @Override
//            public void onSuccess(Object response) {
//                CallLogs callLogs = (CallLogs) response;
//                if (callLogs.getStatus().equals("success")){
//                    Log.e("sassasasasasaas", "onSuccess: " );
//                }
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                Log.e("sasas", "ererro: " );
//            }
//
//            @Override
//            public void onErrorCode(Response<Object> response) {
//                Log.e("sasas", "sdsdsdsds: " );
//            }
//        },data);
//    }

}
