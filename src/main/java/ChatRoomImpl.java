import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomImpl implements IChatRoom {

    public List<IClient> clients = null;

    public ChatRoomImpl() {
        clients = new ArrayList<>();
     }

    public void register(IClient client) throws RemoteException {
        System.out.println("Client Register : ");
        System.out.println(client.getPseudo());
    }

    @Override
    public void send(IMessage message) throws RemoteException {

    }

    @Override
    public void disconnect(IClient client) throws RemoteException {

    }
}
