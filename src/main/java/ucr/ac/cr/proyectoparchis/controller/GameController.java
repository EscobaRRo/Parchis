/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.controller;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.proyectoparchis.model.Dado;
import ucr.ac.cr.proyectoparchis.model.Board;
import ucr.ac.cr.proyectoparchis.model.GameArea;
import ucr.ac.cr.proyectoparchis.model.GestionTurnos;
import ucr.ac.cr.proyectoparchis.model.Jugador;
import ucr.ac.cr.proyectoparchis.model.Piece;
import ucr.ac.cr.proyectoparchis.view.BoardPanel;
import ucr.ac.cr.proyectoparchis.view.ControlPanel;
import ucr.ac.cr.proyectoparchis.view.GUIGame;
import ucr.ac.cr.proyectoparchis.view.VentanaDeSeleccionDeColor;

/**
 *
 * @author jeanmarco
 */
public class GameController implements ActionListener, MouseListener{
    private Board board;
    private Piece piece;
    public GUIGame guiGame;
    private GameArea gameArea;
    private ControlPanel controlPanel;
    private BoardPanel boardPanel;
    private Dado dado;
    private GestionTurnos gestionTurnos;
    private VentanaDeSeleccionDeColor seleccionColor;
    private String colorJugador;
    
    
    public GameController(VentanaDeSeleccionDeColor seleccionColor,String colorUno)//recibe por parametros la ventana seleccion de color, porque los datos de nombres y colores se encuentran en la ventanaDeSeleccion del otro controlador
    {
        this.seleccionColor=seleccionColor;//se le asigna a la variable de esta clase la ventana de la clase del GameController porque si se crea una nueva, no se guardan los datos ingresados
        this.gameArea=new GameArea(colorUno);
        this.dado=new Dado();
        this.colorJugador=colorUno;
//        this.controlPanel=new ControlPanel();
//        this.boardPanel=new BoardPanel();
        this.gestionTurnos=new GestionTurnos();
        this.guiGame=new GUIGame(this);
        this.board= this.gameArea.getBoard();
        //this.guiGame.setVisible(true); no se visibiliza de una sola vez, ya que en el botón de jugar del primer menú se mostraría.
        //piece= new Piece(new Position(400, 400), new ImageIcon("./src/main/resources/imagenes/"))
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand())
        {
            case "dado":
                System.out.println("Dado");//Muestra un mensaje de dado
                Jugador actual=gestionTurnos.getJugadorActual();//esta variable tiene la posicion del jugador que esta siendo usado en el array
                int valor=dado.getRandomNumber();//se le asigna a una variable el valor del dado.
                board.setValorFicha(valor);//se le manda el valor que obtuvo el dado
                board.fichas(colorJugador);//se le manda al metodo fichas el color del jugador ?
                guiGame.repaint();//repaint
                System.out.println(actual.getNombre()+"tiró el dado: "+valor);//Se muestra el que hizo el turno y el valor del dado
                actual.realizarJugada();
                    //se realiza la jugada
                gestionTurnos.pasarTurno();// metodo que hace que se pase el turno a la siguiente persona
                System.out.println("Siguiente turno" +gestionTurnos.getJugadorActual().getNombre());//se muestra el siguiente jugador
            break;
            case "jugador1":
                System.out.println("Jugador Uno");
            break;
            
            case "jugador2":
                System.out.println("Jugador Dos");
            break;
            
            case "Salir":
                this.guiGame.setVisible(false);//Para que se cierre la ventana del tablero
                System.out.println("Fin del juego");
            break;
            case "Jugar":
                System.out.println("Jugar");
            break;
        }
    
    }
        
    public void draw(Component c, Graphics g)
    {
       board.draw(c, g);//se dibujan las fichas
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X: " + e.getX() + "Y: " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    public void crearJugadores(String nombreJugador, String nombreCPU)
    {
        Jugador jugador=new Jugador(nombreJugador);//crea un jugador y de la ventana seleccionColor le asigna el nombre.
        Jugador cPU=new Jugador(nombreCPU);//crea el cPU y de la ventana seleccionColor le asigna el nombre.
        gestionTurnos.agregarJugador(jugador);//en el metodo agregar por parametro se recibe un jugador. Se le suma el jugadorUno al arrayList mediante este metodo.
        gestionTurnos.agregarJugador(cPU);//en el metodo agregar por parametro se recibe un jugador. Se le suma el cPU al arrayList mediante este metodo.
        //es el metodo para crear los jugadores
    }
    
    public void setBoardPanel(BoardPanel panel)
    {
        this.boardPanel=panel;
    }
    
    public Dado getDado()
    {
        return this.dado;
    }
    
}
