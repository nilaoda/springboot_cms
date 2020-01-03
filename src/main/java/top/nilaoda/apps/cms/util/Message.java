package top.nilaoda.apps.cms.util;

/**
* @author nilaoda
* @version 1.0
* @description 消息
* @date 2019/12/20
* @time 9:31
*/

public class Message {
    private Integer status;
    private String message;
    private Object data;
    private Long timestamp;

    public Message() {
    }

    public Message(Integer status, String message, Object data, Long timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
