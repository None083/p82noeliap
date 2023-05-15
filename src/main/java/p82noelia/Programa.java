/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p82noelia;

import controladores.FacturaJpaController;
import entities.Factura;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author noelia
 */
public class Programa {

    public static void main(String[] args) {
        
        Factura f = new Factura();
        List<Factura> listaF = findAll();
        
    }
    
    public static List<Factura> findAll() {
        FacturaJpaController fjc = new FacturaJpaController(Persistence.createEntityManagerFactory("p81noeliap"));
        List<Factura> listaF = fjc.findFacturaEntities();
        return listaF;
    }

    
}
