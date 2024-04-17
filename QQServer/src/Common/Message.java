package Common;//时间：2023/9/17 15:34

import java.io.Serializable;

//信息对象
public class Message implements Serializable /*以对象的形式进行传输要进行序列化*/ {
    private static final long serialVersionUID = 1L;
    private String Sender;//消息发送者
    private String Receiver;//消息接收者
    private String SendTime;//消息发送时间
    private String MesType;//消息发送类型
    private String content;//消息内容

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String receiver) {
        Receiver = receiver;
    }

    public String getSendTime() {
        return SendTime;
    }

    public void setSendTime(String sendTime) {
        SendTime = sendTime;
    }

    public String getMesType() {
        return MesType;
    }

    public void setMesType(String mesType) {
        MesType = mesType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
