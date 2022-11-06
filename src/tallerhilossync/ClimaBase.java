/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

/**
 *
 * @author josep
 */
public abstract class ClimaBase implements Runnable{ //Clase abstracta para generar el Clima
    private String climaActual= ""; //Variable para almacenar el nombre del clima
    private boolean running=true; //Variable para determinar si los hilos estan corriendo

    public ClimaBase(String climaActual) { //Constructor de la clase
        this.climaActual = climaActual;
    }

    public String getClimaActual() { //Getter para el Clima Actual
        return climaActual;
    }

    public boolean isRunning() { //Getter para la variable Running
        return running;
    }

    public void setClimaActual(String climaActual) { //Setter para el Clima actual
        this.climaActual = climaActual;
    }

    public void setRunning(boolean running) { //Setter para colocar el hilo a correr
        this.running = running;
    }
    
    
}
