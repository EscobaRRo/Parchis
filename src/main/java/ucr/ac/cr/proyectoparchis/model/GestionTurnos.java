/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

import java.util.ArrayList;

/**
 *
 * @author jeanmarco
 */
public class GestionTurnos {
    private ArrayList<Jugador> jugadores;
    private int indiceActual;//posiciones en el arreglo, sirve para obtener objetos de tipo jugadores, el turno o la posicion donde se encuentra el jugador en el array
    private int numeroTurno;

    public GestionTurnos() {
        jugadores=new ArrayList<Jugador>();
        indiceActual=0;//se inicializa en 0 porque es una posicion en el arreglo
        numeroTurno=1;
    }
    
    public void agregarJugador(Jugador jugador)
    {
        jugadores.add(jugador);//metodo que agrega objetos tipo jugador al array
    }
    public Jugador getJugadorActual()
    {
        return jugadores.get(indiceActual);//el jugador que esta "jugando" o ejerciendo su turno en este momento.
    }
    
    public void pasarTurno()
    {//metodo que hace que la siguiente persona haga su turno
        indiceActual++;
        if(indiceActual>=jugadores.size())//en caso de que el indice sea mayor a la cantidad de jugadores, se devuelve para no se invente, como para que no se salga y no muestre error
        {
            indiceActual=0;//volver al primero
        }
        numeroTurno++;//siga con el siguiente turno
    }
    
    public int getNumeroTurno()
    {
        return numeroTurno;
    }
    
    public String obtenerOrdenJugadores()
    {
        String texto="";
        for(int i=0; i<jugadores.size();i++)//hasta la cantidad de jugadores, en el primer turno el indice actual es 0. La primera no ha pasado el turno 
        {
            if(i==indiceActual)
            {
                texto +="[ "+jugadores.get(i).getNombre()+" ]";//concatena al jugador y lo muestra
            }
            else
            {
                texto+=jugadores.get(i).getNombre();
            }
            
        }
        return texto;
    }
    
    
}
