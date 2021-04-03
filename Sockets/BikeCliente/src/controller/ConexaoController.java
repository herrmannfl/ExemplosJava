/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Bike;

/**
 *
 * @author herrmann
 */
public class ConexaoController {
    
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int idUnico;

    public ConexaoController(ObjectInputStream in, ObjectOutputStream out, int idUnico) {
        this.in = in;
        this.out = out;
        this.idUnico = idUnico;
    }
    
    
    public ArrayList<Bike> bikeLista(){
        try {
            out.writeObject("BikeLista");
            ArrayList<Bike> listaBike = (ArrayList<Bike>) in.readObject();
            return listaBike;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
