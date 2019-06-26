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
public class Desalocador implements Runnable{

    FilaCircular fila;
    GestorSemaforos gestor;
    static long tempo;

    public Desalocador(GestorSemaforos gestor) {
        this.gestor = gestor;
    }
    
    
    @Override
    public void run() {
        
        try {
            while(gestor.getVerificacao() == 0){
            desalocar();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Desalocador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void desalocar() throws InterruptedException{
        
      //  System.out.println("Valor do semaforo desalocador dentro do desaloc="+gestor.d.availablePermits());
            gestor.d.acquire();

        //    gestor.gravarArq.printf("Desalocando %n");

           int t = 0;
           int inicio=0;
       
           segmentos s = gestor.ocupados.get(0);//pega maior
           t = s.getTamanho();
           inicio = s.getInicio();
           //System.out.println("Vou desalocar essa posição da lista: tamanho="+t+";e o inicio="+inicio);

        //   gestor.gravarArq.printf("Desalocando a posição da lista de tamanho = %d e início = %d %n", t, inicio);
           
           for(int i = 0; i<t; i++)
           {
               gestor.vetorHeap[inicio] = 0;
               inicio++;
               gestor.quantidadeHeap--;
           }
       
           gestor.livres.add(s);
           Collections.sort(gestor.livres);
           
           gestor.ocupados.remove(0);
        //   System.out.println("Desalocado com sucesso!!");
        //System.out.println("Valor do semaforo alocador="+gestor.a.availablePermits());
        gestor.a.release();
//        System.out.println("Tchau2");
        
    }
    
    
    
    
}
