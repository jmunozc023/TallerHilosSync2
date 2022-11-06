/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

import java.text.NumberFormat;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josep
 */
public class Eolicas extends EolicasBase { //Clase Eolicas que implementa el abstract y por ende la clase Runnable

    private ReentrantLock sync; //variable para el lock de la sincronizacion
    private double x = 0.0; //Variable para obtener el numero de vuelta en porcentaje de la carga de la bateria

    public Eolicas(ReentrantLock sync, int id) { //Constructor para la clase que incluye el Lock
        super(id);
        this.sync = sync;
    }

    public double conversion() { //Metodo para convertir datos de String a Double
        x = Double.parseDouble(Bateria.bateria);
        return x;
    }

    public void cuenta() { //Metodo void para hacer la cuenta progresiva de la carga de la bateria
        
        x += 0.0001;
        
    }

    @Override
    public void run() { //Metodo que ejecutara el hilo correspondiente

        while (x <= 100) {

            try {

                this.cuenta();
                
                if (x == 100) {
                    System.out.println("Bateria cargada");
                } else {
                    sync.lock();
                    cuenta();
                    var temp = x;
                    Thread.sleep(Clima.clima); // Esta variable sleep recibe el tiempo que le asigna el clima
                    x = temp;
                    NumberFormat formatoNumero = NumberFormat.getNumberInstance(); //Metodo para dar formato al numero obtenido y colocarle solo 4 decimales
                    formatoNumero.setMaximumFractionDigits(4);
                    Bateria.bateria = String.valueOf(temp); //Metodo para escribir el valor obtenido en la bateria, esta protegido por el lock
                    System.out.println("Eolica " + super.getId() + " Carga: " + formatoNumero.format(x) + "%"); //Funcion para imprimir en pantalla el progreso de carga
                    sync.unlock();
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Eolicas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        super.setRunning(false);//Cambia el estado de los hilos a false en Running

    }

}
