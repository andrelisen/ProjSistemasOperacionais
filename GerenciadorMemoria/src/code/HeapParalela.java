
package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andrelise
 */
public class HeapParalela{
 
    volatile int quantidade;
    volatile int tamanhodaHeap;
    volatile int[] vetor = new int [tamanhodaHeap];

    public void setTamanhodaHeap(int tamanhodaHeap) {
        this.tamanhodaHeap = tamanhodaHeap;
        
        int []vetorAux = new int[tamanhodaHeap];
        for(int i =0; i< tamanhodaHeap; i++)//inicializando vetor
        {
            vetorAux[i]=0;
        }
        
        this.vetor=vetorAux;
        
    }
    
    public void imprimir()
    {
        System.out.println("Esse é o meu vetor depois de ter inserido todos elementos :D");
        for(int i =0;i<tamanhodaHeap;i++){
            System.out.println("["+i+"]="+vetor[i]);
        }
    }
    
    


}
