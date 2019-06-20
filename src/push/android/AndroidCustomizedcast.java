package push.android;


import push.AndroidNotification;

/*
* 自定义播(customizedcast)：开发者通过自有的alias进行推送
* */
public class AndroidCustomizedcast extends AndroidNotification {
    public AndroidCustomizedcast(String appkey, String appMasterSecret) throws Exception {
        setAppMasterSecret(appMasterSecret);
        setPredefinedKeyValue("appkey", appkey);
        this.setPredefinedKeyValue("type", "customizedcast");
    }

    public void setAlias(String alias, String aliasType) throws Exception {
        setPredefinedKeyValue("alias", alias);
        setPredefinedKeyValue("alias_type", aliasType);
    }

    public void setOthers(String miActivity) throws Exception {
        setPredefinedKeyValue("mipush", true);
        setPredefinedKeyValue("mi_activity", miActivity);
        setPredefinedKeyValue("description", "1");
    }


    public void setFileId(String fileId, String aliasType) throws Exception {
        setPredefinedKeyValue("file_id", fileId);
        setPredefinedKeyValue("alias_type", aliasType);
    }

}
