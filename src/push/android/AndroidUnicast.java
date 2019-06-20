package push.android;

import push.AndroidNotification;

/*
* 单播(unicast)：向指定的设备发送消息
* */
public class AndroidUnicast extends AndroidNotification {
    public AndroidUnicast(String appkey, String appMasterSecret) throws Exception {
        setAppMasterSecret(appMasterSecret);
        setPredefinedKeyValue("appkey", appkey);
        this.setPredefinedKeyValue("type", "unicast");
    }

    public void setDeviceToken(String token) throws Exception {
        setPredefinedKeyValue("device_tokens", token);
    }


    public void setOthers(String miActivity) throws Exception {
        setPredefinedKeyValue("mipush", true);
        setPredefinedKeyValue("mi_activity", miActivity);
        setPredefinedKeyValue("description", "1");
    }

}