/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrelise
 */
public class desalocadorP extends Thread {
    
     HeapParalela heap;
     gestorSemaforo gestor;
     
    public desalocadorP(HeapParalela heap, gestorSemaforo gestor) {
        this.heap = heap;
        this.gestor = gestor;
    }
    
    @Override
    public void run() {
       for(;;)
       {
            try {
                gestor.desaloc.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(desalocadorP.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                desalocar();
            } catch (InterruptedException ex) {
                Logger.getLogger(desalocadorP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void desalocar() throws InterruptedException
   {
       
       System.out.println("Desalocador :O");
       
       
       int t = 0;
       int inicio=0;
       segmentos s;
       
       synchronized(heap.ocupados){
           s = heap.ocupados.get(0);
       }

       t = s.getTamanho();
       inicio = s.getInicio();

       synchronized(heap.vetor){
           for(int i = 0; i<t; i++){
               heap.vetor[inicio]=0;
               inicio++;
               heap.quantidade--;
           }
       }

       heap.livres.add(s);
       
       if(heap.livres.size()!=1)
       {
           synchronized(heap.livres){
           Collections.sort(heap.livres);
           }
       }
       
       heap.somarPosicoesLivres();
       
       synchronized(heap.ocupados){
           heap.ocupados.remove(0);
       }
       
       gestor.aloc.release();
       gestor.desaloc.acquire();
       gestor.desaloc.release();
       

   }

    
    
}
