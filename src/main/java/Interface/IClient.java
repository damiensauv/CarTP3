package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {

    public void setPseudo(String pseudo) throws RemoteException;

    public String getPseudo() throws RemoteException;

    public void setPassword(String password) throws RemoteException;

    public String getPassword() throws RemoteException;



    public void receive(IMessage message) throws RemoteException;
}
