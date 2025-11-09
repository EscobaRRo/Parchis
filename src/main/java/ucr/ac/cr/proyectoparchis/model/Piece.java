/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author jeanmarco
 */
public class Piece {
    private Position position;
    private ImageIcon image;
    private Color color;

    public Piece() 
    {
        
    }

    public Piece(Position position, ImageIcon image) 
    {
        this.position = position;
        this.image = image;
    }
    
    public void draw(Component c, Graphics g)
    {
        image.paintIcon(c, g, position.getX(), position.getY());
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
   
}
