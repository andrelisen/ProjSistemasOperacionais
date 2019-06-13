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
public class alocadorP extends Thread {
    
    HeapParalela heap;
    FilaCircular fila;
    gestorSemaforo gestor;
    
    @Override
    public void run(){
      //  for(;;)
        while(gestor.verificacao ==0)
        {
            gestor.aloc.release();//liberei fiquei com 1
            try {
                gestor.aloc.acquire();//requisitei e peguei 1 e ficou com 0
            } catch (InterruptedException ex) {
                Logger.getLogger(alocadorP.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                inserirHeap();
            } catch (InterruptedException ex) {
                Logger.getLogger(alocadorP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       heap.imprimir();
    }
    
    public alocadorP(HeapParalela heap,FilaCircular fila, gestorSemaforo gestor) {
        this.heap = heap;
        this.fila = fila;
        this.gestor=gestor;
    }
    
   
     public void inserirHeap() throws InterruptedException
   {
       for(int i = 0;i<5;i++)
       {
           System.out.println("Esta no alocador");
       heap.vetor[heap.quantidade]=10;
       heap.quantidade++;
       }
       
       gestor.desaloc.release();
       gestor.aloc.acquire();
        gestor.verificacao=1;
      
//       while(fila.verifica() != true)
//       {
//           synchronized(heap){ //preciso bloquear para não ter inserção na hr da leitura
//           
//           if(heap.quantidadeHeap >= heap.percentualMem)
//           {
//           //Preciso desalocar pois está MUITO ocupada 
//           //Preciso mandar o valor da requisição para poder alocar pois ele retorna direto para o while
//        //   System.out.println("Memória ocupada cerca de 80% da sua capacidade total...");
//           //preciso acordar a thread de desalocação
//           
//          // desalocar();
//           }
//           
//       }
//       
//       
//       
//       segmentos s = heap.livres.get(0);
//       
//       int posicao = 0;
//       posicao = s.getInicio();//posição de inicío de espaços livres
//       int tamanhoDisponivel = 0;
//       tamanhoDisponivel = s.getTamanho();
//     //  System.out.println("Retirado de livres para leitura: ->Tamanho="+tamanhoDisponivel+";->Posicao="+posicao);
//  
//       
//       
//       if(valorReq > tamanhoDisponivel)
//       {
//           //System.out.println("Entrou no valor requisicao maior que tamanho disponivel");
//           if(heap.somatorio>= valorReq){
//              compacta();
//           }else{
//               //mando ela dormir e acordo outra thread
//           //desalocar();
//           }
//           return valorReq;
//       }
//       else{
//           //Posso inserir na heap
//           //removo livre[0] e insiro um novo com as posições livres que sobraram e ordeno
//           //insiro em ocupados e ordeno
//           segmentos novo = new segmentos(posicao, valorReq);
//        
//            if(heap.ocupados.size()==0){
//                heap.ocupados.add(novo);
//            }else{
//                heap.ocupados.add(novo);
//                
//                synchronized(heap){
//                Collections.sort(heap.ocupados);
//                }
//                
//            }
//        
//            
//             for(int i = 0;i<valorReq; i++)
//            {
//           //  System.out.println("**POSICAO="+posicao);
//             heap.vetorHeap[posicao]=1;
//             posicao++;
//             heap.quantidadeHeap++;
//            }
//           
//               int tamNovo = 0;
//               tamNovo = tamanhoDisponivel - valorReq;
//           
//               
//                    s.setInicio(posicao);
//                    s.setTamanho(tamNovo);
//                    heap.livres.set(0, s);
//                    synchronized(heap.livres){
//                    Collections.sort(heap.livres);
//                        
//                    //preciso atualizar meu somatorio
//                    heap.somar();
//                    }
//                    
//      return 0;
//         
//       }
       //}

                //    gs.aloc.acquire();
//                    gs.aloc.release();
     
       //Qual será a métrica para retirar segmentos e alocar eles na lista de segmentos livres? Não posso ter mais de 80% do total da memória ocupada

       //System.out.println("Sua requisicao = "+valorReq);
       /*synchronized (sd) {*/
       
  
   }

//    public void compacta()
//   {
//    
//     //  System.out.println("Compactando................");
//       int soma = 0;
//       int inicio1 = 0;
//       int inicio2 = 0;
//       int contador = 0;
//       
//       synchronized(heap){
//        int tamanhoLivres = heap.livres.size();
//        int tamanhoOcupados = heap.ocupados.size();
//        
//        
//       while(contador < heap.tamanhoTotal)
//        {
//
//                for(int i = 0; i<tamanhoLivres; i++)
//                {
//                   segmentos livre = heap.livres.get(i);
//                   inicio1 = livre.getInicio();
//                   soma = livre.getInicio()+livre.getTamanho();
//                    for(int j = 0; j < tamanhoOcupados; j++)
//                    {
//                       segmentos ocupado = heap.ocupados.get(j);
//                       inicio2 = ocupado.getInicio();
//                       if(soma == ocupado.getInicio() && heap.vetorHeap[ocupado.getInicio()]==1){
//
//                           //System.out.println("Entrei no if");
//
//                           for(int k = 0; k< ocupado.getTamanho();k++){
//                               heap.vetorHeap[inicio1]= heap.vetorHeap[inicio2];
//                               heap.vetorHeap[inicio2]=0;
//                               inicio1++;
//                               inicio2++;  
//                           }
//
//                           livre.setInicio(livre.getInicio()+ocupado.getTamanho());
//                           heap.livres.set(i, livre);
//                           ocupado.setInicio(ocupado.getInicio()-livre.getTamanho());
//                           heap.ocupados.set(j, ocupado);
//
//                       }
//                   }
//               }           
//          contador++;
//       }
//       
//       int novoTamanho = 0;
//       int posicao = heap.tamanhoTotal;
//       
//       for(int k = 0; k < tamanhoLivres; k++)
//       {
//           segmentos s = heap.livres.get(k);
//           if(posicao > s.getInicio())
//           {
//               posicao = s.getInicio();
//           }
//           novoTamanho = novoTamanho + s.getTamanho();
//       }
//      
//       
//       for(int k = 0; k<tamanhoLivres; k++){
//           heap.livres.remove(0);
//       }
//       
//       segmentos novo = new segmentos(posicao, novoTamanho);
//       heap.livres.add(novo);
//       }
//   }
//     
    
    
}
