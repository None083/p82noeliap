/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p82noelia;

import controladores.FacturaJpaController;
import controladores.exceptions.NonexistentEntityException;
import entities.Factura;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Persistence;

/**
 *
 * @author noelia
 */
public class Programa {

    private static FacturaJpaController fjc = new FacturaJpaController(Persistence.createEntityManagerFactory("p81noeliap"));

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int opcion;

        do {
            
            System.out.println("""
                               
                               -------------------------------------------------
                                               ESCOGE UNA OPCIÓN
                               -------------------------------------------------
                                            1 - Consultar facturas
                                            2 - Crear factura
                                            3 - Modificar factura
                                            4 - Eliminar factura
                                            0 - Salir
                               -------------------------------------------------
                               """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    verFacturas();
                    break;
                case 2:
                    aniadirFactura();
                    break;
                case 3:
                    modificarFactura();
                    break;
                case 4:
                    eliminarFactura();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 0);

    }

    private static void verFacturas() {
        List<Factura> listaF = fjc.findFacturaEntities();

        for (Factura f : listaF) {
            System.out.println(f);
        }
    }

    private static void aniadirFactura() throws Exception {
        System.out.println("Introduce la id de la factura");
        String id = teclado.nextLine();
        System.out.println("Introduce el día de emisión");
        int dia = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce el mes de emisión");
        int mes = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce el año de emisión");
        int anio = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce una descripción");
        String descrip = teclado.nextLine();
        System.out.println("Introduce el importe");
        double importe = teclado.nextDouble();

        Factura f = new Factura(id, convertToDateViaSqlDate(LocalDate.of(anio, mes, dia)), descrip, BigDecimal.valueOf(importe));

        fjc.create(f);

    }

    private static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
    
    private static void modificarFactura() throws Exception{
        System.out.println("Introduce la id de la factura que quieres modificar");
        String id = teclado.nextLine();
        System.out.println("Introduce el día de emisión");
        int dia = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce el mes de emisión");
        int mes = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce el año de emisión");
        int anio = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce una descripción");
        String descrip = teclado.nextLine();
        System.out.println("Introduce el importe");
        double importe = teclado.nextDouble();

        Factura f = new Factura(id, convertToDateViaSqlDate(LocalDate.of(anio, mes, dia)), descrip, BigDecimal.valueOf(importe));

        fjc.edit(f);
    }
    
    private static void eliminarFactura() throws NonexistentEntityException{
        System.out.println("Introduce la id de la factura que quieres eliminar");
        String id = teclado.nextLine();
        
        fjc.destroy(id);
        
    }

}
