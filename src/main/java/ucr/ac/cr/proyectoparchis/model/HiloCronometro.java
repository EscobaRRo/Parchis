/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

import ucr.ac.cr.proyectoparchis.view.GUICronometro;

/**
 *
 * @author jeanmarco
 */
public class HiloCronometro extends Thread{
    private boolean corriendo=true;
    private int segundos=0;
    private GUICronometro guiCronometro;
    
    public HiloCronometro(GUICronometro gUICronometro)
    {
        this.guiCronometro=gUICronometro;
    }
    
    public void detener()
    {
        this.corriendo=false;
    }
    
    public void run()
    {
        while(corriendo)
        {
            try{
                this.sleep(1000);
                this.segundos++;
                this.guiCronometro.setCronometro(""+segundos);
                System.out.println("Tiempo"+segundos+" s");
            }
            catch(InterruptedException ex)
            {
                System.out.println("Se interrumpio el hilo");
            }
        }
    }
}
