import Impl.Client;
import Impl.Message;
import Interface.IChatRoom;
import Interface.IClient;
import Interface.IMessage;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) throws Exception {

        IChatRoom chatRoom = (IChatRoom) Naming.lookup("rmi://localhost:4001/myServer");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("client launch, Enter login/password to connect(if you are not register , you will add auto)");
            System.out.println("Write #EXIT for Disconnect");
            System.out.println("Pseudo :");
            String pseudo = scanner.nextLine();
            System.out.println("Password :");
            String password = scanner.nextLine();

            IClient client = new Client(pseudo, password);
            boolean ret = chatRoom.connect(client);
            if (!ret) {
                System.out.println("Already connected Or Wrong password");
                System.exit(0);
            }

            System.out.println("You are connect");
            System.out.println("-----------------");
            IMessage msg = null;
            String line;
            boolean co = true;
            while (co) {
                line = scanner.nextLine();
                if (line.contentEquals("#EXIT")) {
                    chatRoom.disconnect(client);
                    co = false;
                } else {
                    msg = new Message(line, client);
                    chatRoom.send(msg);
                }
            }
        }
    }
}
