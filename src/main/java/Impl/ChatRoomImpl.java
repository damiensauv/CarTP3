package Impl;

import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRoomImpl extends UnicastRemoteObject implements IChatRoom {

    Map<String, String> registerClients = null;
    Map<String, IClient> connectedClients = null;
    IClient serverClient = null;
    List<IMessage> allmsg;

    public ChatRoomImpl() throws RemoteException {
        super();
        registerClients = new HashMap<>();
        connectedClients = new HashMap<>();
        serverClient = new Client("Server", "Server");
        allmsg = new ArrayList<>();
    }

    @Override
    public void register(String text, String password) throws RemoteException {
        registerClients.put(text, password);
    }

    @Override
    public void send(IMessage message) throws RemoteException {

        String msg = message.getMessage();
        String[] splitStr = msg.split("\\s+");
        if (splitStr[0].contentEquals("#h")) {
            Integer n = 0;
            try {
                n = Integer.valueOf(splitStr[1]);
            } catch (Exception e) {
                n = 0;
            }
            this.history(message.getClient(), n);
        } else {
            allmsg.add(message);
            for (Map.Entry<String, IClient> entry : connectedClients.entrySet()) {
                entry.getValue().receive(message);
            }
        }
    }

    @Override
    public boolean connect(IClient client) throws RemoteException {
        String pseudo = client.getPseudo();
        String pswd = client.getPassword();

        if (!registerClients.containsKey(pseudo)) {
            this.register(pseudo, pswd);
        } else {
            if (!(registerClients.containsKey(pseudo) && registerClients.get(pseudo).contentEquals(pswd))) {
                return false;//password wrong
            }
        }

        if (!connectedClients.containsKey(pseudo)) {
            connectedClients.put(pseudo, client);
            IMessage message = new Message("[Info] : " + pseudo + " join the chat", client);
            this.send(message);
            return true;
        } else {
            return false; // already connected
        }
    }

    @Override
    public void history(IClient client, Integer nb) throws RemoteException {
        Integer s;
        Integer size = allmsg.size();
        if ((size - nb) < 0)
            s = 0;
        else
            s = size - nb;

        List<IMessage> tmp = allmsg.subList(s, size);
        for (IMessage msg : tmp) {
            client.receive(msg);
        }
    }

    @Override
    public IClient getPrivateClient(String pseudo) throws RemoteException {
        return connectedClients.get(pseudo);
    }

    @Override
    public List<String> getClient() throws RemoteException {
        List<String> ret = new ArrayList<>();
        for (Map.Entry<String, IClient> entry : connectedClients.entrySet()) {
            ret.add(entry.getKey());
        }
        return ret;
    }

    @Override
    public void disconnect(IClient client) throws RemoteException {
        connectedClients.remove(client.getPseudo());
        IMessage message = new Message("[Info] : " + client.getPseudo() + " has left", serverClient);
        this.send(message);
    }
}
