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

    public static int clima=60/*000*/;

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
            int random = (int) Math.floor(Math.random() * 4 + 1);
            try {
                Thread.sleep(120000);
                
                switch (random) {
                    case 1:
                        setClima(60000);
                        super.setClimaActual("Normal");
                        /*setClima(2000);
                        setClimaActual("Muy alta");*/
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
                System.out.println("La velocidad del viento es: " + super.getClimaActual());
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
