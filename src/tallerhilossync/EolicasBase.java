/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

/**
 *
 * @author josep
 */
public abstract class EolicasBase implements Runnable{
    private int id;
    private boolean running= true;

    public EolicasBase(int id) {
        this.id = id;
        
    }
    public int getId() {
        return id;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

   
}
