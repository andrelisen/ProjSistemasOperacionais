
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
    public int[] vetorHeap = new int[tamanhoTotal];
    public int contador=0;
    public int percentualMem = 0;
    List<segmentos> ocupados = new ArrayList<segmentos>();   //List<String> x = new ArrayList<String>();
    List <segmentos> livres = new ArrayList<segmentos>(); //inicialmente toda a heap está livre
    
    

    public void setTamanho(int tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
       
        int[] vector = new int[tamanhoTotal];
        for(int i = 0; i< tamanhoTotal; i++){
            vector[i]=0;
        }
        
        segmentos novo = new segmentos(0, tamanhoTotal);
        livres.add(novo);
        
         
       this.percentualMem = tamanhoTotal * 80;
       this.percentualMem = this.percentualMem / 100;
        
        this.vetorHeap = vector;
    }

    
    public void imprimirHeap()
    {
        for(int i = 0; i<tamanhoTotal;i++)
        {
            //System.out.println("["+i+"]"+"="+vetorHeap[i]);
            System.out.println(vetorHeap[i]);
        }
    }
    
    public void imprimirLivres()
    {
        for(segmentos s : livres){
            System.out.println("Inicio="+s.getInicio()+";Tamanho="+s.getTamanho());
        }
    }

    public void imprimirOcupados()
    {
        for(segmentos s : ocupados){
            System.out.println("Inicio="+s.getInicio()+";Tamanho="+s.getTamanho());
        }
    }
    
    
   public int inserirHeap(int valorReq)
   {
       //Qual será a métrica para retirar segmentos e alocar eles na lista de segmentos livres? Não posso ter mais de 80% do total da memória ocupada

       System.out.println("Sua requisicao = "+valorReq);
      
//       System.out.println("----------------------------antes------------------");
//       System.out.println("A heap");
//       imprimirHeap();
//       System.out.println("A lista de ocupados");
//       imprimirOcupados();
//       System.out.println("A lista de livres");
//       imprimirLivres();
//       System.out.println("-----------------------fim do antes------------------");
//    
//       if(quantidadeHeap >= percentualMem)
//       {
//           //Preciso desalocar pois está MUITO ocupada 
//           //Preciso mandar o valor da requisição para poder alocar pois ele retorna direto para o while
//           System.out.println("Memória ocupada cerca de 80% da sua capacidade total...");
//          // desalocar();
//       }
       
       segmentos s = livres.get(0);
       
       int posicao = 0;
       posicao = s.getInicio();//posição de inicío de espaços livres
       int tamanhoDisponivel = 0;
       tamanhoDisponivel = s.getTamanho();
       System.out.println("Retirado de livres para leitura: ->Tamanho="+tamanhoDisponivel+";->Posicao="+posicao);
  
       
       
       if(valorReq > tamanhoDisponivel)
       {
           System.out.println("Entrou no valor requisicao maior que tamanho disponivel");
//           if(somatorio() >= valorReq){
//               compacta();
//           }else{
//           desalocar();
//           }
//           
//           return valorReq;
           
       }else{
           //Posso inserir na heap
           //removo livre[0] e insiro um novo com as posições livres que sobraram e ordeno
           //insiro em ocupados e ordeno
          // System.out.println("Consegui inserir tranquilamente na HEAP....");
           segmentos novo = new segmentos(posicao, valorReq);
        //   System.out.println("Meu ocupado novo é=posicao:"+posicao+";tamanho:"+valorReq);
        
            if(ocupados.size()==0){
                ocupados.add(novo);
            }else{
                ocupados.add(novo);
                Collections.sort(ocupados);
            }
        
            
             for(int i = 0;i<valorReq; i++)
            {
             System.out.println("**POSICAO="+posicao);
             vetorHeap[posicao]=1;
             posicao++;
            }
           
               int tamNovo = 0;
               tamNovo = tamanhoDisponivel - valorReq;
           
              if(tamNovo == 0 && posicao == tamanhoTotal)
              {
            //preciso matar esse processo ja que nao tem nd disponivel
                  livres.remove(0);
                  desalocar();
                  System.out.println("Posicao e tamanho igual a total, ja solucionei desalocando o maior elemento");
              }else{
                  System.out.println("Meu novo livre=tamanho:"+tamNovo+";posicao="+posicao);
                    s.setInicio(posicao);
                    s.setTamanho(tamNovo);
                    livres.set(0, s);
                    Collections.sort(livres);
              }
              
         return 0;
         
       }
       
       return 0;
//       System.out.println("----------------------------depois------------------");
//       System.out.println("A heap");
//       imprimirHeap();
//       System.out.println("A lista de ocupados");
//       imprimirOcupados();
//       System.out.println("A lista de livres");
//       imprimirLivres();
//       System.out.println("-----------------------fim do depois------------------");
//    

   }

   
   public int somatorio(){
        int soma = 0;
        for(segmentos s : livres)
        {
            soma = s.getTamanho();
        }
        return soma;
    }
   
   
   public void desalocar()
   {
    //tirar da lista de ocupados e por na lista de livres   
       int t = 0;
       int inicio=0;
       
           segmentos s = ocupados.get(0);//pega maior
           t = s.getTamanho();
           inicio = s.getInicio();
           System.out.println("Vou desalocar essa posição da lista: tamanho="+t+";e o inicio="+inicio);

           
           for(int i = 0; i<t; i++)
           {
               vetorHeap[inicio] = 0;
               inicio++;
           }
       
           livres.add(s);
           Collections.sort(livres);
           
           ocupados.remove(0);
           System.out.println("Desalocado com sucesso!!");

   }
   
   public void compacta()
   {
       int tamanho = 0;
       int inicio = 0;
       int deslocamento = 0;
       int inicioOcupados = 0;
       int cont = 0;
       int verifica = 0;
       int posicao = 0;
      
           for(segmentos s : livres)
           {
               tamanho=s.getTamanho();
               inicio = s.getInicio();
               deslocamento = tamanho + inicio;
               
               for(segmentos oc : ocupados)
               {
                   inicioOcupados = oc.getInicio();
                   if(deslocamento == inicioOcupados)
                   {
                      for(int i = 0;i<oc.getTamanho();i++){
                          System.out.println("Inicio="+inicio);
                          System.out.println("Inicio ocupados="+inicioOcupados);
                          vetorHeap[inicio]=vetorHeap[inicioOcupados];
                          vetorHeap[inicioOcupados] = 0;
                          inicio++;
                          inicioOcupados++;
                      }
                      oc.setInicio(inicioOcupados);
                   }
               }
               posicao = posicao + inicio;
               imprimirHeap();
           }
           
            for(segmentos s : livres)
            {
                tamanho = tamanho + s.getTamanho();
            }

            int r = livres.size();

            for(int i = 0; i<r; i++){
                livres.remove(0);
            }
            
           // segmentos n = new segmentos(posicao, tamanho);
          //  System.out.println("Meu vetorzão de livres é=[T]"+tamanho+"[I]"+posicao);
           

   }
}
