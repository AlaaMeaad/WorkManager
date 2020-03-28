package softwarecity.net.workmanagercalllog;
import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class IncomingCallReceiver extends BroadcastReceiver {
    public static StringBuffer sb;
    Activity act;

    @Override
    public void onReceive(Context context, Intent intent) {

        ITelephony telephonyService;
        try {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)){
                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                try {
                    Method m = tm.getClass().getClass().getDeclaredMethod("getITelephony");

                    m.setAccessible(true);
                    telephonyService = (ITelephony) m.invoke(tm);

                    if ((number != null)) {
                        telephonyService.endCall();
                        Toast.makeText(context, "Ending the call from: " + number, Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(context, "Ring " + number, Toast.LENGTH_SHORT).show();

            }
            if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                Toast.makeText(context, "Answered " + number, Toast.LENGTH_SHORT).show();
//                getCallDetails();

            }
            if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)){
//                getCallDetails();
                Toast.makeText(context, "Idle "+ number , Toast.LENGTH_SHORT).show();
                Log.e( "zamalek ", "EGYPT"  );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public String getCallDetails() {
//
//        sb = new StringBuffer();
//        String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
//        Date c = Calendar.getInstance().getTime();
//        DateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MMM-dd");
////        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd");
//        String formattedDate = simpleDateFormat.format(c);
//        Log.e("date", "ssss" + formattedDate);
//        Date newDate = new Date(c.getTime() - 172800000); // 7 * 24 * 60 * 60 * 1000
//        Calendar calender = Calendar.getInstance();
//        calender.setTime(newDate);
//        String fromDate = String.valueOf(calender.getTimeInMillis());
//
//        calender.setTime(c);
//        String toDate = String.valueOf(calender.getTimeInMillis());
//
//        String[] whereValue = {fromDate, toDate};
//        Cursor managedCursor =  act.managedQuery(CallLog.Calls.CONTENT_URI, null, android.provider.CallLog.Calls.DATE + " BETWEEN ? AND ?", whereValue, strOrder);
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
//            String android_id = Settings.Secure.getString(act.getContentResolver(),
//                    Settings.Secure.ANDROID_ID);
//            sb.append( "{'Phone Number':'"+phNumber+"','Call Type':'"+dir+"','Call Date':'"+callDayTime+"','Phone ID':'"+ android_id+"','Call duration in sec':'"+callDuration+"},");
//
//            Log.e("hfhfhfhfasasasaf", android_id);
//        }
//        managedCursor.close();
//
//        return  sb.toString();
//    }
}