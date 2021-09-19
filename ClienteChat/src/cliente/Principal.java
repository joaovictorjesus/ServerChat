package cliente;

import java.io.DataInputStream;
import java.io.IOException;


public class Principal {
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        Thread thCliente = new Thread(cliente);
        thCliente.start();
        
        Thread thTela = new Thread(() -> {
            TelaCliente tela = new TelaCliente(cliente);
            tela.setVisible(true);
            while(!cliente.getCliente().isClosed()){
                DataInputStream dis = cliente.getDis();
                try {
                    tela.getTxtArea().append("Servidor: " + dis.readUTF() + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }); 
        thTela.start();
            
        
    }
    
}
