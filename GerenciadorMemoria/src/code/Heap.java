
package code;

/**
 *
 * @author andrelise
 */
public class Heap {
    public int tamanho;
    public int[] vetor = new int[tamanho];
    public int quantidade = 0;
    public int[]alocados = new int[tamanho];
    
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho * 256; //Porque 256? Como cada BLOCO do meu vetor equivale a 1k, ou seja, 1024 bits. 
        //1 palavra contém 4 bytes, logo, 1k equivale a 1024/4=256 palavras
        int[] vector = new int[this.tamanho];
        
    //    System.out.println("Tamanho é:"+this.tamanho);
        
        for(int i=0; i<this.tamanho; i++)
        {
            vector[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
    //        System.out.println("Valor do vector é:"+vector[i]);
        }
     //   System.out.println("Sai do FOR");
        this.vetor = vector;
     //   System.out.println("PASSEi");
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade + 1;
    }

    
    
   public void inserirHeap(int max, FilaCircular fila)
   {
       System.out.println("Valor é"+vetor.length);
       if(vetor.length == max) //cheguei no meu limiar máximo
       {
           System.out.println("Não to conseguindo acessar, Andrelise DÃÃÃ");
           //não posso inserir, preciso desalocar
       }else{//caso contrário, verifico se 
           //a minha insrção tem espaço livre
           //se sim onde tiver espaços livres eu coloco, logo, preciso guardar a referência dessa requisição
           //para dps desalocar
           
           int requisicao = 0;
           requisicao = fila.removerFilaC();
           System.out.println("O valor da minha requisição é:"+requisicao);
           
           int posicao = 0;
           int verifica = 1;
           
           int[] auxAlocados = new int[this.tamanho];
           int[] auxVetor = new int[this.tamanho];
        
           for (int i = 0; i < this.tamanho; i++) { //inicializo meus vetores
               auxAlocados[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
               auxVetor[i] = 0;//não tenho nada então 0, quando tiver é 1 :)
           }   
           
            while(verifica != 0)
            {
                System.out.println("Entrei to no while");
                if(vetor[posicao] == 1)
                {
                    //tem algo alocado aqui
                    posicao++;
                    System.out.println("Saiu do teu controle, Andrelise foi mals ");
                }
                else if(vetor[posicao] == 0) {
                    for(int i = posicao; i<requisicao;i++)
                    {
                        System.out.println("Entrei nessa maluquice");
                        auxVetor[i] = 1;
                        if(this.quantidade == 0)
                        {
                            //primeiro elemento
                            auxAlocados[0] = requisicao;
                            setQuantidade(0);
                        }
                        else{
                            auxAlocados[this.quantidade] = requisicao;
                            setQuantidade(this.quantidade);
                        }
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
    
   
   
}
