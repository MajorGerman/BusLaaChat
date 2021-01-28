/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buslaachat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Catcher implements Runnable{
    private BufferedReader in;
    
    public Catcher(Socket socket) throws IOException{
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("\nClient Connected!\n");
            String str = "err";
            while(true) {
                try {
                    System.out.println("hahahaha");
                    str = in.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Catcher.class.getName()).log(Level.SEVERE, null, ex);
                }

                    System.out.println("Client:" + str);
                }
    }
    
}
