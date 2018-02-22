import Interface.IChatRoom;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {

    public static void main(String[] args) {
        try {

            IChatRoom chatRoom = (IChatRoom) UnicastRemoteObject.exportObject(new ChatRoomImpl(), 4001);
            LocateRegistry.createRegistry(4001);
            LocateRegistry.getRegistry("127.0.0.1", 4001).rebind("myServer", chatRoom);

            System.out.println("Serveur launch");

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
