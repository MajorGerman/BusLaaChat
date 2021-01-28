package buslaachat;

import java.io.IOException;
import java.net.ServerSocket;

class App {
    private Server server;
    private Server server2;
    private ServerSocket serverSocket;

    void run() throws IOException {
        serverSocket = new ServerSocket(875); 
        
        server = new Server(serverSocket);
        Thread thread1 = new Thread(server);
        thread1.start();
        
        server2 = new Server(serverSocket);
        Thread thread2 = new Thread(server2);
        thread2.start();
        
            
    }  
    
    void stop() throws IOException{
        serverSocket.close();
    }
    
}
