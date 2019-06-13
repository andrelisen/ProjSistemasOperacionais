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
       
       for(int i = 0;i<5;i++)
       {
                System.out.println("Esta no desalocador");
       heap.vetor[heap.quantidade]=30;
       heap.quantidade++;
       }
       gestor.aloc.release();
       gestor.desaloc.acquire();
       gestor.desaloc.release();
       
       
   // tirar da lista de ocupados e por na lista de livres   
//       int t = 0;
//       int inicio=0;
//       
//           segmentos s = heap.ocupados.get(0);//pega maior
//           t = s.getTamanho();
//           inicio = s.getInicio();
//           //System.out.println("Vou desalocar essa posição da lista: tamanho="+t+";e o inicio="+inicio);
//
//            synchronized(heap){
//                   for(int i = 0; i<t; i++)
//                   {
//                       heap.vetorHeap[inicio] = 0;
//                       inicio++;
//                       heap.quantidadeHeap--;
//                   }    
//            }
//       
//           heap.livres.add(s);
//           synchronized(heap.livres){
//                Collections.sort(heap.livres);
//                heap.somar();
//           }
//          
//           heap.ocupados.remove(0);
//           System.out.println("Desalocado com sucesso!!");

   }

    
    
}
