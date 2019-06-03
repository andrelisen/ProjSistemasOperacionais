
package code;

/**
 *
 * @author andrelise
 */
public class FilaCircular {
     //static final int TAMANHO = 100; //Tamanho inicial da fila
     public int TAMANHO = 0;
     private int quantidade=0;
     private Integer[]vetor;    

    public void setTAMANHO(int q) {
        this.TAMANHO = q;
        vetor = new Integer[TAMANHO]; 
    }

     public  boolean isFilaVazia (){
         return quantidade==0;
     }
     
     public boolean isFilaCheia(){
         for (Integer elementoFila : vetor) {
                 if(elementoFila==null){ //Não está cheia
                     return false;
                 }
         }
         return true; //Ela está cheia
     }
     
     public void incluirFilaC (int valor){
      if (isFilaCheia() == false){ 
          int pos=0;
            for (Integer elementoFila : vetor){
                if(elementoFila==null){ //posição livre
                    vetor[pos]=valor;
                    quantidade++;
                break;
                }
             pos++;
            }    
          
      }
      else{
           System.out.println("Não é possível inserir, ela está cheia");
      }      
     }
     
     public int removerFilaC (){
         if(isFilaVazia()){
             System.out.println("Erro fila vazia");
             return 0;
         }else{
             Integer filaNova [] = new Integer [vetor.length-1];
                for (int i = 1; i < vetor.length; i++) {
                    filaNova[i-1]= vetor[i];  
                }
                int valor;
                valor = vetor[0];
                vetor=filaNova;
                quantidade--;
          return valor;
         }
         
     }
     
     public boolean verifica()
     {
         if(quantidade == 0)
         {
             return true;
         }else{
             return false;
         }
     }
     
     public void print() {
      System.out.println("Fila=[inicio=0, fim=" + quantidade + "]");
      for (int i = 0; i < quantidade; i++) {
       System.out.println("Elemento na posição " + i + ", valor:" + vetor[i]);
      }
      System.out.println(" ");

     }
     
}

