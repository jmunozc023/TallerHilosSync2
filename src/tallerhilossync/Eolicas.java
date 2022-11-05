/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josep
 */
public class Eolicas extends EolicasBase {

    private ReentrantLock sync;
    private int x=0;
    private int y;
    private int c;

    public Eolicas(ReentrantLock sync, int id) {
        super(id);
        this.sync = sync;
    }

    public int conversion() {
        x = Integer.parseInt(Bateria.bateria);
        return x;
    }
    public void cuenta(){
        sync.lock();
        c =y;
        y=x+100;
        c=y;
        
        sync.unlock();
    }

    @Override
    public void run() {
        
        while (c <= 1000) {

            try {
               
                this.cuenta();
                var temp = c;
                sync.lock();
                Thread.sleep(Clima.clima);
                
                 
                x=temp;
                
                Bateria.bateria=String.valueOf(temp);
                System.out.println("Bateria id " + super.getId() + " Carga: " + Bateria.bateria + " Watts\n");
                
                sync.unlock();
            } catch (InterruptedException ex) {
                Logger.getLogger(Eolicas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        super.setRunning(false);
      
    }

    /*try {
        sync.lock();
        while (y <= 10000) {
        try {
        
        var temp = Bateria.bateria;
        x = x + 100;
        Thread.sleep(Clima.clima);
        temp += "Bateria id: " + super.getId() + " Carga: " + x + " Watts \n";
        Bateria.bateria = temp;
        y = x;
        } finally {
        sync.unlock();
        }
        
        }
        } catch (InterruptedException ex) {
        Logger.getLogger(Eolicas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        super.setRunning(false);*/
}
