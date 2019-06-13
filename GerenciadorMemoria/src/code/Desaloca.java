/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrelise
 */
public class Desaloca extends Thread{
    
    Paralelo monitor;

    public Desaloca(Paralelo monitor) {
        this.monitor = monitor;
    }
    
    public void run() { 
        try {
        //método que sobrescreve run da thread
        monitor.remove();
        } catch (InterruptedException ex) {
            Logger.getLogger(Desaloca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
