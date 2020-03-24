package softwarecity.net.workmanagercalllog.api;



import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import softwarecity.net.workmanagercalllog.CallLogs;

public interface ApiServers {
    @POST("management_reports/calls/import")
    @FormUrlEncoded
    Call<CallLogs> callLogs(@Field("data") String data);



}


