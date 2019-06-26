/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.paginaInicial;

/**
 *
 * @author andrelise
 */
public class GestorSemaforos {
 
	static Semaphore a = new Semaphore(0);
	static Semaphore d = new Semaphore(0);
        public long tempoFinal = 0;
       
        volatile int verificacao = 0;
        public int tamanhoTotal;
        public int[] vetorHeap = new int[tamanhoTotal];
        public int contador=0;
        public int percentualMem = 0;
        public int quantidadeHeap = 0;
        List<segmentos> ocupados = new ArrayList<segmentos>();   //List<String> x = new ArrayList<String>();
        List <segmentos> livres = new ArrayList<segmentos>(); //inicialmente toda a heap está livre
       
        public long getTempoFinal() {
            return tempoFinal;
        }

         public void setTempoFinal(long tempoFinal) {
            this.tempoFinal = tempoFinal;
         }

         public int getVerificacao() {
              return verificacao;
         }

        public void setVerificacao(int verificacao) {
            this.verificacao = verificacao;
        }

        
            
        public void setTamanho(int tamanhoTotal) {
            this.tamanhoTotal = tamanhoTotal;

            int[] vector = new int[tamanhoTotal];
            for(int i = 0; i< tamanhoTotal; i++){
                vector[i]=0;
            }

            segmentos novo = new segmentos(0, tamanhoTotal);
            livres.add(novo);


           this.percentualMem = tamanhoTotal * 80;
           this.percentualMem = this.percentualMem / 100;

           this.vetorHeap = vector;
        }
        
            public void imprimirHeap()
    {
        for(int i = 0; i<tamanhoTotal;i++)
        {
            //System.out.println("["+i+"]"+"="+vetorHeap[i]);
            System.out.println("["+i+"]="+vetorHeap[i]);
        }
    }
    
    public void imprimirLivres()
    {
        System.out.println("---------------------------");
        for(segmentos s : livres){
            System.out.println("Inicio="+s.getInicio()+";Tamanho="+s.getTamanho());
        }
        System.out.println("---------------------------");
    }

    public void imprimirOcupados()
    {
        System.out.println("---------------------------");
        for(segmentos s : ocupados){
            System.out.println("Inicio="+s.getInicio()+";Tamanho="+s.getTamanho());
        }
        System.out.println("---------------------------");
    }
        
    
}
