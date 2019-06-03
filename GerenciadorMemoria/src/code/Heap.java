
package code;

/**
 *
 * @author andrelise
 */
public class Heap {
    public int tamanho;
    public int[] vetor = new int[tamanho];
    public int quantidade;
    public int[]alocados = new int[tamanho];
    public int itensNaHeap = 0;    
    
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
       // this.tamanho = tamanho * 256; //Porque 256? Como cada BLOCO do meu vetor equivale a 1k, ou seja, 1024 bits. 
        //1 palavra contém 4 bytes, logo, 1k equivale a 1024/4=256 palavras
        int[] vector = new int[tamanho];
        int[] aux = new int[tamanho];
        this.quantidade = 0;
        
        for(int i=0; i<tamanho; i++)
        {
            vector[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
            aux[i] = 0;
        }
        this.vetor = vector;
        this.alocados = aux;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade + 1;
    }

    public void setItensNaHeap(int item) {
        this.itensNaHeap = this.itensNaHeap + item;
    }

    
    
   public void inserirHeap(int max, FilaCircular fila, int valorReq)
   {
       
//       System.out.println("***Requisição***");
//       System.out.println(valorReq);
//       System.out.println("***");
//       
       //Alocar na heap
       int total = 0;
       total = tamanho - quantidade;
       int percent = 0;
       percent = tamanho * max;
       percent = percent/100;
      // System.out.println("Valor de percentual:"+percent);
       
//       cuidaTamanho = cuidaTamanho + valorReq;
       
       if(percent <= quantidade)
       {
              //limiar maximo atingido. Vamos desalocar
              retiraHeap(percent);
//              System.out.println("Volto para cá");
       }
//       System.out.println("Caio aqui");
       
       if(valorReq < total)
       {//tem espaço livre 
//           System.out.println("Valor da requisicao dentro do if depois da retirada:"+valorReq);
//           System.out.println("E quantidade fica como:"+quantidade);
           for(int i = 0; i < valorReq; i++)
           {
           vetor[quantidade] = 1;
//               System.out.println("Valor aqui dentro="+vetor[quantidade]);
           quantidade++;    
           }
       //    System.out.println("Valor de quantidade:"+quantidade);
       }else{
           System.out.println("Estouro de memória!"); //Não tem espaço livre, desaloco um espaço para ele e não mexo na compactação
        //   controle = 1;
           //preciso guardar essas requisições que NÃO ESTÃO SENDO ALOCADAS POR FALTA DE ESPAÇO
           retiraHeap(percent);
               total = tamanho - quantidade;
               if(valorReq < total)
               {
                   for(int i = 0; i < valorReq; i++)
                   {
                    vetor[quantidade] = 1;
//               System.out.println("Valor aqui dentro="+vetor[quantidade]);
                    quantidade++;    
                   }
               }
       }
      
            //Para guardar quem tá na HEAP
           if(itensNaHeap < tamanho)
           {
               alocados[itensNaHeap] = valorReq;
               itensNaHeap++;
           }else{
               System.out.println("Alocados cheia!!");
           }
         
   }

    public int getTamanho() { //vetor da heap
        return tamanho;
    }

    public int getQuantidade() { //vetor dos alocados
        return quantidade;
    }
    
