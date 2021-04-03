package controller;

import com.example.bikecliente.InformacoesApp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Bike;

public class ConexaoController {
    InformacoesApp infoApp;

    // esse método é chamado somente 1 vez
    public void Conectar(){
        try {
            System.out.println("Conectando no servidor...");
            infoApp.socket = new Socket("10.0.2.2",12345);
            infoApp.out = new ObjectOutputStream(infoApp.socket.getOutputStream());
            infoApp.in = new ObjectInputStream(infoApp.socket.getInputStream());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ConexaoController(InformacoesApp infoApp) {
        this.infoApp = infoApp;
    }

    public ArrayList<Bike> bikeLista(){
        try {
            infoApp.out.writeObject("BikeLista");
            ArrayList<Bike> listaBike = (ArrayList<Bike>) infoApp.in.readObject();
            return listaBike;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
