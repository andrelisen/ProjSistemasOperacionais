
package view;

import code.Aloca;
import code.Desaloca;
import code.FilaCircular;
import code.Heap;
import code.Paralelo;
import code.segmentos;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author andrelise
 */
public class paginaInicial extends javax.swing.JFrame {

    

    public paginaInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jOptionPane1 = new javax.swing.JOptionPane();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTamMin = new javax.swing.JTextField();
        txtTamMax = new javax.swing.JTextField();
        txtNumRequi = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnSequencial = new javax.swing.JButton();
        btnExecParalelamente = new javax.swing.JButton();
        btnHeap = new javax.swing.JButton();
        btnVetReq = new javax.swing.JButton();
        txtTamHeap = new javax.swing.JTextField();
        btnVerOcup = new javax.swing.JButton();
        btnVerDadosIns = new javax.swing.JButton();
        btnTempoExec = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jButton7.setText("jButton7");

        jLabel7.setText("jLabel7");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de memória - Sistemas Operacionais");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("TAMANHO DA HEAP");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("TAMANHO MÁXIMO DA VARIÁVEL DE REQUISIÇÃO");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("TAMANHO MÍNIMO DA VARIÁVEL DE REQUISIÇÃO");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nº DE REQUISIÇÕES DE ALOCAÇÃO ATENDIDAS");

        btnAdicionar.setText("ADICIONAR DADOS");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnSequencial.setText("EXECUTAR SEQUENCIAL");
        btnSequencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSequencialActionPerformed(evt);
            }
        });

        btnExecParalelamente.setText("EXECUTAR PARALELAMENTE");
        btnExecParalelamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecParalelamenteActionPerformed(evt);
            }
        });

        btnHeap.setText("VER HEAP");
        btnHeap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeapActionPerformed(evt);
            }
        });

        btnVetReq.setText("VER VETOR DE REQUISIÇÕES");
        btnVetReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVetReqActionPerformed(evt);
            }
        });

        btnVerOcup.setText("VER OCUPADOS");
        btnVerOcup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOcupActionPerformed(evt);
            }
        });

        btnVerDadosIns.setText("VER DADOS INSERIDOS");
        btnVerDadosIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDadosInsActionPerformed(evt);
            }
        });

        btnTempoExec.setText("VER TEMPO DE EXECUÇÃO");
        btnTempoExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTempoExecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnHeap)
                        .addGap(93, 93, 93)
                        .addComponent(btnVerOcup))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVerDadosIns)
                                    .addComponent(btnAdicionar))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSequencial)
                                    .addComponent(btnTempoExec))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumRequi)
                                    .addComponent(txtTamMax)
                                    .addComponent(txtTamMin)
                                    .addComponent(txtTamHeap, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVetReq)
                                    .addComponent(btnExecParalelamente)))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTamHeap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTamMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTamMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumRequi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnSequencial)
                    .addComponent(btnExecParalelamente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHeap)
                    .addComponent(btnVetReq)
                    .addComponent(btnVerOcup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDadosIns)
                    .addComponent(btnTempoExec))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Criando as minhas estruturas que serão usadas 
    Heap vetorHeap = new Heap(); //Lembrando que o tamanho dela é setado pelo usuário - estrutura sequencial
    FilaCircular fila = new FilaCircular();//Essa fila é o meu vetor de requisições - estrutura sequencial
    FilaCircular filaParalela = new FilaCircular();//Essa fila é o meu vetor de requisições - estrutura paralela
    //As variáveis de que não posso perder as referências
    public  int RequisicaoMax = 0;
    public  int RequisicaoMin = 0;
    public static  int numRequisicoes = 0;
    public  int tamanho = 0;
    public int acerto = 0;
    long inicioSeq = 0;
    long fimSeq = 0;
    long inicioParal = 0;
    long fimParal = 0;
    Paralelo pMonitor = new Paralelo();
    Aloca a = new Aloca(pMonitor);
    Desaloca d = new Desaloca(pMonitor);
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        //O que acontece se eu clicar em Adicionar dados? Quero que os dados das caixas de texto sejam inseridas em variáveis
        if(txtTamHeap.getText().trim().equals("") || txtTamMin.getText().trim().equals("") 
                || txtTamMax.getText().trim().equals("")
                || txtNumRequi.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Há campos de texto vazios. Insira dados!");    
        }else{
            String x = txtTamHeap.getText(); //recebo valor que o usuário inseriu para o tamanho da heap
            tamanho = Integer.parseInt(x);
            vetorHeap.setTamanho(tamanho);
            x = "";//limpo variável
            x = txtTamMin.getText();
            RequisicaoMin = Integer.parseInt(x);
            x = "";
            x = txtTamMax.getText();
            RequisicaoMax = Integer.parseInt(x);
            x = "";
            x = txtNumRequi.getText();
            numRequisicoes = Integer.parseInt(x);
            x = "";
        
            
            txtTamHeap.setText("");
            txtTamMin.setText("");
            txtTamMax.setText("");
            txtNumRequi.setText("");
            
            fila.setTAMANHO(numRequisicoes); //vou atender a essa quantidade - sequencial
            filaParalela.setTAMANHO(numRequisicoes); // - paralela
            criarRequisicoes(fila,filaParalela, RequisicaoMin, RequisicaoMax); //criando fila sequencial e paralela
            
            //Paralelo pMonitor = new Paralelo();
            pMonitor.setTamanho(tamanho);
            pMonitor.setFila(filaParalela);
            a = new Aloca(pMonitor);
            d = new Desaloca(pMonitor);
            
            
            if(RequisicaoMax > tamanho){
                JOptionPane.showMessageDialog(null, "Tamanho de requisicao máximo maior que o permitido. Insira novamente os dados ");
                
            }else{
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso! ");    
                acerto = 1;
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed
       
     
    
    
    private void btnSequencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSequencialActionPerformed
        if(acerto == 1)
        {
            inicioSeq = System.currentTimeMillis();  
   

            int requisicao = 0;
            int verifica = 0;

            while(fila.verifica() != true)// enquanto não estiver vazia
            {

                requisicao = fila.removerFilaC();

                verifica = vetorHeap.inserirHeap(requisicao);

                    while(verifica != 0){
                        verifica = vetorHeap.inserirHeap(requisicao);
                    }
           }
        
            fimSeq  = System.currentTimeMillis();  
            long tempo = fimSeq - inicioSeq;
            JOptionPane.showMessageDialog(null, "Execução sequencial concluída com sucesso! Tempo de="+tempo+"ms");    
        }else{
            JOptionPane.showMessageDialog(null, "Não é possivel executar. Insira novamente os dados"); 
        }
    }//GEN-LAST:event_btnSequencialActionPerformed

    private void btnHeapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeapActionPerformed
        
        System.out.println("---A Heap sequencial---");
        vetorHeap.imprimirHeap();
        System.out.println("---A heap paralela---");
        pMonitor.imprimirHeap();
       
    }//GEN-LAST:event_btnHeapActionPerformed

    private void btnVerOcupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOcupActionPerformed
        System.out.println("Vetor de ocupados é:");
        
        vetorHeap.imprimirOcupados();

    }//GEN-LAST:event_btnVerOcupActionPerformed

    private void btnExecParalelamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecParalelamenteActionPerformed
        
        //isso é minha main
        
        if(acerto == 1)
        {
           
            
            inicioParal = System.currentTimeMillis();  
            a.start();
            d.start();
            fimParal  = System.currentTimeMillis();  
        
            long tempo = fimParal - inicioParal;
            JOptionPane.showMessageDialog(null, "Execução paralela concluída com sucesso! Tempo de="+tempo+"ms");    
//            System.out.println("Sera que a heap foi??");
//            pMonitor.imprimirHeap();
//        
        }else{
            JOptionPane.showMessageDialog(null, "Não é possivel executar. Insira novamente os dados"); 
        }
        
        
    }//GEN-LAST:event_btnExecParalelamenteActionPerformed

    private void btnVetReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVetReqActionPerformed
            
        System.out.println("O vetor de requisições é");
        System.out.println("---Sequencial---");
        fila.print();
        System.out.println("---Paralela---");
        filaParalela.print();
        

    }//GEN-LAST:event_btnVetReqActionPerformed

    private void btnVerDadosInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDadosInsActionPerformed
        System.out.println("******");
        System.out.println("--> O tamanho da HEAP escolhido foi="+tamanho);
        System.out.println("--> Intervalo das requisições é: mínimo="+RequisicaoMin+" máximo="+RequisicaoMax);
        System.out.println("--> Total de requisições geradas="+numRequisicoes);
        System.out.println("******");

    }//GEN-LAST:event_btnVerDadosInsActionPerformed

    private void btnTempoExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTempoExecActionPerformed
        
        long tempoSeq = fimSeq - inicioSeq;
        
        JOptionPane.showMessageDialog(null, "Tempo de execução sequencial é ="+tempoSeq+"ms");    
        
    }//GEN-LAST:event_btnTempoExecActionPerformed

    //Função auxiliar de gerar números
    public static int gerador(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    
    //Manipulação da minha fila, ou seja, geração de valores randomicos para ela
    public static void criarRequisicoes(FilaCircular f1, FilaCircular f2, int min, int max)
    { //Inicialmente inicio a fila como cheia 
        int numero = 0;
       // int total = 0;
       // int j = 0;
        for(int i = 0; i< numRequisicoes; i++)
        {
            numero = gerador(min, max);  //random.nextInt((maximo - minimo) + 1) + minimo;
           // System.out.println("Gerou a seguinte requisição:"+numero);
           // System.out.println("Valor da posicao:"+j);
           // j++;
           // total = total + numero;
            f1.incluirFilaC(numero);
            f2.incluirFilaC(numero);
        }
           // System.out.println("total e:"+total);
    }
    
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(paginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new paginaInicial().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExecParalelamente;
    private javax.swing.JButton btnHeap;
    private javax.swing.JButton btnSequencial;
    private javax.swing.JButton btnTempoExec;
    private javax.swing.JButton btnVerDadosIns;
    private javax.swing.JButton btnVerOcup;
    private javax.swing.JButton btnVetReq;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtNumRequi;
    private javax.swing.JTextField txtTamHeap;
    private javax.swing.JTextField txtTamMax;
    private javax.swing.JTextField txtTamMin;
    // End of variables declaration//GEN-END:variables
}
