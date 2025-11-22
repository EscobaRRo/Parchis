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
import ucr.ac.cr.proyectoparchis.model.CpuGestion;
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
    private boolean verificar=true;
    public GUIGame guiGame;
    private GameArea gameArea;
    private ControlPanel controlPanel;
    private BoardPanel boardPanel;
    private Dado dado;
    private GestionTurnos gestionTurnos;
    private VentanaDeSeleccionDeColor seleccionColor;
    private String colorJugador;
    private double puntaje=5;
    private CpuGestion gestionCpu;
    
    
    public GameController(VentanaDeSeleccionDeColor seleccionColor,String colorUno)//recibe por parametros la ventana seleccion de color, porque los datos de nombres y colores se encuentran en la ventanaDeSeleccion del otro controlador
    {
        this.seleccionColor=seleccionColor;//se le asigna a la variable de esta clase la ventana de la clase del GameController porque si se crea una nueva, no se guardan los datos ingresados
        this.gameArea=new GameArea(colorUno, puntaje);
        this.dado=new Dado();
        this.colorJugador=colorUno;
//        this.controlPanel=new ControlPanel();
//        this.boardPanel=new BoardPanel();
        this.gestionTurnos=new GestionTurnos();
        this.guiGame=new GUIGame(this);
        this.board= this.gameArea.getBoard();
        this.gestionCpu=new CpuGestion(board, dado, obtenerColorCpu(colorUno), this);
        //this.guiGame.setVisible(true); no se visibiliza de una sola vez, ya que en el botón de jugar del primer menú se mostraría.
        //piece= new Piece(new Position(400, 400), new ImageIcon("./src/main/resources/imagenes/"))
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand())
        {
            
                
               case "dado":
            Jugador actual = gestionTurnos.getJugadorActual(); // jugador actual
            int valor = dado.getRandomNumber(); // valor del dado
            board.setValorFicha(valor); // asignar valor al board
            System.out.println(actual.getNombre() + " tiró el dado: " + valor);

            // Dependiendo del color del jugador, intentamos sacar o mover la ficha
            switch(colorJugador) {
                case "Rojo":
                    if (!board.isFichaRojaSalio()) { // si no ha salido
                        if (valor >= 5) {
                            board.sacarFicha("Rojo");
                            System.out.println("Ficha roja salió al tablero");
                        } else {
                            System.out.println("Necesitas 5 o más para sacar la ficha roja");
                        }
                    } else { // ya salió, mover y preguntar
                        board.fichas("Rojo", puntaje);
                    }
                    break;

                case "Amarillo":
                    if (!board.isFichaAmarillaSalio()) {
                        if (valor >= 5) {
                            board.sacarFicha("Amarillo");
                            System.out.println("Ficha amarilla salió al tablero");
                        } else {
                            System.out.println("Necesitas 5 o más para sacar la ficha amarilla");
                        }
                    } else {
                        board.fichas("Amarillo", puntaje);
                    }
                    break;

                case "Azul":
                    if (!board.isFichaAzulSalio()) {
                        if (valor >= 5) {
                            board.sacarFicha("Azul");
                            System.out.println("Ficha azul salió al tablero");
                        } else {
                            System.out.println("Necesitas 5 o más para sacar la ficha azul");
                        }
                    } else {
                        board.fichas("Azul", puntaje);
                    }
                    break;

                case "Verde":
                    if (!board.isFichaVerdeSalio()) {
                        if (valor >= 5) {
                            board.sacarFicha("Verde");
                            System.out.println("Ficha verde salió al tablero");
                        } else {
                            System.out.println("Necesitas 5 o más para sacar la ficha verde");
                        }
                    } else {
                        board.fichas("Verde", puntaje);
                    }
                    break;
            }

            guiGame.repaint(); // actualizar tablero
            actual.realizarJugada(); // marcar jugada
            gestionTurnos.pasarTurno(); // pasar turno
            
            if(gestionTurnos.getJugadorActual().getNombre().equals("CPU"))
            {
                gestionCpu.jugarTurnoCpu();
            }
            System.out.println("Siguiente turno: " + gestionTurnos.getJugadorActual().getNombre());

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
    
    public GestionTurnos getGestionTurnos()
    {
        return gestionTurnos;
    }
    public Dado getDado()
    {
        return this.dado;
    }
    
    public String obtenerColorCpu(String colorJugador)
    {
        String colorCpu="";
        switch(colorJugador)
        {
            case "Rojo":
                    colorCpu="Amarillo";
                break;
              
                
            case "Amarillo":
                    colorCpu= "Rojo";
                break;
            
            case "Azul":
                    colorCpu="Verde";
                break;
            
            case "Verde":
                    colorCpu="Azul";
                break;
        }
        return colorCpu;
    }
}
