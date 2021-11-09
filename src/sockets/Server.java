package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    ServerSocket server;
    Socket serverListener;
    ArrayList<Socket> clients = new ArrayList<>();
    int clientsIDs;
    reader Reader;
    sender Sender;
    DataInputStream input;
    DataOutputStream output;
    //Calculator calculate;
    //FileManager file;


    public void runServer() throws IOException{
        this.server = new ServerSocket(2121);
        this.serverListener = new Socket("localhost", 2121);
        this.Reader = new reader(new DataInputStream(this.serverListener.getInputStream()));
        this.Sender = new sender(new DataOutputStream(this.serverListener.getOutputStream()));
        newClient();
    }

    public void newClient() throws IOException {
        while(true){
            Socket client = this.server.accept();
            this.clients.add(client);
            System.out.println("Nuevo cliente conectado, es el #" + "");
            assignID(client);
        }
    }

    public void assignID(Socket client) throws IOException {
        DataOutputStream outputClient = new DataOutputStream(client.getOutputStream());
        outputClient.writeInt(this.clientsIDs);
        this.clientsIDs++;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.runServer();
    }
}