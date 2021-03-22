/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeDominio;

import java.io.Serializable;

/**
 *
 * @author herrmann
 */
public class Marca implements Serializable{
    private static final long serialVersionUID = 123456789L;
    private int codMarca;
    private String nomeMarca;

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public Marca(int codMarca, String nomeMarca) {
        this.codMarca = codMarca;
        this.nomeMarca = nomeMarca;
    }

    @Override
    public String toString() {
        return "Marca{" + "codMarca=" + codMarca + ", nomeMarca=" + nomeMarca + '}';
    }
    
    
    
    
}
