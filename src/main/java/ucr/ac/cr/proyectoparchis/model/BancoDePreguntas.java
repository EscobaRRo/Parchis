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
        //pares son si, impares no
        bancoDePreguntasFacil[0]="Los frenos sirven para detener el auto\nResponda con true o false";//si
        bancoDePreguntasFacil[1]="El motor de un auto funciona solo con agua.\nResponda con true o false";//no
        bancoDePreguntasFacil[2]="El cinturón de seguridad protege al conductor en caso de accidente.\nResponda con true o false";//si
        bancoDePreguntasFacil[3]="Un auto puede andar sin combustible\nResponda con true o false";//no
        bancoDePreguntasFacil[4]="La rueda de repuesto se llama llanta de emergencia\nResponda con true o false";//si
        bancoDePreguntasFacil[6]="El volante se usa para controlar los limpiaparabrisas\nResponda con true o false";//no
        bancoDePreguntasFacil[7]="Los neumáticos muy desinflados pueden provocar accidentes.\nResponda con true o false";//si
        bancoDePreguntasFacil[8]="Las direccionales sirven para encender el motor.\nResponda con true o false";//no
        bancoDePreguntasFacil[9]="El tacómetro indica la velocidad del auto.\nResponda con true o false";//si
    }
    
    public int getRandomNumber()
    {
        return (int)(Math.random()*(9-0+1))+0;
    }
    
    public String getPregunta()//metodo para obtener preguntas
    {
        llenarArray();//se llena el array de las preguntas
        String pregunta="";//variable que va a ensenar las preguntas
        pregunta=bancoDePreguntasFacil[getRandomNumber()];//se le asigna la pregunta
        return pregunta;//manda la pregunta
    }
    
    public boolean validarRespuesta(String respuesta)//metodo para validar respuesta
    {
        if(getRandomNumber()%2==0)//si el numero que recibe es par, hace una forma de validar la respuesta. Aqui las respuestas tienen que ser true
        {
            if(respuesta.toLowerCase().equalsIgnoreCase("true"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }//fin if de las respuestas pares
        if(respuesta.toLowerCase().equalsIgnoreCase("false"))//las respuestas de los números impares son no, por lo tanto se la respuesta correcta es falso
        {
            return false;
        }
        return true;
    }
    
    
    
}
