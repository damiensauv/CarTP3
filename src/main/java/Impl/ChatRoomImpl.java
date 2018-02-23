package Impl;

import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomImpl extends UnicastRemoteObject implements IChatRoom {

    public List<IClient> clients = null;

    public ChatRoomImpl() throws RemoteException {
        super();
        clients = new ArrayList<IClient>();
    }

    public void register(IClient client) throws RemoteException {
        System.out.println("Impl.Client Register : ");
        System.out.println(client.getPseudo());
    }

    @Override
    public void send(IMessage message) throws RemoteException {

    }

    @Override
    public void disconnect(IClient client) throws RemoteException {

    }
}
