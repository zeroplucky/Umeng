package push;


import push.android.AndroidBroadcast;
import push.android.AndroidCustomizedcast;
import push.android.AndroidUnicast;


public class Upush {
    private String appkey = null;
    private String appMasterSecret = null;
    private String timestamp = null;
    private PushClient client = new PushClient();

    public Upush(String key, String secret) {
        try {
            appkey = key;
            appMasterSecret = secret;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /*
    * 广播(每天可推送10次)
    * */
    public void sendAndroidBroadcast(String title, String content) throws Exception {
        AndroidBroadcast broadcast = new AndroidBroadcast(appkey, appMasterSecret);
        broadcast.setOthers("com.mindaxx.ywapp.push.PushActivity");
        broadcast.setTicker("Android broadcast ticker");
        broadcast.setTitle(title);
        broadcast.setText(content);

        broadcast.setPlayLights(true);
        broadcast.setPlaySound(true);
        broadcast.setPlayVibrate(true);
        broadcast.goAppAfterOpen();
        broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        broadcast.setProductionMode();

        broadcast.setExpireTime(TimeUtil.getCurrentTime(6));
        client.send(broadcast);
    }

    /*
   * 按别名推送 (每小时可推送300次)
   * */
    public void sendAndroidCustomizedcast(String alias, String title, String content) throws Exception {
        AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(appkey, appMasterSecret);
        customizedcast.setAlias(alias, "app");
        customizedcast.setOthers("com.mindaxx.ywapp.push.PushActivity");
        customizedcast.setTicker("Android customizedcast ticker");
        customizedcast.setTitle(title);
        customizedcast.setText(content);

        customizedcast.setPlayLights(true);
        customizedcast.setPlaySound(true);
        customizedcast.setPlayVibrate(true);
        customizedcast.goAppAfterOpen();
        customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        customizedcast.setProductionMode();

        customizedcast.setExpireTime(TimeUtil.getCurrentTime(6));
        client.send(customizedcast);
    }

    /*
    * 按设备Token推送 (没有限制)
    * */
    public void sendAndroidUnicast(String deviceToken, String title, String content) throws Exception {
        AndroidUnicast unicast = new AndroidUnicast(appkey, appMasterSecret);
        unicast.setDeviceToken(deviceToken);
        unicast.setOthers("com.mindaxx.ywapp.push.PushActivity");
        unicast.setTicker("Android unicast ticker");
        unicast.setTitle(title);
        unicast.setText(content);

        unicast.setPlayLights(true);
        unicast.setPlaySound(true);
        unicast.setPlayVibrate(true);
        unicast.goAppAfterOpen();
        unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        unicast.setProductionMode();

        unicast.setExpireTime(TimeUtil.getCurrentTime(6));
        client.send(unicast);
    }

    public static void main(String[] args) {
        String appKey = "";
        String appMasterSecret = "";
        String deviceToken = "";
        String alias = "a123";
        String title = "中文的title";
        String content = "中文的content";
        try {
            Upush upush = new Upush(appKey, appMasterSecret);
            upush.sendAndroidBroadcast(title, content);
//            upush.sendAndroidCustomizedcast(alias, title, content);
//            upush.sendAndroidUnicast(deviceToken, title, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
