
package code;

/**
 *
 * @author andrelise
 */
   public class FilaCircular {
    static final int TAMANHO = 100; //Tamanho inicial da fila
     private int quantidade=0;
     private Integer[]vetor = new Integer[TAMANHO];     
     
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
      if (isFilaCheia()){ //Verifico se está cheia 
          Integer filaNova [] = new Integer [vetor.length+1]; //Novo vetor auxiliar
          for (int i = 0; i < vetor.length; i++) {
              filaNova[i]= vetor[i];  //Copio valores para ele 
          }
          vetor=filaNova;//vetor antigo ser vetor novo acrescido de 1 unidade[que é o novo valor]
          quantidade++;
          return;
      }
      int pos=0;
       for (Integer elementFila : vetor){
          if(elementFila==null){
              vetor[pos]=valor;
              quantidade++;
              break;
          }
          pos++;
       }    
      
     }
     public int removerFilaC (){
         if(isFilaVazia()){
             System.out.println("Erro fila vazia");
             return 0;
         }
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
     
     public void print() {
      System.out.println("Fila=[inicio=0, fim=" + quantidade + "]");
      for (int i = 0; i < quantidade; i++) {
       System.out.println("Elemento na posição " + i + ", valor:" + vetor[i]);
      }
      System.out.println(" ");

     }
     
}

