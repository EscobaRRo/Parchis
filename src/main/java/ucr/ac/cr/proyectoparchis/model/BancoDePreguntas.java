/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

/**
 *
 * @author jeanmarco
 */
public class BancoDePreguntas {
    
    private String bancoDePreguntasFacil[];//Banco de preguntas
    public BancoDePreguntas()
    {
        bancoDePreguntasFacil=new String[10];
    }
    
    public void llenarArray()
    {
        bancoDePreguntasFacil[0]="Los frenos sirven para detener el auto";//si
        bancoDePreguntasFacil[1]="El motor de un auto funciona solo con agua.";//no
        bancoDePreguntasFacil[2]="El cinturón de seguridad protege al conductor en caso de accidente.";//si
        bancoDePreguntasFacil[3]="Las luces delanteras se llaman faros.";//si
        bancoDePreguntasFacil[4]="La rueda de repuesto se llama llanta de emergencia";//si
        bancoDePreguntasFacil[5]="Un auto puede andar sin combustible";//no
        bancoDePreguntasFacil[6]="El tacómetro indica la velocidad del auto.";//no
        bancoDePreguntasFacil[7]="Los neumáticos muy desinflados pueden provocar accidentes.";//si
        bancoDePreguntasFacil[8]="Las llaves sirve para encender el motor.";//si
        bancoDePreguntasFacil[9]="El volante se usa para controlar los limpiaparabrisas";//no
    }
    
    
    
}
