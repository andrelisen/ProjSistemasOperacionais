/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author andrelise
 */
public class segmentos implements Comparable <segmentos>{
    
        public int inicio;
        public int tamanho;

    public segmentos(int inicio, int tamanho) {
        this.inicio = inicio;
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    
    
    @Override
    public int compareTo(segmentos outroSegmento) {
         //Ordena por ordem decrescente
        if(this.tamanho > outroSegmento.getTamanho())
        {
            return -1;
        } else if(this.tamanho < outroSegmento.getTamanho()){
            return 1;
        }
    
        return 0;
        
    }

        
        
    
}
