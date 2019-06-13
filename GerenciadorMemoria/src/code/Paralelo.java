/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andrelise
 */
public class Paralelo {
    volatile int verifica = 0;
    volatile int tamanho = 0;
    volatile int[]heap = new int[tamanho];
    volatile int quantidade = 0;
    volatile int percentual = 0;
    volatile List<segmentos> ocupados = new ArrayList<segmentos>();  
    volatile List <segmentos> livres = new ArrayList<segmentos>(); 
    volatile FilaCircular fila;

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
        
        int[]aux = new int[tamanho];
        
        for(int i = 0;i<tamanho; i++){
            aux[i]=0;
        }
        this.heap=aux;
        
        segmentos novo = new segmentos(0, tamanho);
        livres.add(novo);
        
        int conta = 0;
        conta = tamanho * 80;
        conta = conta/100;
        this.percentual=conta;
        
    }

    public void setFila(FilaCircular fila) {
        this.fila = fila;
    }
    
     public int somatorio(){
        int soma = 0;
        int t = livres.size();
        
        for(int i = 0; i<t; i++)
        {
            segmentos s = livres.get(i);
            soma = soma + s.getTamanho();
        }
        return soma;
    }
    
    public synchronized void insere() throws InterruptedException {
     
//        System.out.println("------");
//        System.out.println("Minha fila");
//        fila.print();
//        System.out.println("------");
    int requisicao=0;
    
    while(fila.verifica() != true){   
       // System.out.println("Oi");
    requisicao = fila.removerFilaC();
       
       int a = 0; 
       int b = 0;
       
       if(quantidade >= percentual){
           notify();
           wait();
       }
        
       segmentos s = livres.get(0);
       
       int posicao = 0;
       posicao = s.getInicio();//posição de inicío de espaços livres
       int tamanhoDisponivel = 0;
       tamanhoDisponivel = s.getTamanho();
  
       if(requisicao > tamanhoDisponivel)
       {
           while(requisicao > tamanhoDisponivel){
               //System.out.println("Entrou no valor requisicao maior que tamanho disponivel");
               if(somatorio() >= requisicao){
                  compacta();
               }else{
               notify();
               wait();
                  // System.out.println("Entrou p/ notificar");
               }
             //  System.out.println("Vem aqui");            
            s = livres.get(0);
       
            posicao = 0;
            posicao = s.getInicio();//posição de inicío de espaços livres
            tamanhoDisponivel = 0;
            tamanhoDisponivel = s.getTamanho();
  
           }
           
           a=1;
           b=1;
           
       }
        if(a == 0 || a==1 && b ==1){
           //Posso inserir na heap
           //removo livre[0] e insiro um novo com as posições livres que sobraram e ordeno
           //insiro em ocupados e ordeno
           segmentos novo = new segmentos(posicao, requisicao);
        
            if(ocupados.size()==0){
                ocupados.add(novo);
            }else{
                ocupados.add(novo);
                Collections.sort(ocupados);
            }
        
            
             for(int i = 0;i<requisicao; i++)
            {
           //  System.out.println("**POSICAO="+posicao);
             heap[posicao]=1;
             posicao++;
             quantidade++;
            }
           
               int tamNovo = 0;
               tamNovo = tamanhoDisponivel - requisicao;
           
               
                    s.setInicio(posicao);
                    s.setTamanho(tamNovo);
                    livres.set(0, s);
                    Collections.sort(livres);
       }
       
    }
    verifica = 1;
    
        
    }

    public synchronized void remove() throws InterruptedException {
       
       while(verifica == 0){
             //      System.out.println("Tchau");

         int t = 0;
         int inicio=0;
       
           segmentos s = ocupados.get(0);//pega maior
           t = s.getTamanho();
           inicio = s.getInicio();
           //System.out.println("Vou desalocar essa posição da lista: tamanho="+t+";e o inicio="+inicio);

           
           for(int i = 0; i<t; i++)
           {
               heap[inicio] = 0;
               inicio++;
               quantidade--;
           }
       
           livres.add(s);
           Collections.sort(livres);
           
           ocupados.remove(0);
   
           notify();
           wait();
  
       }
    }    
    
   public void compacta()
   {
    
     //  System.out.println("Compactando................");
       int soma = 0;
       int inicio1 = 0;
       int inicio2 = 0;
       int contador = 0;
       
        int tamanhoLivres = livres.size();
        int tamanhoOcupados = ocupados.size();
        
        
       while(contador < tamanho)
        {

                for(int i = 0; i<tamanhoLivres; i++)
                {
                   segmentos livre = livres.get(i);
                   inicio1 = livre.getInicio();
                   soma = livre.getInicio()+livre.getTamanho();
                    for(int j = 0; j < tamanhoOcupados; j++)
                    {
                       segmentos ocupado = ocupados.get(j);
                       inicio2 = ocupado.getInicio();
                       if(soma == ocupado.getInicio() && heap[ocupado.getInicio()]==1){

                           //System.out.println("Entrei no if");

                           for(int k = 0; k< ocupado.getTamanho();k++){
                               heap[inicio1]= heap[inicio2];
                               heap[inicio2]=0;
                               inicio1++;
                               inicio2++;  
                           }

                           livre.setInicio(livre.getInicio()+ocupado.getTamanho());
                           livres.set(i, livre);
                           ocupado.setInicio(ocupado.getInicio()-livre.getTamanho());
                           ocupados.set(j, ocupado);

                       }
                   }
               }           
          contador++;
       }
       
       int novoTamanho = 0;
       int posicao = tamanho;
       
       for(int k = 0; k < tamanhoLivres; k++)
       {
           segmentos s = livres.get(k);
           if(posicao > s.getInicio())
           {
               posicao = s.getInicio();
           }
           novoTamanho = novoTamanho + s.getTamanho();
       }
      
       
       for(int k = 0; k<tamanhoLivres; k++){
           livres.remove(0);
       }
       
       segmentos novo = new segmentos(posicao, novoTamanho);
       livres.add(novo);
       
   }
    
   
    public void imprimirHeap()
    {
        for(int i = 0; i<tamanho;i++)
        {
            //System.out.println("["+i+"]"+"="+vetorHeap[i]);
            System.out.println("["+i+"]="+heap[i]);
        }
    }
   
}
