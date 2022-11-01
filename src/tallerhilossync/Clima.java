/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josep
 */
public class Clima extends Thread {
    public static int clima=100;
  
    
    public Clima() {
        
        try {
            int random= (int) (Math.random())*4;
            switch (random) {
                case 1:
                    clima=10;
                    System.out.println("La velocidad del viento es muy alta");
                    break;
                case 2:
                    clima=20;
                    System.out.println("La velocidad del viento es alta");
                    break;
                case 3:
                    clima=50;
                    System.out.println("La velocidad del viento es normal");
                    break;
                case 4:
                    clima=100;
                    System.out.println("La velocidad del viento es baja");
                    break;
                
            }
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Clima.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
