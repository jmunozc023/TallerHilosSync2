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
public class Clima extends ClimaBase { //Clase que hereda el abstract del clima

    public static int clima=60000;// Velocidad inicial normal de las eolicas

    public Clima(String climaActual, int clima) { //Constructor de la clase
        super(climaActual);
        Clima.clima = clima;
    }

    public static int getClima() { //Getter del clima
        return clima;
    }

    public static void setClima(int clima) { //Setter del clima
        Clima.clima = clima;
    }

    public int cambioClima() { //Metodo de cambio de clima
        while (isRunning()) { //Mientras el sistema se encuentre corriendo, ejecuta el hilo del Clima
            int random = (int) Math.floor(Math.random() * 4 + 1); //Generador de un numero Random entre 1 y 4 para seleccionar el clima
            try {
                Thread.sleep(120000); //Tiempo que tarda el hilo en espera
                
                switch (random) { //Switch con las funciones necesarias para hacer los cambios de clima
                    case 1:
                        setClima(60000);
                        super.setClimaActual("Normal");
                        break;
                    case 2:
                        setClima(40000);
                        setClimaActual("Intermedio");
                        break;
                    case 3:
                        setClima(30000);
                        setClimaActual("Rapida");
                        break;
                    case 4:
                        setClima(90000);
                        setClimaActual("Baja");
                        break;
                }
                System.out.println("La velocidad del viento es: " + super.getClimaActual()); //Imprime cuando se ejecute un cambio en la velocidad del viento
            } catch (InterruptedException ex) {
                Logger.getLogger(Clima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clima;
    }

    @Override
    public void run() {
        cambioClima(); //Llamado al metodo cambioClima
    }

}
