package lk.ijse.cmjd108.Lost_and_Found.util;

import java.sql.Date;

public class DateUtil {
    public static Date now() {
        return new Date(System.currentTimeMillis());
    }

    public static Date fromNow(long milliseconds) {
        return new Date(System.currentTimeMillis() + milliseconds);
    }
}
