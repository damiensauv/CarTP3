import GUI.MyFrame;
import Impl.Client;
import Interface.IChatRoom;
import Interface.IClient;

import java.rmi.Naming;

public class ClientMain {

    public static void main(String[] args) throws Exception {
//        IClient client = new Client("damien", "test");


        new MyFrame();

        //IChatRoom chatRoom = (IChatRoom) Naming.lookup("rmi://localhost:4001/myServer");
        //chatRoom.register(client);

    }
}
