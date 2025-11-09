/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

/**
 *
 * @author jeanmarco
 */
public class Home {
    //casas
    private String color;
    private Piece[] piece;
    
    public Home(String color)
    {
        this.color=color;
        this.piece=new Piece[4];
    }
    
    public void setPiece(int index, Piece piece)
    {
        this.piece[index]=piece;
    }
    
    public Piece getPiece(int index)//Recibe de la clase board y asigna las posiciones que al final se asigna en el arreglo.
    {
        return this.piece[index];
    }
    
    public int getLength()//obtener tamano del arreglo
    {
        return this.piece.length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
