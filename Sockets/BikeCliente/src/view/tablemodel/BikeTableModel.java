/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Bike;

/**
 *
 * @author herrmann
 */
public class BikeTableModel extends AbstractTableModel{
    private ArrayList<Bike> listaBikes;

    public BikeTableModel(ArrayList<Bike> listaBikes) {
        this.listaBikes = listaBikes;
    }
    
    @Override
    public int getRowCount() {
        if (listaBikes == null) 
             return 0;
        else
            return listaBikes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override              // linha, coluna
    public Object getValueAt(int i, int i1) {
        Bike bk = listaBikes.get(i);
        
        switch(i1){
            case 0: return bk.getCodBike();
            case 1: return bk.getModeloBike();
            case 2: return bk.getMarca().getNomeMarca();
            case 3: return bk.getValor();
            default: return "Nenhum";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Código";
            case 1: return "Modelo";
            case 2: return "Marca";
            case 3: return "Valor";
            default: return "Nenhum";
        }
    }
    
}
