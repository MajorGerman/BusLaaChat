package busjaachat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
        private Socket sin;
        private PrintWriter prin;
        private Scanner scan= new Scanner(System.in);
        
        public Client() throws IOException {
            System.out.print("Client Port: ");
            int port = scan.nextInt();
            while(true) {
                try {
                    sin = new Socket("localhost", port);
                    break;
                } catch(Exception e) {
                }
            }
            prin = new PrintWriter(sin.getOutputStream());
             
        }
        
        @Override
        public void run() {
            String strin;

            while(true) {
                strin = scan.nextLine();
                prin.println(strin);
                prin.flush();

        }
    }
}
