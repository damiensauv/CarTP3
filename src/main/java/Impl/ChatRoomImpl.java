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
    Map<String, String> connectedClients = null;

    public ChatRoomImpl() throws RemoteException {
        super();
        registerClients = new HashMap<>();
        connectedClients = new HashMap<>();
    }

    public void register(IClient client) throws RemoteException {
        registerClients.put(client.getPseudo(), client.getPassword());
    }

    @Override
    public void send(IMessage message) throws RemoteException {

    }

    @Override
    public void connect(IClient client) throws RemoteException {

        // check si il existe pas deja ou n'ets pas deja co
        // si login non existant le crée
        // si existant check le mot de passe
        String pseudo = client.getPseudo();
        String pswd = client.getPassword();

        if (!connectedClients.containsKey(pseudo)) {
            // non connecter
            if (!registerClients.containsKey(pseudo)) {
                // crée
                this.register(client);
            }

            // si il est ici c'est qu'il existe du coup le Co la

            connectedClients.put()
            // prevenir tout le monde quil est co
            // crée un Message pour

        }


    }

    @Override
    public void disconnect(IClient client) throws RemoteException {

    }
}
