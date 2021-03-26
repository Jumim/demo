package com.chan.demo.vo;

public class chatVO {
    private String chatRoomId;
    private String writer;
    private String message;
    private MessageType type;

    public enum MessageType {
        ENTER,CHAT,LEAVE
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public String getMessage() {
        return message;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
