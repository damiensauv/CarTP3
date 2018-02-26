package Impl;

import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.time.LocalTime;

public class Message implements IMessage {

    private String msg;
    private IClient client;


    public Message(String msg, IClient client) {
        this.msg = msg;
        this.client = client;
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
        try {
            return "[" + client.getPseudo() + "(" + LocalTime.now() + ")] : " + msg;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "";
    }
}
