/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

/**
 *
 * @author jeanmarco
 */
public class Dado {

    public Dado() {
    }
    
    public int getRandomNumber()
    {
        int num=(int)(Math.random()*(6-1+1))+1;
        return num;
    }
    
    public void returnImage()
    {
        switch(getRandomNumber())
        {
            case 1: 
                //primera imagen
            break;
            case 2: 
                //segunda imagen
            break;
            case 3: 
                //tercera imagen
            break;
            case 4: 
                //cuarta imagen
            break;
            case 5: 
                //quinta imagen
            break;
            case 6: 
                //sexta imagen
            break;
        }
    }
    
}
