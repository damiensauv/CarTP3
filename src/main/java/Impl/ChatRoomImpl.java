package Impl;

import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ChatRoomImpl extends UnicastRemoteObject implements IChatRoom {

    Map<String, String> registerClients = null;
    Map<String, IClient> connectedClients = null;

    public ChatRoomImpl() throws RemoteException {
        super();
        registerClients = new HashMap<>();
        connectedClients = new HashMap<>();
    }

    @Override
    public void register(String text, String password) throws RemoteException {
        registerClients.put(text, password);
    }

    @Override
    public void send(IMessage message) throws RemoteException {

        for (Map.Entry<String, IClient> entry : connectedClients.entrySet()) {
            entry.getValue().receive(message);
        }
    }

    @Override
    public IClient connect(String pseudo, String pswd) throws RemoteException {
        if (!registerClients.containsKey(pseudo)) {
            this.register(pseudo, pswd);
        } else {
            if (!(registerClients.containsKey(pseudo) && registerClients.get(pseudo).contentEquals(pswd))) {
                return null;//password wrong
            }
        }

        IClient client = new Client(pseudo, pswd);
        if (!connectedClients.containsKey(pseudo)) {
            connectedClients.put(pseudo, client);
            IMessage message = new Message("[Info] : " + pseudo + " join the chat", client);
            this.send(message);
            return client;
        } else {
            return null; // already connected
        }
    }

    @Override
    public void disconnect(IClient client) throws RemoteException {

    }
}
