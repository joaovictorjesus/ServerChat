package servidor;

//import cliente.TelaCliente;
import java.io.DataInputStream;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        
        Servidor servidor = new Servidor();
        Thread thServidor = new Thread(servidor);
        thServidor.start();
        
        Thread thTela = new Thread(new Runnable() {
            @Override
            public void run() {
                TelaServidor tela = new TelaServidor(servidor);
                tela.setVisible(true);
                tela.getTxtArea().append("Aguardando conexão...");
                
                while(!servidor.getCliente().isClosed()){
                    try {
                        DataInputStream dis = servidor.getDis();
                        String linha = dis.readUTF();
                        tela.getTxtArea().append("Cliente: " + linha + "\n");
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }
            }            
        });
        thTela.start();
                       
    }
    
}
