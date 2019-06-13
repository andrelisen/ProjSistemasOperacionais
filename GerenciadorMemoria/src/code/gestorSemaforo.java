/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.concurrent.Semaphore;

/**
 *
 * @author andrelise
 */
public class gestorSemaforo {
    
    Semaphore aloc = new Semaphore(0);
    Semaphore desaloc = new Semaphore(0);
    volatile int verificacao = 0;
    
}
