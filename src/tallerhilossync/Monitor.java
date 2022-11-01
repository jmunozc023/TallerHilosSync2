/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author josep
 */
public class Monitor implements Callable<String>{
    private List<EolicasBase> threadList;

    public Monitor(final List<EolicasBase> threadList) {
        this.threadList = threadList;
    }
    

    @Override
    public String call() throws Exception {
        boolean run=true;
        while (run) {            
            run=false;
            for (var thread : threadList) {
                if (thread.isRunning()) {
                    run= true;
                    break;
                }
            }
            Thread.sleep(Clima.clima);
        }
        return Bateria.bateria;
    }
    
}
