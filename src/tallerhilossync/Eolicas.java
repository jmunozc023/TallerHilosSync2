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
    private int x;
    private int y;

    public Eolicas(ReentrantLock sync, int id) {
        super(id);
        this.sync = sync;
    }

    public int conversion() {
        x = Integer.parseInt(Bateria.bateria);
        return x;
    }

    @Override
    public void run() {
        sync.lock();
        try {
            Thread.sleep(Clima.clima);

            while (x <= 1000) {
                var temp = x;

                try {
                    temp += 100;
                    x = temp;
                    Bateria.bateria = String.valueOf(x);
                    System.out.println("Bateria id " + super.getId() + " Carga: " + Bateria.bateria + " Watts\n");
                } finally {
                    sync.unlock();
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Eolicas.class.getName()).log(Level.SEVERE, null, ex);
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
