/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerhilossync;

/**
 *
 * @author josep
 */
public abstract class EolicasBase implements Runnable{ //Clase abstracta para crear las Eolicas
    private int id; //Variable que obtiene el id de la Eolica
    private boolean running= true; //Variable para determinar si el hilo esta corriendo

    public EolicasBase(int id) { //Constructor de la clase
        this.id = id;
        
    }
    public int getId() { //Getter para el ID
        return id;
    }

    public boolean isRunning() { //Getter para la variable Running
        return running;
    }

    public void setRunning(boolean running) { //Setter para la variable Running
        this.running = running;
    }

   
}
