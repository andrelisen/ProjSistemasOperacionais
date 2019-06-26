
/*
                        //há espaço, mas não é contíguo? compacte a memória!
			compacta();
			// Faltou espaço? envia sinal para o desalocador!
			GestorSemaforos.d.release();
			GestorSemaforos.a.acquire();
			
 */
package code;

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
public class Alocador implements Runnable {

    FilaCircular fila;
    GestorSemaforos gestor;
    
    public Alocador(GestorSemaforos gestor, FilaCircular fila) {
        this.gestor = gestor;
        this.fila = fila;
    }
    
    @Override
    public void run() {
        
        try {
            while(gestor.getVerificacao() == 0){//para poder rodar sempre a thread sem parar
                inserir();
                
            }
        }  catch (InterruptedException ex) {
            Logger.getLogger(Alocador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void inserir() throws InterruptedException {
        
        int valorReq = 0 ;
        int a = 0; 
        int b = 0; 
       
       
        while(fila.verifica()!=true){
       //    gestor.gravarArq.print("Alocando %n ");
            valorReq = fila.removerFilaC();
        //    System.out.println("Valor da requisicao é="+valorReq);
            
            if(gestor.quantidadeHeap >= gestor.percentualMem)
            {
       //     gestor.gravarArq.printf("Entrou no if em que a quantidade de elementos contidos na heap é maior que o meu percentual de elementos que posso ter na "
        //           + "Heap, desaloca! %n ");
         //    System.out.println("Quantidade heap maior");
             gestor.d.release();
         //    System.out.println("Valor do semaforo desalocador="+gestor.d.availablePermits());
             gestor.a.acquire();
         //       System.out.println("seguiu");
            }
            
               segmentos s = gestor.livres.get(0);
       
           int posicao = 0;
           posicao = s.getInicio();//posição de inicío de espaços livres
           int tamanhoDisponivel = 0;
           tamanhoDisponivel = s.getTamanho();
         //  System.out.println("Retirado de livres para leitura: ->Tamanho="+tamanhoDisponivel+";->Posicao="+posicao);



           if(valorReq > tamanhoDisponivel)
           {
              
                   
           //       gestor.gravarArq.printf("Minha requisição é maior do que o tamanho disponível na Heap, desaloca!%n");
                   while(valorReq > tamanhoDisponivel){
                      
                       if(somatorio() >= valorReq){
                             compacta();
                        }else{
                            System.out.println("dentro do while");
                            gestor.d.release();
                            gestor.a.acquire();
                       }
                       
                       s = gestor.livres.get(0);
                       posicao = s.getInicio();//posição de inicío de espaços livres
                       tamanhoDisponivel = 0;
                       tamanhoDisponivel = s.getTamanho();
                     //  System.out.println("O TAMANHO DISPONIVEL="+tamanhoDisponivel);
                   }
                   
                   a = 1;
                   b=1;
           }
           if(a==0 || a == 1 && b == 1){
          //     System.out.println("Inserindo");
               //Posso inserir na heap
               //removo livre[0] e insiro um novo com as posições livres que sobraram e ordeno
               //insiro em ocupados e ordeno
               segmentos novo = new segmentos(posicao, valorReq);

                if(gestor.ocupados.size()==0){
                    gestor.ocupados.add(novo);
                }else{
                    gestor.ocupados.add(novo);
                    Collections.sort(gestor.ocupados);
                }

                System.out.println("Atendendo requisicao="+valorReq);
             //   gestor.gravarArq.printf("Estou inserindo a seguinte requisição= %d %n", valorReq);
                
                 for(int i = 0;i<valorReq; i++)
                {
               //  System.out.println("**POSICAO="+posicao);
                 gestor.vetorHeap[posicao]=1;
                 posicao++;
                 gestor.quantidadeHeap++;
                }

                   int tamNovo = 0;
                   tamNovo = tamanhoDisponivel - valorReq;


                        s.setInicio(posicao);
                        s.setTamanho(tamNovo);
                        gestor.livres.set(0, s);
                        Collections.sort(gestor.livres);

                        a=0;
                        b=0;
           }
           
        }
        
        long t= 0;
       
        if(fila.verifica() == true){
            
        t = System.currentTimeMillis();  
        
        gestor.setTempoFinal(t);
        gestor.setVerificacao(1);
        }
        
        gestor.a.acquire();
    }
    
   
   
        
      public int somatorio(){
        int soma = 0;
        int t = gestor.livres.size();
        
        for(int i = 0; i<t; i++)
        {
            segmentos s = gestor.livres.get(i);
            soma = soma + s.getTamanho();
        }
        return soma;
    }    
        
       public void compacta()
   {
    
     //  System.out.println("Compactando................");
       int soma = 0;
       int inicio1 = 0;
       int inicio2 = 0;
       int contador = 0;
       
        int tamanhoLivres = gestor.livres.size();
        int tamanhoOcupados = gestor.ocupados.size();
        
        
       while(contador < gestor.tamanhoTotal)
        {

                for(int i = 0; i<tamanhoLivres; i++)
                {
                   segmentos livre = gestor.livres.get(i);
                   inicio1 = livre.getInicio();
                   soma = livre.getInicio()+livre.getTamanho();
                    for(int j = 0; j < tamanhoOcupados; j++)
                    {
                       segmentos ocupado = gestor.ocupados.get(j);
                       inicio2 = ocupado.getInicio();
                       if(soma == ocupado.getInicio() && gestor.vetorHeap[ocupado.getInicio()]==1){

                           //System.out.println("Entrei no if");

                           for(int k = 0; k< ocupado.getTamanho();k++){
                               gestor.vetorHeap[inicio1]= gestor.vetorHeap[inicio2];
                               gestor.vetorHeap[inicio2]=0;
                               inicio1++;
                               inicio2++;  
                           }

                           livre.setInicio(livre.getInicio()+ocupado.getTamanho());
                           gestor.livres.set(i, livre);
                           ocupado.setInicio(ocupado.getInicio()-livre.getTamanho());
                           gestor.ocupados.set(j, ocupado);

                       }
                   }
               }           
          contador++;
       }
       
       int novoTamanho = 0;
       int posicao = gestor.tamanhoTotal;
       
       for(int k = 0; k < tamanhoLivres; k++)
       {
           segmentos s = gestor.livres.get(k);
           if(posicao > s.getInicio())
           {
               posicao = s.getInicio();
           }
           novoTamanho = novoTamanho + s.getTamanho();
       }
      
       
       for(int k = 0; k<tamanhoLivres; k++){
           gestor.livres.remove(0);
       }
       
       segmentos novo = new segmentos(posicao, novoTamanho);
       gestor.livres.add(novo);
       
   } 
      
      
}

