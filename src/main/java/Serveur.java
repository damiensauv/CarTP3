import Interface.IChatRoom;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {

    public static void main(String[] args) {
        try {
            IChatRoom chatRoom = (IChatRoom) UnicastRemoteObject.exportObject(new ChatRoom(), 4000);
            LocateRegistry.createRegistry(4000);
            LocateRegistry.getRegistry().bind("myServer", chatRoom);

            System.out.println("Serveur launch");

        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
