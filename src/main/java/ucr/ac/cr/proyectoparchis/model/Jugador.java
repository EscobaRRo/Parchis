/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

/**
 *
 * @author jeanmarco
 */
public class Jugador {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void realizarJugada()
    {
        System.out.println(nombre+ "realizo la jugada");
    }
}
