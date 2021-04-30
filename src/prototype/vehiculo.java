/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class vehiculo implements Cloneable{
    
    private List<String> listaVehiculos;

    public vehiculo() {
        this.listaVehiculos = new ArrayList<String>();
    }
    
     public vehiculo(List<String> lista) {
        this.listaVehiculos = lista;
    }
    
    public void insertarDatos()
    {
        listaVehiculos.add("Honda amaze");
        listaVehiculos.add("Audi a4");
        listaVehiculos.add("Hyundai creta");
        listaVehiculos.add("Muruti baleno");
        listaVehiculos.add("Honda civic");
    }

    public List<String> getListaVehiculos() {
        return listaVehiculos;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        List<String> templist = new ArrayList<String>();
        
        for(String s : this.getListaVehiculos())
        {
            templist.add(s);
        }
        return new vehiculo(templist);
    }
    
    public class prototypeEjemplo{
        
        public static void main(String[] args) throws CloneNotSupportedException{
            
            vehiculo a = new vehiculo();
            a.insertarDatos();
            
            vehiculo b =  (vehiculo)a.clone();
            List<String> lista = b.getListaVehiculos();
            lista.add("Honda civic");
            
            System.out.println(a.getListaVehiculos());
            System.out.println(lista);
            
            b.getListaVehiculos().remove("Audi a4");
            System.out.println(lista);
        }
    }
}
