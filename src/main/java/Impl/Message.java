package Impl;

import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.time.LocalTime;

public class Message implements IMessage {

    private String msg;
    private IClient client;
    private String time;

    public Message(String msg, IClient client) {
        this.msg = msg;
        this.client = client;
        this.time = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond();
    }

    @Override
    public void setMessage(String message) {
        this.msg = message;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    @Override
    public void setClient(IClient client) {
        this.client = client;
    }

    @Override
    public IClient getClient() {
        return this.client;
    }

    @Override
    public String toString() {
        try {
            return "[" + client.getPseudo() + "(" + this.time + ")] : " + msg;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "";
    }
}
