import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class Client implements IClient {

    private String pseudo;
    private String password;
    private boolean connected;

    @Override
    public void setPseudo(String pseudo) {

    }

    @Override
    public String getPseudo() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void setConnected(boolean connected) {

    }

    @Override
    public void receive(IMessage message) throws RemoteException {

    }

    public static void main(String[] args) throws Exception {
        IClient client = new Client();
        client.setPseudo("dam");

        IChatRoom chatRoom = (IChatRoom) Naming.lookup("myServer");
        chatRoom.register(new Client());

    }

}
