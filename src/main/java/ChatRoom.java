import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements IChatRoom {

    public List<IClient> clients = null;

    public ChatRoom() {
        clients = new ArrayList<>();
     }

    public void register(IClient client) throws RemoteException {
        System.out.println("Client Register");
    }

    @Override
    public void send(IMessage message) throws RemoteException {

    }

    @Override
    public void disconnect(IClient client) throws RemoteException {

    }
}
