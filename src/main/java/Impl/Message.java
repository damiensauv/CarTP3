package Impl;

import Interface.IClient;
import Interface.IMessage;

import java.util.Date;

public class Message implements IMessage {

    private String msg;
    private IClient client;
    private Date date;

    public Message(String msg, IClient client) {
        this.msg = msg;
        this.client = client;
        this.date = new Date();
    }

    @Override
    public void setMessage(String message) {
        this.msg = message;
    }

    @Override
    public void setClient(IClient client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return "ToString => " + msg;
    }
}
