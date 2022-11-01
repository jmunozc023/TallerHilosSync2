/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallerhilossync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author josep
 */
public class TallerHilosSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clima clima= new Clima();
        clima.start();
        var services = Executors.newCachedThreadPool();
        List<EolicasBase> threadList = new ArrayList<>();
        var lock= new ReentrantLock();
        for (int i = 0; i < 4; i++) {
            threadList.add(new Eolicas(lock, i+1));
        }
        for (var thread : threadList) {
            services.submit(thread);
        }
        var monitor= new Monitor(threadList);
        Future<String> result=services.submit(monitor);
        try {
            System.out.println(result.get());
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }catch (ExecutionException ex){
            System.err.println(ex);
        }
        services.shutdown();
            
    }

}
