/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

/**
 *
 * @author jeanmarco
 */
public class BancoDePreguntasEspeciales{
    private String bancoDePreguntasEspeciales[];

    public BancoDePreguntasEspeciales() 
    {
        bancoDePreguntasEspeciales=new String[5];
    }
    
    public void llenarArregloPreguntasEspeciales()
    {
        bancoDePreguntasEspeciales[0]="Un motor Diésel funciona con el ciclo Otto.";//no
        bancoDePreguntasEspeciales[1]="La válvula EGR ayuda a reducir las emisiones de gases contaminantes.";//si
        bancoDePreguntasEspeciales[2]="Un motor turbo inyecta aire a presión para aumentar la potencia";//si
        bancoDePreguntasEspeciales[3]="La inyección directa mejora la eficiencia del motor al colocar combustible directamente en la cámara de combustión";
        bancoDePreguntasEspeciales[4]="La relación peso–potencia influye en la aceleración de un auto deportivo";
    }
    
}
