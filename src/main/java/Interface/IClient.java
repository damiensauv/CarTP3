package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {

    public void setPseudo(String pseudo);

    public String getPseudo();

    public void setPassword(String password);

    public String getPassword();

    public boolean isConnected();

    public void setConnected(boolean connected);

    public void receive(IMessage message) throws RemoteException;
}
