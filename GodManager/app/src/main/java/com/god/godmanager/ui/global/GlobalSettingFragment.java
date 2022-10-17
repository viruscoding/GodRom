package com.god.godmanager.ui.global;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.god.godmanager.Common.ConfigUtil;
import com.god.godmanager.Common.FileHelper;
import com.god.godmanager.Common.ServiceUtils;
import com.god.godmanager.databinding.FragmentGlobalSettingBinding;

public class GlobalSettingFragment extends Fragment {

    private GlobalSettingViewModel globalSettingViewModel;
    private FragmentGlobalSettingBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        globalSettingViewModel =
                new ViewModelProvider(this).get(GlobalSettingViewModel.class);

        binding = FragmentGlobalSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initUi();
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfigUtil.sysHide=binding.swSysHide.isChecked();
                try {
                    ServiceUtils.getiGodRom().writeFile("/data/system/break.conf",binding.txtBreakClass.getText().toString());
                    if(binding.rdoFrida14.isChecked()){
                        ServiceUtils.getiGodRom().writeFile("/data/system/fver14.conf","1");
                    }else{
                        ServiceUtils.getiGodRom().writeFile("/data/system/fver14.conf","0");
                    }
                    String res=ServiceUtils.getiGodRom().readFile("/data/system/fver14.conf");
                    Log.i(ConfigUtil.TAG,"fver14.conf data:"+res);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(binding.getRoot().getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String sysHide=binding.swSysHide.isChecked()?"1":"0";
                editor.putString("sysHide", sysHide);
                editor.apply();

                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("提示");
                builder.setMessage("保存成功");
                builder.show();
            }
        });
        return root;
    }

    public void initUi(){
        String res="";
        String fver="";
        try {
            res=ServiceUtils.getiGodRom().readFile(ConfigUtil.breakConfigPath);
            fver=ServiceUtils.getiGodRom().readFile("/data/system/fver14.conf");
        } catch (RemoteException e) {
            Log.e(ConfigUtil.TAG,e.getMessage());
        }
        if(res!=null&&res.length()>0){
            binding.txtBreakClass.setText(res);
        }
        if(fver.contains("1")){
            binding.rdoFrida14.setChecked(true);
        }
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(binding.getRoot().getContext());
        String sysHide = sharedPreferences.getString("sysHide", "");
        if(sysHide.equals("0")){
            binding.swSysHide.setChecked(false);
        }else{
            binding.swSysHide.setChecked(true);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}