package buslaachat;

import java.io.IOException;

class App {
    private Server server;
    private Client client;

    void run() throws IOException {
        server = new Server();
        client = new Client();
        
        Thread serverThread = new Thread(server);
        Thread clientThread = new Thread(client);
        
        serverThread.start();
        clientThread.start();
            
    }  
    
}
