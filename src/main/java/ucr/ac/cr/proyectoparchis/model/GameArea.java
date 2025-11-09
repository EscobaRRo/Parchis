/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

/**
 *
 * @author jeanmarco
 */
public class GameArea {
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    
    public GameArea(String colorUsuario, String colorCpu)
    {
        this.board=new Board(colorUsuario, colorCpu);
    }
    
    public Board getBoard()
    {
        return board;
    }
    
}
