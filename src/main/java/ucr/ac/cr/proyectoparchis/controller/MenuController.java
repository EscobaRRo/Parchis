/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.proyectoparchis.view.PrincipalMenu;
import ucr.ac.cr.proyectoparchis.view.VentanaCreditos;
import ucr.ac.cr.proyectoparchis.view.VentanaDeHistoria;
import ucr.ac.cr.proyectoparchis.view.VentanaDeInstrucciones;
import ucr.ac.cr.proyectoparchis.view.VentanaDeSeleccionDeColor;

/**
 *
 * @author jeanmarco
 */
public class MenuController implements ActionListener{
    public PrincipalMenu menuPrincipal;
    private VentanaDeInstrucciones ventanaInstrucciones;
    private VentanaDeHistoria ventanaHistoria;
    private VentanaCreditos ventanaCreditos;
    private VentanaDeSeleccionDeColor ventanaSeleccion;
    private GameController gameController;
    
    public MenuController() {
        ventanaInstrucciones=new VentanaDeInstrucciones();
        ventanaHistoria=new VentanaDeHistoria();
        ventanaCreditos=new VentanaCreditos();
        menuPrincipal=new PrincipalMenu();
        ventanaSeleccion=new VentanaDeSeleccionDeColor();
        String colorUno=ventanaSeleccion.getColorSeleccionado();
        String colorDos=ventanaSeleccion.getColorCPU();
        gameController=new GameController(ventanaSeleccion, colorUno,colorDos);//le manda por parametros al gameController la ventana de seleccionDeColor para que le mande los nombres mediante los metodos que se crearon en la clase.
        ventanaSeleccion.listen(this);
        menuPrincipal.listen(this);
//        ventanaInstrucciones.listen(this);
//        ventanaHistoria.listen(this);
//        ventanaCreditos.listen(this);
//        ventanaSeleccion.listen(this);
        menuPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand())
        {
            case "Enviar"://enviar informacion (nombres y color seleccionado)
                ventanaSeleccion.getColorSeleccionado();//para obtener el color seleccionado para la persona que lo va a manejar de la ventana de seleccion de color.
                gameController.crearJugadores();//para crear los jugadores
                gameController.guiGame.setVisible(true);//hacer visible el tablero de parchis
            break;
            
            case "Jugar":
                ventanaSeleccion.setVisible(true);//del menu principal a la ventana de seleccion de color, asi asegurandome que elija bien el color
//                gameController.guiGame.setVisible(true);
                //boton para Jugar
            break;
            case "Instrucciones":
                //boton para las instrucciones
                ventanaInstrucciones.setVisible(true);
            break;
            case "Historia":
                //boton para historia
                ventanaHistoria.setVisible(true);
            break;
            case "Creditos":
                //boton para creditos
                ventanaCreditos.setVisible(true);
            break;
        }
    }
    
}
