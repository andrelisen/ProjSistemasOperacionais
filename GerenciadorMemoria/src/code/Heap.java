
package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andrelise
 */
public class Heap {
    public int tamanhoTotal;
    public int[] vetor = new int[tamanhoTotal];
    public int[] semEspaco = new int[tamanhoTotal];
    public int contador=0;
    public int quantidadeHeap = 0;
    public int posicao = 0;
    List<segmentos> alocados = new ArrayList<segmentos>();   //List<String> x = new ArrayList<String>();
    List <segmentos> livres = new ArrayList<segmentos>(); 
    public int qLivre=0; 
    
    public void setTamanho(int tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
       // this.tamanho = tamanho * 256; //Porque 256? Como cada BLOCO do meu vetor equivale a 1k, ou seja, 1024 bits. 
        //1 palavra contém 4 bytes, logo, 1k equivale a 1024/4=256 palavras
       
        int[] vector = new int[tamanhoTotal];
        int[] sem = new int[tamanhoTotal];
        for(int i = 0; i< tamanhoTotal; i++){
            vector[i]=0;
            sem[i]=0;
        }
                
        this.vetor = vector;
        this.semEspaco = sem;
        this.qLivre = tamanhoTotal;
    }

    public void setquantidadeHeap(int quantidadeHeap) {
        this.quantidadeHeap = quantidadeHeap + 1;
    }

   public void inserirHeap(FilaCircular fila, int valorReq)
   {
       
       //Qual será a métrica para retirar segmentos e alocar eles na lista de segmentos livres? Não posso ter mais lugares ocupados do que livres
       
       //int total = tamanhoTotal - quantidadeHeap;//verifica quem eu tenho disponivel
       int controle = 0;
       if(quantidadeHeap > qLivre){ //um percentual da memória, não necessariamente a metade
           //desalocar o maior segmento
          // System.out.println("Quantidade inseridos é maior do que livres");
         desalocar(quantidadeHeap, qLivre);
       }
// Não posso ver em alocados pq tenho 
//       int x = alocados.size();
//       if(x == 0 )
//       {
//           posicao = 0;
//       }else{
//           x = x - 1;
//           segmentos s = alocados.get(x);
//           posicao = s.getTamanho() + s.getInicio();
//       }
//       
//       System.out.println("Posicao="+posicao+" e o valor da requisicao="+valorReq);
       
       int deslocamento = 0;
       deslocamento = posicao + valorReq;
       
       if(deslocamento >= tamanhoTotal)
       {
           segmentos l = livres.get(0);
           if(l.getTamanho() >= valorReq ){
               posicao =l.getInicio();
               System.out.println("Tive um espaço livre de primeira, e valor da posicao="+posicao);
               
               int subtracao = 0;
               subtracao = l.getTamanho() - valorReq;
               
               if(subtracao == 0)
               {
                   livres.remove(0);
               }else{
                   livres.remove(0);
                   int novoInicio = 0;
                   novoInicio = l.getInicio() + valorReq;
                   segmentos novo = new segmentos(novoInicio, subtracao);
                   livres.add(novo);
                   Collections.sort(livres);
               }
               
           }
           else if( somatorio() >= valorReq){//será que o somatório de lugares livres atende?
               //preciso compactar
               System.out.println("Compactando..");
               controle = 1;
           }
       }
       
       if(controle == 0){
          if(valorReq < qLivre){
           //Tenho espaço livre 
           segmentos s = new segmentos(posicao, valorReq); //guardei em um segmento informações do início da requisição na HEAP
           //e seu tamanho que sigifica até onde a requisição está alocada
               for(int i = 0; i<valorReq; i++){
                   vetor[posicao] = 1; //aloco posições para a requisição
                   quantidadeHeap++;
                   qLivre--;
                   posicao++;
                //   System.out.println("Quantidade ocupada:"+quantidadeHeap+" e a quantidade livre:"+qLivre);

               }
               alocados.add(s); //insiro na lista de elementos alocados na minha heap
               Collections.sort(alocados); //preciso manter minha lista de alocados ordenado por MAIOR tamanho para MENOR dos segmentos alocados na HEAP
           }else{
           //estouro de memória 
         //  System.out.println("Estouro de memória");
         desalocar(valorReq, qLivre);
         inserirHeap(fila, valorReq);
        }
       }

       
   }

   public int somatorio(){
        int soma = 0;
        for(segmentos s : livres)
        {
            soma = s.getTamanho();
        }
        return soma;
    }
   
   public void imprimir()
   {
       System.out.println("---");
        for(segmentos a : alocados){
           System.out.println("inicio:"+a.getInicio()+"e o tamanho="+a.getTamanho());
       }
       System.out.println("---");
      
   }
   
   public void desalocar(int x, int y)
   {
    //tirar da lista de alocados e por na lista de livres   
       System.out.println("Desalocando...");
       segmentos valor;
       int t = 0;
       int inicio=0;
       int p = 0;
       
     
       while(x > y)
       {
           segmentos s = alocados.get(0);
           t = s.getTamanho();
           inicio = s.getInicio();
           segmentos novo = new segmentos(inicio, t);
           alocados.remove(0);
           livres.add(novo);
           
           p=inicio;
           
           for(int i = 0; i<t; i++)
           {
               vetor[p] = 0;
               x--;
               y++;
               quantidadeHeap--;
               qLivre++;
           }
           
       }
    
   }
   
}
