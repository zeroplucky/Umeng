package push;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/20.
 */
public class TimeUtil {


    /**
     * @param data 天数
     * @return
     */
    public static String getCurrentTime(int data) {
        long time = new Date().getTime() + 1000 * 60 * 60 * 24 * data;
        String date = timeStamp2Date(time + "", null);
        return date;
    }

    private static String timeStamp2Date(String millis, String format) {
        if (millis == null || millis.isEmpty() || millis.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(millis)));
    }
}
