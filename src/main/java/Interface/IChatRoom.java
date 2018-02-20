package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatRoom extends Remote {

    public void register(IClient client) throws RemoteException;

    public void send(IMessage message) throws RemoteException;

    public void disconnect(IClient client) throws RemoteException;

}
