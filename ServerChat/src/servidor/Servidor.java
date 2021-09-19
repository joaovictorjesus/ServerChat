package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable{
    
    int porta;
    ServerSocket server;
    Socket cliente;
    DataInputStream dis;
    DataOutputStream dos;
    
    public void run() {    
        try {
            server = new ServerSocket(porta);
            cliente = server.accept();
            dos = new DataOutputStream(cliente.getOutputStream());
            dis = new DataInputStream(cliente.getInputStream());
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public int getPorta() {
        return porta;
    }

    public ServerSocket getServer() {
        return server;
    }

    public Socket getCliente() {
        return cliente;
    }

    public DataInputStream getDis() {
        return dis;
    }

    public DataOutputStream getDos() {
        return dos;
    }
    
    public void enviarMSG(String msg){
        try {
            dos.writeUTF(msg);
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
}
