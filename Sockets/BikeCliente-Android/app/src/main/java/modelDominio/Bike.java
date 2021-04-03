/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author herrmann
 */
public class Bike implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private int codBike;
    private String modeloBike;
    private float valor;
    private Marca marca;

    public Bike(int codBike, String modeloBike, float valor, Marca marca) {
        this.codBike = codBike;
        this.modeloBike = modeloBike;
        this.valor = valor;
        this.marca = marca;
    }
    
    public Bike(int codBike, String modeloBike, float valor, int codMarca, String nomeMarca) {
        this.codBike = codBike;
        this.modeloBike = modeloBike;
        this.valor = valor;
        this.marca = new Marca(codMarca, nomeMarca);
    }

    public int getCodBike() {
        return codBike;
    }

    public void setCodBike(int codBike) {
        this.codBike = codBike;
    }

    public String getModeloBike() {
        return modeloBike;
    }

    public void setModeloBike(String modeloBike) {
        this.modeloBike = modeloBike;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Bike{" + "codBike=" + codBike + ", modeloBike=" + modeloBike + ", valor=" + valor + ", marca=" + marca + '}';
    }
    
    
    
    
}
