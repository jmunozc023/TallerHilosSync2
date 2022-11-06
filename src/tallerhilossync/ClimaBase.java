/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

/**
 *
 * @author josep
 */
public abstract class ClimaBase implements Runnable{
    private String climaActual= "";
    private boolean running=true;

    public ClimaBase(String climaActual) {
        this.climaActual = climaActual;
    }

    public String getClimaActual() {
        return climaActual;
    }

    public boolean isRunning() {
        return running;
    }

    public void setClimaActual(String climaActual) {
        this.climaActual = climaActual;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
}
