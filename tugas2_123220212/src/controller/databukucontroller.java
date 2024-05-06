/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatabuku.databukuDAO;
import DAOImplement.databukuimplement;
import model.*;
import view.MainView;
/**
 *
 * @author Lenovo
 */
public class databukucontroller {
    MainView frame;
    databukuimplement impldatabuku;
    List<databuku> dtbk;
    
    public databukucontroller(MainView frame){
        this.frame = frame;
        impldatabuku = new databukuDAO();
        dtbk = impldatabuku.getAll();
    }
    public void isitabel(){
        dtbk = impldatabuku.getAll();
        modeltabeldatabuku mp = new modeltabeldatabuku(dtbk);
        frame.getTabelDatabuku().setModel(mp);
    }
    
    public void insert(){
        databuku dtbk = new databuku();
        dtbk.setJudul(frame.getJTxtjudul().getText());
        dtbk.setGenre(frame.getJtxtgenre().getText());
        dtbk.setPenulis(frame.getJtxtpenulis().getText());
        dtbk.setPenerbit(frame.getJtxtpenerbit().getText());
        dtbk.setLokasi(frame.getJtxtlokasi().getText());
        dtbk.setStock(frame.getJtxtstock().getText());
        impldatabuku.insert(dtbk);
        
    }
    
    public void update(){
        databuku dtbk = new databuku();
        dtbk.setJudul(frame.getJTxtjudul().getText());
        dtbk.setGenre(frame.getJtxtgenre().getText());
        dtbk.setPenulis(frame.getJtxtpenulis().getText());
        dtbk.setPenerbit(frame.getJtxtpenerbit().getText());
        dtbk.setLokasi(frame.getJtxtlokasi().getText());
        dtbk.setStock(frame.getJtxtstock().getText());
        dtbk.setId(Integer.parseInt(frame.getJTxtid().getText()));
        impldatabuku.update(dtbk);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJTxtid().getText());
        impldatabuku.delete(id);
    }
    
    public void cari(String keyword, String category) {
    List<databuku> datasearch = new ArrayList<>();
    List<databuku> allData = impldatabuku.getAll();

    for (databuku buku : allData) {
        if (category.equalsIgnoreCase("Judul")) {
            if (buku.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Genre")) {
            if (buku.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Penulis")) {
            if (buku.getPenulis().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Penerbit")) {
            if (buku.getPenerbit().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        }
    }
    modeltabeldatabuku model = new modeltabeldatabuku(datasearch);
    frame.getTabelDatabuku().setModel(model);
}

}
