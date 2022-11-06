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
public class Monitor implements Callable<String>{ //Clase Monitor que administra la ejecucion de los hilos
    private List<EolicasBase> threadList;

    public Monitor(final List<EolicasBase> threadList) { //Constructor de la clase
        this.threadList = threadList;
    }
    

    @Override
    public String call() throws Exception { //Determina el estado de cada hilo en el ThreadList
        boolean run=true;
        while (run) {            
            run=false;
            for (var thread : threadList) {
                if (thread.isRunning()) {
                    run= true;
                    break;
                }
            }
            Thread.sleep(Clima.clima); //Obtiene el tiempo de ejecucion desde el Clima
        }
        return Bateria.bateria;
    }
    
}
