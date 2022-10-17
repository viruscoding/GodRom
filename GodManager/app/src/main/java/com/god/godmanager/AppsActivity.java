package com.god.godmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.god.godmanager.Common.AppInfo;
import com.god.godmanager.Common.AppInfosAdapter;
import com.god.godmanager.Common.ConfigUtil;

import java.util.ArrayList;
import java.util.List;

public class AppsActivity extends Activity {
    ListView appInfoListView = null;
    List<AppInfo> appInfos = null;
    AppInfosAdapter infosAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);
        appInfoListView = (ListView)this.findViewById(R.id.appinfo_list);
        appInfos = getAppInfos();
        updateUI(appInfos);
        appInfoListView.setOnItemClickListener(new MyOnItemClickListener());
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AppInfo item =  (AppInfo) parent.getItemAtPosition(position);
            Intent intent = getIntent();
            Bundle bundle = new Bundle();
            bundle.putParcelable("appData", item);
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    public void updateUI(List<AppInfo> appInfos){
        if(null != appInfos){
            infosAdapter = new AppInfosAdapter(getApplication(), appInfos);

            appInfoListView.setAdapter(infosAdapter);
        }
    }

    // 获取包名信息
    public List<AppInfo> getAppInfos(){
        PackageManager pm = getApplication().getPackageManager();
        List<PackageInfo>  packgeInfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        appInfos = new ArrayList<AppInfo>();
        for(PackageInfo packgeInfo : packgeInfos){
            //如果设置隐藏系统相关应用，就忽略掉系统的应用
            if(ConfigUtil.sysHide){
                if((packgeInfo.applicationInfo.flags& ApplicationInfo.FLAG_SYSTEM)!=0){
                    continue;
                }
            }
            //忽略掉自身应用
            if(packgeInfo.packageName.equals(this.getApplicationContext().getPackageName())){
                continue;
            }
            String appName = packgeInfo.applicationInfo.loadLabel(pm).toString();
            String packageName = packgeInfo.packageName;
            Drawable drawable = packgeInfo.applicationInfo.loadIcon(pm);
            AppInfo appInfo = new AppInfo(appName, packageName,drawable);
            appInfos.add(appInfo);
        }
        return appInfos;
    }


}
