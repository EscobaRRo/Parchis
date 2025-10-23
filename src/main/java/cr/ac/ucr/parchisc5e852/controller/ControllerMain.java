/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.parchisc5e852.controller;

import cr.ac.ucr.parchisc5e852.view.GUIinicio;
import cr.ac.ucr.parchisc5e852.view.VentanaCreditos;
import cr.ac.ucr.parchisc5e852.view.VentanaDeHistoria;
import cr.ac.ucr.parchisc5e852.view.VentanaDeInstrucciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeanmarco
 */
public class ControllerMain implements ActionListener{
    private GUIinicio guiInicio;
    private VentanaCreditos ventanaCreditos;
    private VentanaDeHistoria ventanaHistoria;
    private VentanaDeInstrucciones ventanaInstrucciones;
    
    public ControllerMain()
    {
        this.guiInicio=new GUIinicio();
        this.guiInicio.listen(this);
        this.guiInicio.setVisible(true);
        this.ventanaCreditos=new VentanaCreditos();
        this.ventanaHistoria=new VentanaDeHistoria();
        this.ventanaInstrucciones=new VentanaDeInstrucciones();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand())
       {
           case "Jugar":
               //para jugar
           break;
           case "Instrucciones":
               //Ventana de instrucciones
               this.ventanaInstrucciones.setVisible(true);//muestra la ventana de jugar
           break;
           case "Historia":
               //Historia
               this.ventanaHistoria.setVisible(true);
           break;
           case "Creditos":
               //Ventana de creditos
               this.ventanaCreditos.setVisible(true);
           break;
           case "Enviar":
               //Enviar la selección del color
           break;
       }
    }
}
