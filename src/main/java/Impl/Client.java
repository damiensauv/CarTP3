package Impl;

import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Client extends UnicastRemoteObject implements IClient {

    private String pseudo;
    private String password;
    private Map<String, IClient> clients;

    public Client(String pseudo, String password) throws RemoteException {
        super();
        this.pseudo = pseudo;
        this.password = password;
        clients = new HashMap<>();
    }

    @Override
    public String getPseudo() throws RemoteException {
        return this.pseudo;
    }

    @Override
    public String getPassword() throws RemoteException {
        return this.password;
    }

    @Override
    public void receive(IMessage message) throws RemoteException {
        System.out.println(message);
    }

    public Map<String, IClient> getClients() throws RemoteException {
        return clients;
    }

    @Override
    public void addClient(IClient privateClient) throws RemoteException {
        this.clients.put(privateClient.getPseudo(), privateClient);
    }
}
