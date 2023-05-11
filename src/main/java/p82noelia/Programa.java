/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p82noelia;

import entities.Factura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Factura.findAll");
        List<Factura> listaF = (List<Factura>) q.getResultList();
        em.close();
        return listaF;
    }
    
    private static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("p81noeliap");
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }
    
}
