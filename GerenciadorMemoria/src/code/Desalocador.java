/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        } catch (IOException ex) {
            Logger.getLogger(Desalocador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void desalocar() throws InterruptedException, IOException{
        
      //  System.out.println("Valor do semaforo desalocador dentro do desaloc="+gestor.d.availablePermits());
        gestor.d.acquire();

//             File arquivo = new File( "arquivoParalelo.txt" );
//
//             PrintWriter escreve = null;
//             FileWriter arq = null;
                     
//            try {
//                //construtor que recebe também como argumento se o conteúdo será acrescentado
//                //ao invés de ser substituído (append)
//                arq = new FileWriter( arquivo, true );
//                escreve = new PrintWriter(arq);
//               
//            } catch (IOException ex) {
//                Logger.getLogger(Alocador.class.getName()).log(Level.SEVERE, null, ex);
//            }

            
        //    gestor.gravarArq.printf("Desalocando %n");

           int t = 0;
           int inicio=0;
       
           segmentos s = gestor.ocupados.get(0);//pega maior
           t = s.getTamanho();
           inicio = s.getInicio();
           //escreve o conteúdo no arquivo
          // escreve.printf("Desalocando...%n");
    //       System.out.println("Desalocando...");
           
        //   escreve.printf("Vou desalocar essa posição da lista: tamanho=%d; e o inicio=%d %n",t,inicio);
       //    System.out.println("Vou desalocar essa posição da lista:");
           
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
        
      //     arq.close();
       
      //     escreve.close();
        
        gestor.a.release();
//        System.out.println("Tchau2");

        
    }
    
}
