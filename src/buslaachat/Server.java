package buslaachat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader in;
    private BufferedReader bf;
    private Scanner scan = new Scanner(System.in);
    
    public Server() throws IOException{
        System.out.print("Server Port: ");
        int port = scan.nextInt();
        ss = new ServerSocket(port);
        
    }
    
    @Override
    public void run() {
        try {
            System.out.println("\nClient Connected!\n");
            String str;
            s = ss.accept();
            in = new InputStreamReader(s.getInputStream());
            bf = new BufferedReader(in);
            
            while(true) {
                try{
                    str = bf.readLine();
                } catch(Exception e){
                    break;
                }
                System.out.println("Client:" + str);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
