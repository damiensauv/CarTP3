package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChatRoom extends Remote {

    public void register(String text, String password) throws RemoteException;

    public void send(IMessage message) throws RemoteException;

    public void disconnect(IClient client) throws RemoteException;

    public boolean connect(IClient client) throws RemoteException;

    public void history(IClient client, Integer nb) throws RemoteException;

    public IClient getPrivateClient(String pseudo) throws RemoteException;

    public List<String> getClient() throws RemoteException;
}
