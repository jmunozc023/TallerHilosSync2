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

    public Eolicas(ReentrantLock sync, int id) {
        super(id);
        this.sync = sync;
    }
    @Override
    public void run() {
        int acc=0;
        for (int i = acc; i <= 10000; i+=100) {
            try {
                sync.lock();
                try {
                    var temp = Bateria.bateria;
                    Thread.sleep(Clima.clima);
                    temp += "Bateria id: "+super.getId()+" Carga: "+ i+ " Watts \n";
                    Bateria.bateria= temp;
                    i=i+acc;
                    
                } finally {
                    sync.unlock();
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Eolicas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        super.setRunning(false);
    }

}
