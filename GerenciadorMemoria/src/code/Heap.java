
package code;

/**
 *
 * @author andrelise
 */
public class Heap {
    public int tamanho;
    public int[] vetor = new int[tamanho];

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho * 256; //Porque 256? Como cada BLOCO do meu vetor equivale a 1k, ou seja, 1024 bits. 
        //1 palavra contém 4 bytes, logo, 1k equivale a 1024/4=256 palavras
    }
    
   public void inserirHeap(int valor, int posicao)
   {
       this.vetor[posicao] = valor;
   }
    
}
