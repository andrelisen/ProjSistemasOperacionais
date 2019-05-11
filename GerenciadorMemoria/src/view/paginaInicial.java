
package view;

import code.FilaCircular;
import code.Heap;
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
        jButton3 = new javax.swing.JButton();
        btnHeap = new javax.swing.JButton();
        btnVetReq = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtLimiarMax = new javax.swing.JTextField();
        txtTamHeap = new javax.swing.JTextField();
        btnVerAloc = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jButton7.setText("jButton7");

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

        jButton3.setText("EXECUTAR PARALELAMENTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnHeap.setText("VER HEAP");
        btnHeap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeapActionPerformed(evt);
            }
        });

        btnVetReq.setText("VER VETOR DE REQUISIÇÕES");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("LIMIAR MÁXIMO");

        btnVerAloc.setText("VER ALOCADOS");
        btnVerAloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAlocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumRequi)
                            .addComponent(txtTamMax)
                            .addComponent(txtTamMin)
                            .addComponent(txtLimiarMax)
                            .addComponent(txtTamHeap, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnHeap)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnVerAloc)
                                .addGap(43, 43, 43)
                                .addComponent(btnVetReq))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSequencial)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))))
                .addContainerGap(29, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtLimiarMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnSequencial)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHeap)
                    .addComponent(btnVetReq)
                    .addComponent(btnVerAloc))
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
    Heap vetorHeap = new Heap(); //Lembrando que o tamanho dela é setado pelo usuário
    FilaCircular fila = new FilaCircular();//Essa fila é o meu vetor de requisições
    //As variáveis de que não posso perder as referências
    int RequisicaoMax = 0;
    int RequisicaoMin = 0;
    int numRequisicoes = 0;
    int tamanho = 0;
    int limiarMaximo = 0;
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        //O que acontece se eu clicar em Adicionar dados? Quero que os dados das caixas de texto sejam inseridas em variáveis
        if(txtTamHeap.getText().trim().equals("") || txtTamMin.getText().trim().equals("") || txtTamMax.getText().trim().equals("")
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
            x = txtLimiarMax.getText();
            limiarMaximo = Integer.parseInt(x);
            
            txtTamHeap.setText("");
            txtTamMin.setText("");
            txtTamMax.setText("");
            txtNumRequi.setText("");
            txtLimiarMax.setText("");
            
            vetorHeap.setTamanho(tamanho);
            criarRequisicoes(fila);
            
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso! ");    
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSequencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSequencialActionPerformed
        
        //Inicializo o heap
//        vetorHeap.setTamanho(tamanho);
//        criarRequisicoes(fila);
        vetorHeap.inserirHeap(limiarMaximo, fila);
        JOptionPane.showMessageDialog(null, "Execução sequencial concluída com sucesso! ");    

        
    }//GEN-LAST:event_btnSequencialActionPerformed

    private void btnHeapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeapActionPerformed
        
        for(int i = 0;i<vetorHeap.getTamanho();i++)
        {
            System.out.println("POSIÇÃO="+i+";VALOR="+vetorHeap.vetor[i]);
        }

    }//GEN-LAST:event_btnHeapActionPerformed

    private void btnVerAlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAlocActionPerformed
        
        for(int i = 0;i<vetorHeap.getQuantidade();i++)
        {
            System.out.println("POSIÇÃO="+i+";VALOR="+vetorHeap.alocados[i]);
        }

    }//GEN-LAST:event_btnVerAlocActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    //Manipulação da minha fila, ou seja, geração de valores randomicos para ela
    public static void criarRequisicoes(FilaCircular f)
    { //Inicialmente inicio a fila como cheia 
        int numero = 0;
        Random aleatorio = new Random();
        for(int i = 0; i< 100; i++)
        {
            numero = aleatorio.nextInt(100) + 1;  //random.nextInt((maximo - minimo) + 1) + minimo;
            f.incluirFilaC(numero);
        }
    }
    
    //Para desalocar a memória sempre que o limiar máximo estiver sendo atingido
    /*Sempre durante o tempo em que a ocupação da heap permanecer acima de um
     percentual de limiar máximo (também definido pelo usuário do sistema), um algoritmo de
    desalocação automática deve executar a fim de liberar espaço para as próximas alocações
    de memória.*/
    public void desalocacao(){
        //o mais antigo sai primeiro
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
        
        //Criando uma fila 
//        FilaCircular fila = new FilaCircular(); //Criei uma fila vazia com 100 posições
//        criarRequisicoes(fila);
//        fila.print();
//        Heap p = new Heap();
//        p.setTamanho(10000);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnHeap;
    private javax.swing.JButton btnSequencial;
    private javax.swing.JButton btnVerAloc;
    private javax.swing.JButton btnVetReq;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtLimiarMax;
    private javax.swing.JTextField txtNumRequi;
    private javax.swing.JTextField txtTamHeap;
    private javax.swing.JTextField txtTamMax;
    private javax.swing.JTextField txtTamMin;
    // End of variables declaration//GEN-END:variables
}
