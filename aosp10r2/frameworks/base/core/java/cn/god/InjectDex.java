package cn.god;
// change godrom
import android.util.Log;

public class InjectDex implements IGodDex {
    private String TAG="godrom";
    @Override
    public void onStart(String path) {
        Log.e(TAG,"InjectDex.onStart");
    }
}
