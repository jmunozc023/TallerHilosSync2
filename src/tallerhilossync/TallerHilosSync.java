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
        String climaActual = null; //Crea una variable local del clima actual
        var cli = new Clima(climaActual, Clima.clima); //Crea un hilo del clima

        var services = Executors.newCachedThreadPool(); //Crea un Threadpool para almacenar los hilos
        List<EolicasBase> threadList = new ArrayList<>(); //Se crea una lista para almacenar los hilos

        services.submit(cli); //Se incluye en el Threadpool un hilo independiente para el clima

        var lock = new ReentrantLock(); //Se crea el lock para los hilos sincronizados
        for (int i = 0; i < 2; i++) { //Se generan los hilos de las Eolicas
            threadList.add(new Eolicas(lock, i + 1));
        }
        for (var thread : threadList) { //Se ingresan todos los hilos al Threadpool
            services.submit(thread);
        }
        var monitor = new Monitor(threadList); //Se crea el Monitor de los hilos y la logica para hacer la tarea
        Future<String> result = services.submit(monitor);
        try {
            System.out.println(result.get());
        } catch (InterruptedException ex) {
            System.err.println(ex);
        } catch (ExecutionException ex) {
            System.err.println(ex);
        }
        cli.setRunning(false); //Se detiene el hilo del Clima
        services.shutdown(); //Se detienen los demas servicios
    }

}
