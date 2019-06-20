package push.android;

import push.AndroidNotification;

/**
 * 广播(broadcast)：向安装该App的所有设备发送消息
 */
public class AndroidBroadcast extends AndroidNotification {
    public AndroidBroadcast(String appkey, String appMasterSecret) throws Exception {
        setAppMasterSecret(appMasterSecret);
        setPredefinedKeyValue("appkey", appkey);
        this.setPredefinedKeyValue("type", "broadcast");
    }

    public void setOthers(String miActivity) throws Exception {
        setPredefinedKeyValue("mipush", true);
        setPredefinedKeyValue("mi_activity", miActivity);
        setPredefinedKeyValue("description", "1");
    }
}
