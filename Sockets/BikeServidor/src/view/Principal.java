/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TrataClienteController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author herrmann
 */
public class Principal {
    
    public static void main (String [] args){
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado. Aguardando conexões");
            // chamando e executando a classe  ConectaServidor
            ConectaServidor s1 = new ConectaServidor(servidor);
            /// iniciando a thread
            s1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

class ConectaServidor extends Thread{
    private ServerSocket servidor;
    private int idUnico = 0;

    public ConectaServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            while (true){
                Socket cliente = servidor.accept();
                System.out.println("Um novo cliente conectou "+cliente);
                
                // criando o stream de entrada e saída
                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                idUnico++;
                System.out.println("Inicializando uma thread para o cliente: "+idUnico);
                TrataClienteController trataCliente = new TrataClienteController(in, out, cliente, idUnico);
                trataCliente.start();
            }
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
