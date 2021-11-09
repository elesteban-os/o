package sockets;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    Socket socket;
    int id;
    reader Reader;
    sender Sender;
    //Window window;

    public Client() throws IOException{
        //this.window = window;
        joinServer();
        startClient();
        getID();
    }

    public void joinServer() throws IOException {
        this.socket = new Socket("localhost",2121);

    }

    public void startClient() throws IOException {
        this.Reader = new reader(new DataInputStream(this.socket.getInputStream()));
        this.Sender = new sender(new DataOutputStream(this.socket.getOutputStream()));
    }

    public void getID() throws IOException{
        DataInputStream input = new DataInputStream(this.socket.getInputStream());
        this.id = input.readInt();
    }

    public static void main(String[] args) throws IOException{
        Client cliente = new Client();
    }
}
