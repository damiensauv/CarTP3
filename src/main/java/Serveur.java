import Impl.ChatRoomImpl;
import Interface.IChatRoom;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Serveur {

    public static void main(String[] args) {
        try {

            IChatRoom chatRoom = new ChatRoomImpl();
            LocateRegistry.createRegistry(4001);
            LocateRegistry.getRegistry("127.0.0.1", 4001).rebind("myServer", chatRoom);

            System.out.println("Serveur launch");

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
