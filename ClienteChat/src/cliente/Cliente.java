package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{
    
    String ip = "localhost";
    int porta = 9090;
    DataInputStream dis;
    DataOutputStream dos;
    Socket cliente;

    public String getIp() {
        return ip;
    }

    public int getPorta() {
        return porta;
    }

    public DataInputStream getDis() {
        return dis;
    }

    public DataOutputStream getDos() {
        return dos;
    }

    public Socket getCliente() {
        return cliente;
    }
    
    public void run() {        
        try {
        cliente = new Socket(ip, porta);        
        dis = new DataInputStream(cliente.getInputStream());
        dos = new DataOutputStream(cliente.getOutputStream());
        while(!cliente.isClosed()){        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void enviarMSG(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
