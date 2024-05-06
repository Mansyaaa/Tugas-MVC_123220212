/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Lenovo
 */
public class modeltabeldatabuku extends AbstractTableModel{

    List<databuku> dtbk;
    public modeltabeldatabuku(List<databuku>dtbk){
        this.dtbk = dtbk;
    }
    
    @Override
    public int getRowCount() {
        return dtbk.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Judul";
            case 2:
                return "Genre";
            case 3:
                return "Penulis";
            case 4:
                return "Penerbit";
            case 5:
                return "Lokasi";
            case 6:
                return "Stock";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dtbk.get(row).getId();
            case 1:
                return dtbk.get(row).getJudul();
            case 2:
                return dtbk.get(row).getGenre();
            case 3:
                return dtbk.get(row).getPenulis();
            case 4:
                return dtbk.get(row).getPenerbit();
            case 5:
                return dtbk.get(row).getLokasi();
            case 6:
                return dtbk.get(row).getStock();
            default:
                return null;
        }
    }
    
}
