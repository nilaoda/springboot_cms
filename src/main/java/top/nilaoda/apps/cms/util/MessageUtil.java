package top.nilaoda.apps.cms.util;

import java.util.Date;

public class MessageUtil {
    //适用于查询
    public static Message success(Object data) {
        return new Message(200, "success", data, new Date().getTime());
    }

    //适用于更新
    public static Message success(String message) {
        return new Message(200, message, null, new Date().getTime());
    }

    public static Message error(String message) {
        return new Message(500, message, null, new Date().getTime());
    }

    public static Message message(int status, String message, Object data) {
        return new Message(status, "error", data, new Date().getTime());
    }
}
