/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.proyectoparchis.model.HiloCronometro;
import ucr.ac.cr.proyectoparchis.view.GUICronometro;
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
    private HiloCronometro hiloCronometro;
    private GUICronometro guiCronometro;
    public PrincipalMenu menuPrincipal;
    private VentanaDeInstrucciones ventanaInstrucciones;
    private VentanaDeHistoria ventanaHistoria;
    private VentanaCreditos ventanaCreditos;
    private VentanaDeSeleccionDeColor ventanaSeleccion;
    private GameController gameController;
    
    public MenuController() {
        this.guiCronometro=new GUICronometro();
        this.hiloCronometro=new HiloCronometro(guiCronometro);
        ventanaInstrucciones=new VentanaDeInstrucciones();
        ventanaHistoria=new VentanaDeHistoria();
        ventanaCreditos=new VentanaCreditos();
        menuPrincipal=new PrincipalMenu();
        ventanaSeleccion=new VentanaDeSeleccionDeColor();
        String colorUno=ventanaSeleccion.getColorSeleccionado();
        //gameController=new GameController(ventanaSeleccion, colorUno);//le manda por parametros al gameController la ventana de seleccionDeColor para que le mande los nombres mediante los metodos que se crearon en la clase.
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
                //obtener nombres
                String nombreJugador=ventanaSeleccion.getNombreJugador();
                String nombreCPU=ventanaSeleccion.getNombreCPU();
                //obtener color
                String colorUno=ventanaSeleccion.getColorSeleccionado();
                if(colorUno==null)
                {
                    JOptionPane.showInputDialog("Seleccione un color");
                    break;
                }
                gameController=new GameController(ventanaSeleccion, colorUno);//mandamos ventanaDeseleccion y colorUno
                
                gameController.crearJugadores(nombreJugador, nombreCPU);

                gameController.guiGame.setVisible(true);//hacer visible el tablero de parchis
                this.guiCronometro.setVisible(true);
                this.hiloCronometro.start();
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