   public void retiraHeap(int percentual) //desalocar as maiores posições
   {
     int retiradoHeap = 0;//valor do alocados[i]
     int qntHeap = 0;
     int qntAloc = 0;
     
//       System.out.println("---");
//       System.out.println("Vetor antes");
//        for(int i = 0; i< quantidade; i++)
//        {
//            System.out.println("Valor:"+vetor[i]);
//        }
//        System.out.println("Alocados");
//        for(int i = 0; i< itensNaHeap; i++)
//        {
//            System.out.println("Valor aloc:"+alocados[i]);
//        }
//       System.out.println("---");
//     
       //Seleciona quem vai sair 
        for(int i = 0; i< percentual; i++)
        {

            retiradoHeap = alocados[i];
            if(retiradoHeap == 0)
            {
                System.out.println("Espaço vazio!!!!!");
            }else{
//                System.out.println("Retirado foi:"+ retiradoHeap);
                alocados[i] = 0;
                qntAloc++;
                qntHeap = qntHeap + retiradoHeap;   
            } 
        }
      
//        cuidaTamanho = cuidaTamanho - qntHeap;
        
        //Retira da Heap
         for(int j = 0; j < qntHeap; j++)
         {
                    vetor[j] = 0;
         }
        
//         System.out.println("Retirados do vetor de alocados="+qntAloc);
//         System.out.println("Retirados do vetor da Heap="+qntHeap);
//        System.out.println("---");
//        System.out.println("Retirei da Heap:"+qntHeap+" e dos alocados:"+qntAloc);
//        System.out.println("Vetor depois");
//        for(int i = 0; i< quantidade; i++)
//        {
//            System.out.println("Valor:"+vetor[i]);
//        }
//        System.out.println("Alocados");
//        for(int i = 0; i< itensNaHeap; i++)
//        {
//            System.out.println("Valor aloc:"+alocados[i]);
//        }
//       System.out.println("---");
       
       compacta(qntAloc, qntHeap);
       
   }
   
   public void compactaAlocados(int limiar)
   {
       int posicao = 0;
       int qnt = 0;
       
       for(int i = limiar; i<itensNaHeap; i++)
        {
            alocados[posicao] = alocados[i];
            posicao++;
        }
       
        qnt = itensNaHeap - posicao;

        for(int i=0; i< qnt; i++)
        {
            alocados[posicao]=0;
            posicao++;
        }   
       
//        System.out.println("***");
//        System.out.println("Esse é o meu vetor alocados novo:");
//        for(int i = 0; i<itensNaHeap; i++)
//        {
//            System.out.println("ALOCADO["+i+"]="+alocados[i]);
//        }
//        System.out.println("***");
//       
//        System.out.println("Valor de itens na heap:"+itensNaHeap+"Valor do meu limiar:"+limiar);
        itensNaHeap = itensNaHeap - limiar;
//        System.out.println("E o numero de alocados fica como="+itensNaHeap);
        
   }
   
   public void compactaHeap(int limiar)
   {
       int posicao = 0;
       int qnt = 0;
       
       for(int i = limiar; i<quantidade; i++)
        {
            vetor[posicao] = vetor[i];
            posicao++;
        }
       
        qnt = quantidade - posicao;

        for(int i=0; i< qnt; i++)
        {
            vetor[posicao]=0;
            posicao++;
        }   
       
//        System.out.println("***");
//        System.out.println("Esse é o meu vetor alocados novo:");
//        for(int i = 0; i<quantidade; i++)
//        {
//            System.out.println("VETOR["+i+"]="+vetor[i]);
//        }
//        System.out.println("***");
//       
        
        quantidade = quantidade - limiar;
//        System.out.println("E o numero de coisas na heap fica como="+quantidade);
        
       
   }
   
   public void compacta(int retAloc, int retHeap)
   {
       System.out.println("Compacta executando...");
     //  System.out.println("Alocados é "+retAloc+"na heap:"+retHeap);
       compactaAlocados(retAloc);
       compactaHeap(retHeap);
       
//      int posicao = 0;
//      posicao = retAloc;
//      int i = 0;
//      
//      //movimentando o vetor de alocados
//      while(posicao < tamanho)
//      {
//       alocados[i] = alocados[posicao];
//       i++;
//       posicao++;
//      }
//       
//       System.out.println("Valor dos itens no alocados antes:"+itensNaHeap);
//       itensNaHeap = itensNaHeap - retAloc;
//       System.out.println("Valor dos itens no alocados dps:"+itensNaHeap);
//      
//      posicao = 0;
//      posicao = retHeap;
//      i=0;
//      
//      //movimentando a Heap
//      while(posicao < tamanho)
//      {
//          vetor[i] = vetor[posicao];
//          posicao++;
//          i++;
//      }
//      
//       System.out.println("Valor dos itens na heap antes:"+quantidade);
//       quantidade = quantidade - retHeap;
//       System.out.println("Valor dos itens na heap dps:"+quantidade);
   }
   
}
