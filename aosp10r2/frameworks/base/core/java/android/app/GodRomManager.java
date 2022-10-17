package android.app;
// change godrom
import android.annotation.SystemService;
import android.content.Context;
import android.os.RemoteException;
import android.util.Slog;
@SystemService(Context.GODROM_SERVICE)
public class GodRomManager {
    Context mContext;
    IGodRom mService;

    public GodRomManager(Context context,IGodRom service){
        if(service==null){
            Slog.e("GodRomManager","Construct service is null");
        }
        mContext = context;
        mService = service;
    }

    public String shellExec(String cmd){
        if(mService != null){
            try{
                Slog.e("GodRomManager","shellExec");
                return mService.shellExec(cmd);
            }catch(RemoteException e){
                Slog.e("GodRomManager","RemoteException "+e);
            }
        }else{
            Slog.e("GodRomManager","mService is null");
        }
        return "";
    }

    public String readFile(String path){
        if(mService != null){
            try{
                Slog.e("GodRomManager","readFile");
                return mService.readFile(path);
            }catch(RemoteException e){
                Slog.e("GodRomManager","RemoteException "+e);
            }
        }else{
            Slog.e("GodRomManager","mService is null");
        }
        return "";
    }

    public void writeFile(String path,String data){
        if(mService != null){
            try{
                Slog.e("GodRomManager","writeFile");
                mService.writeFile(path,data);
            }catch(RemoteException e){
                Slog.e("GodRomManager","RemoteException "+e);
            }
        }else{
            Slog.e("GodRomManager","mService is null");
        }
    }

}
