
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
    
    
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho * 256; //Porque 256? Como cada BLOCO do meu vetor equivale a 1k, ou seja, 1024 bits. 
        //1 palavra contém 4 bytes, logo, 1k equivale a 1024/4=256 palavras
        int[] vector = new int[this.tamanho];
        int[] aux = new int[this.tamanho];
        this.quantidade = 0;
    //    System.out.println("Tamanho é:"+this.tamanho);
        
        for(int i=0; i<this.tamanho; i++)
        {
            vector[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
            aux[i] = 0;
    //        System.out.println("Valor do vector é:"+vector[i]);
        }
     //   System.out.println("Sai do FOR");
        this.vetor = vector;
        this.alocados = aux;
     //   System.out.println("PASSEi");
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade + 1;
    }

   public void inserirHeap(int max, FilaCircular fila)
   {
       int requisicao = 0;
       requisicao = fila.removerFilaC();
    
//   System.out.println("Valor é"+vetor.length);
       if(quantidade == max || quantidade == this.tamanho) //cheguei no meu limiar máximo ou minha heap ta lotada
       {
        //   System.out.println("Não to conseguindo acessar, Andrelise DÃÃÃ");
            retiraHeap(requisicao);
           //não posso inserir, preciso desalocar
       }else{//caso contrário, verifico se 
           //a minha insrção tem espaço livre
           //se sim onde tiver espaços livres eu coloco, logo, preciso guardar a referência dessa requisição
           //para dps desalocar
           
           
        //   System.out.println("O valor da minha requisição é:"+requisicao);
           
           int posicao = 0;
           int verifica = 1;
           int controleEntrada = 0;
           int pos = 0;
           
           int[] auxAlocados = new int[this.tamanho];
           int[] auxVetor = new int[this.tamanho];
        
           for (int i = 0; i < this.tamanho; i++) { //inicializo meus vetores
               auxAlocados[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
               auxVetor[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
           }   

           for (int i = 0; i < this.tamanho; i++) { //inicializo meus vetores
               auxAlocados[i] = this.alocados[i];//não tenho nada então 0, quando tiver é 1 :)
               auxVetor[i] = this.vetor[i];//não tenho nada então 0, quando tiver é 1 :)
           }   
           
            while(verifica != 0)
            {
            //    System.out.println("Entrei to no while");
                if(this.vetor[posicao] == 1)
                {
                    //tem algo alocado aqui
                    posicao++;
                    System.out.println("Saiu do teu controle, Andrelise foi mals= "+posicao);
                }
                else if(this.vetor[posicao] == 0) {
                    pos = posicao;
                    for(int i = 0; i<requisicao;i++)
                    {
                //        System.out.println("Entrei nessa maluquice");
                        auxVetor[pos] = 1;
                        controleEntrada = 1;
                        pos++;
//                        if(this.quantidade == 0)
//                        {
//                            //primeiro elemento
//                            auxAlocados[0] = requisicao;
//                            setQuantidade(0);
//                        }
//                        else{
//                            auxAlocados[this.quantidade] = requisicao;
//                            setQuantidade(this.quantidade);
//                        }
                    }
                    if(controleEntrada == 1)
                    {
                        //entrou e tem posição livre
                        if (this.quantidade == 0) {
                            //primeiro elemento
                            auxAlocados[0] = requisicao;
                         //   alocados[0] = requisicao;
                            setQuantidade(0);
                        } else {
                            auxAlocados[this.quantidade] = requisicao;
                          //  alocados[0] = requisicao;
                            setQuantidade(this.quantidade);
                        }
                        controleEntrada = 0;
                    }
                    verifica = 0;
                }
            }
            
            this.vetor = auxVetor;
            this.alocados = auxAlocados;
            
        //    for(int i = 0; i< this.quantidade; i++)
        //    {
        //        System.out.println("Alocado="+this.alocados[i]);
        //    }
            //for(int i = 0; i<this.tamanho; i++)
           // {
           //     System.out.println("Minha heap="+this.vetor[i]);
           // }
           
       }
       
   }

    public int getTamanho() { //vetor da heap
        return tamanho;
    }

    public int getQuantidade() { //vetor dos alocados
        return quantidade;
    }
    
   public void retiraHeap(int x)
   {
       int[] auxAlocados = new int[this.tamanho];
       int[] auxVetor = new int[this.tamanho];
       int retiradoHeap = 0;
       int retiradoAlocados = 0;
       
       for (int i = 0; i < this.tamanho; i++) { //inicializo meus vetores
           auxAlocados[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
           auxVetor[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
       }   

       for (int i = 0; i < this.tamanho; i++) { //inicializo meus vetores
           auxAlocados[i] = this.alocados[i];//não tenho nada então 0, quando tiver é 1 :)
           auxVetor[i] = this.vetor[i];//não tenho nada então 0, quando tiver é 1 :)
       }   
       
       int controle = 0;
       int k =0;
       
       for(int i = 0; i<x; i++)
       {
           int valorRetHeap = auxAlocados[i];
           retiradoHeap = retiradoHeap + valorRetHeap;
               if(controle == 0)
               {
                   for(int j = 0; j < valorRetHeap; j++)
                   {
                       auxVetor[j] = 0;
                   }
                   k = valorRetHeap;
                   controle = 1;
               }else if(controle == 1)
               {
                   for(int j = k; j<valorRetHeap; j++)
                   {
                       auxVetor[j] = 0;
                   }
               }
            auxAlocados[i] = 0;   
            retiradoAlocados = retiradoAlocados + 1;
                
       }
          this.vetor = auxVetor;
          this.alocados = auxAlocados;
          compacta(retiradoHeap, retiradoAlocados);
   }
   
   public void compacta(int v, int a)
   {
       //aqui crio um código que faz a movimentação da minha heap e dos alocados, depois que fiz uma desalocação 
   
       int[] auxAlocados = new int[this.tamanho];
       int[] auxVetor = new int[this.tamanho];

       for (int i = 0; i < this.tamanho; i++) { //inicializo meus vetores
           auxAlocados[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
           auxVetor[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
       }   

       for (int i = 0; i < this.tamanho; i++) { //inicializo meus vetores
           auxAlocados[i] = this.alocados[i];//não tenho nada então 0, quando tiver é 1 :)
           auxVetor[i] = this.vetor[i];//não tenho nada então 0, quando tiver é 1 :)
       }   
       
       for(int i = 0; i<v; i++)
       {
           
         //  auxVetor[i] = 0 ;
          
       }
       
       for(int i = 0; i<a; i++)
       {
           
       //    auxAlocados[i] = 0 ;
          
       }
       
       
        
   }
   
}
