package Impl;

import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements IClient {

    private String pseudo;
    private String password;


    public Client(String pseudo, String password) throws RemoteException {
        super();
        this.pseudo = pseudo;
        this.password = password;
    }

    @Override
    public void setPseudo(String pseudo) throws RemoteException {

    }

    @Override
    public String getPseudo() throws RemoteException {
        return this.pseudo;
    }

    @Override
    public void setPassword(String password) throws RemoteException {

    }

    @Override
    public String getPassword() throws RemoteException {
        return null;
    }


    @Override
    public void receive(IMessage message) throws RemoteException {
        System.out.println("Message Yolo");
    }

}
