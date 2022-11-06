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
public class Clima extends ClimaBase {

    public static int clima = 100;

    public Clima(String climaActual, int clima) {
        super(climaActual);
        Clima.clima = clima;
    }

    public static int getClima() {
        return clima;
    }

    public static void setClima(int clima) {
        Clima.clima = clima;
    }

    public int cambioClima() {
        while (isRunning()) {
            try {
                Thread.sleep(2000);
                int random = (int) (Math.random()) * 4;
                switch (random) {
                    case 1:
                        setClima(2000);
                        setClimaActual("Muy alta");
                        break;
                    case 2:
                        setClima(20);
                        setClimaActual("Muy baja");
                        break;
                    case 3:
                        setClima(50);
                        setClimaActual("Baja");
                        break;
                    case 4:
                        setClima(100);
                        setClimaActual("Normal");
                        break;
                }
                System.out.println("La velocidad del viento es: " + getClimaActual());
            } catch (InterruptedException ex) {
                Logger.getLogger(Clima.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clima;
    }

    @Override
    public void run() {
        cambioClima();
    }

}
