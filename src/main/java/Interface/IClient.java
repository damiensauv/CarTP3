package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IClient extends Remote {

    public String getPseudo() throws RemoteException;

    public String getPassword() throws RemoteException;

    public void receive(IMessage message) throws RemoteException;

    public Map<String, IClient> getClients() throws RemoteException;

    public void addClient(IClient privateClient) throws RemoteException;
}
