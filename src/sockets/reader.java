package sockets;

//import Interface.Interface;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.util.StringTokenizer;

public class reader implements Runnable {
    private final DataInputStream input;
    private String toReturn;
    //private Interface interfaz;

    /**
     *
     * @param input permite recibir contenido de un socket
     */
    public reader(DataInputStream input){
        this.input = input;
        //this.interfaz = interfaz;
    }

    /**
     * @return retorna un String
     */
    public String getToReturn(){
        return this.toReturn;
    }

    /**
     * metodo run del Thread que lee los mensajes recibidos
     */
    public void run(){
    
        while (true){
            String message = "";
            try{
                message = input.readUTF();
            } catch (IOException io){
                System.out.println("No se pudo leer el texto.");
            }
            StringTokenizer action = new StringTokenizer(message);
            String arg = action.nextToken();
            String num = action.nextToken();
            
            switch(arg) {
                case ("name"):
                    //this.interfaz.setEnemyName(num);
                    break;
            }
        }
    }
}
