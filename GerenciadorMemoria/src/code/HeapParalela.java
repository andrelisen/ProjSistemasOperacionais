
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
    volatile int[] vetorNaoatendi = new int [tamanhodaHeap];
    volatile int contador = 0;
    volatile int percentual = 0;
    List<segmentos> ocupados = new ArrayList<segmentos>();   
    List <segmentos> livres = new ArrayList<segmentos>(); 
    volatile int somatorio =0;
    
    public void setTamanhodaHeap(int tamanhodaHeap) {
        this.tamanhodaHeap = tamanhodaHeap;
        
        int []vetorAux = new int[tamanhodaHeap];
        for(int i =0; i< tamanhodaHeap; i++)//inicializando vetor
        {
            vetorAux[i]=0;
        }
        int []vetorAux2 = new int[tamanhodaHeap];
        for(int i =0; i< tamanhodaHeap; i++)//inicializando vetor
        {
            vetorAux2[i]=0;
        }
        
        int p = tamanhodaHeap * 80;
        p = p/100;
        this.percentual=p;
        
        segmentos novo = new segmentos(0, tamanhodaHeap);
        livres.add(novo);
        
        this.vetor=vetorAux;
        this.vetorNaoatendi=vetorAux2;
    }
    
    public void somarPosicoesLivres()
    {
        int soma = 0;
        int tamanho = livres.size();
        
        for(int i = 0; i<tamanho; i++){
            segmentos s = livres.get(i);
            soma = soma + s.tamanho;
        }
        
        
            this.somatorio = this.somatorio + soma;
        
    }
    
    public void imprimir()
    {
        System.out.println("Esse é o meu vetor depois de ter inserido todos elementos :D");
        for(int i =0;i<tamanhodaHeap;i++){
            System.out.println("["+i+"]="+vetor[i]);
        }
    }
    
    public void naoatendi()
    {
        System.out.println("Os que nao atendi é:");
        for(int i = 0; i< contador;i++){
            System.out.println("["+i+"]="+vetorNaoatendi[i]);
        }
    }


}
