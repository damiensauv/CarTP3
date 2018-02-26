import Impl.Message;
import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) throws Exception {

        IChatRoom chatRoom = (IChatRoom) Naming.lookup("rmi://localhost:4001/myServer");
//        new MyFrame(chatRoom);

        System.out.println("client launch, Enter login/password to connect(if you are not register , you will add auto)");
        System.out.println("Write #EXIT for close");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pseudo :");
        String pseudo = scanner.nextLine();
        System.out.println("Password :");
        String password = scanner.nextLine();
        IClient client = chatRoom.connect(pseudo, password);
        if (client == null) {
            System.out.println("Already connected Or Wrong password");
        }

        IMessage msg = null;
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.contentEquals("#EXIT")) {
                chatRoom.disconnect(client);
                break;
            } else {
                msg = new Message(line, client);
                chatRoom.send(msg);
            }
        }
        scanner.close();

    }
}
