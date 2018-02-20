import Interface.IChatRoom;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {

    private static Serveur INSTANCE = null;

    private Serveur() {
        run();
    }

    public static Serveur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Serveur();
        }
        return INSTANCE;
    }

    public void run() {
        try {
            IChatRoom chatRoom = (IChatRoom) UnicastRemoteObject.exportObject(new ChatRoom(), 4000);
            Registry registry = LocateRegistry.createRegistry(4000);
            registry.rebind("myServer", chatRoom);
            System.out.println("Serveur launch");

        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Serveur serveur = getInstance();

    }
}
