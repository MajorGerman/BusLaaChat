/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buslaachat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Sender implements Runnable{
    private Scanner scan = new Scanner(System.in);
    private PrintWriter out;
    
    public Sender(Socket socket) throws IOException{
        out = new PrintWriter(socket.getOutputStream(),true);
    }

    @Override
    public void run() {
        String str = "CLIENT SEND ERROR";
        while(true) {
            str = scan.nextLine();
            out.println(str);
        }
    }
    
}
