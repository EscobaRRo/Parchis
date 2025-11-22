/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

import ucr.ac.cr.proyectoparchis.controller.GameController;

/**
 *
 * @author jeanmarco
 */
public class CpuGestion {
    private Board board;
    private Dado dado;
    private String colorCpu;
    private GameController controller;
    
    public CpuGestion(Board board, Dado dado, String colorCpu, GameController controller)
    {
        this.board=board;
        this.dado=dado;
        this.colorCpu=colorCpu;
        this.controller=controller;
    }
    
    public void jugarTurnoCpu()
    {
        System.out.println("Turno del cpu\nEs del color"+colorCpu);
        int valor=dado.getRandomNumber();
        System.out.println("El cpu tiró dado"+valor);
        
        board.setValorFicha(valor);
        
        switch(colorCpu)
        {
            case "Rojo":
                moverCpu(colorCpu, valor, board.isFichaRojaSalio());
                break;
            case "Amarillo":
                moverCpu(colorCpu, valor, board.isFichaAmarillaSalio());
                break;
            case "Azul":
                moverCpu(colorCpu, valor, board.isFichaAzulSalio());
                break;
            case "Verde":
                moverCpu(colorCpu, valor, board.isFichaVerdeSalio());
                break;
        }
        controller.guiGame.repaint();
        controller.getGestionTurnos().pasarTurno();
        
        System.out.println("Turno pasar al siguiente jugador");
        
        
        
        
        //controller
        
    }
    
    public void moverCpu(String color, int valor, boolean fichaSalio)//RECORDAR: la IA no ocupa puntaje
    {
        if(!fichaSalio)
        {
            if(valor>=5)
            {
                
                System.out.println("El cpu saca su ficha al tablero");
                board.sacarFicha(color);
                
            }
            else
            {
                System.out.println("El cpu no sale todavia, necesita 5 o más");
            }
        }
        else
        {
            System.out.println("El cpu intenta mover su ficha");
            board.fichas(color, 0);
            
        }
    }
    
}
