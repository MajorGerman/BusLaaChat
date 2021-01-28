/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buslaachat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Server implements Runnable{
    private Socket socket;
    private ServerSocket serverSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Catcher catcher;
    private Sender sender;
    
    public Server(ServerSocket serverSocket) throws IOException{
        
        socket = serverSocket.accept();
        catcher = new Catcher(socket);
        sender = new Sender(socket);
    }
            

    @Override
    public void run(){
        Thread inThread = new Thread(catcher);
        inThread.start();
        Thread outThread = new Thread(sender);
        outThread.start();
        
        
    }
    public void stop() throws IOException{
        out.close();
        in.close();
        socket.close();
        
    }
    
}
