package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {

    public String getPseudo() throws RemoteException;

    public String getPassword() throws RemoteException;

    public void receive(IMessage message) throws RemoteException;
}
