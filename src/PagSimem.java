
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Processo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joshua Raiser
 */
public class PagSimem extends javax.swing.JFrame {

    final int NUM_PROPRIEDADES = 4;
    
    List<Processo> Processos;
    

    /**
     * Creates new form PagSimem
     */
    public PagSimem() {
        initComponents();
        Processos = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaFilaProcessos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnImportarArquivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoLog = new javax.swing.JTextArea();
        btnSalvarLogTxt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PagSimem - Simulador de Paginação de Memória");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILA DOS PROCESSOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12))); // NOI18N

        tabelaFilaProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CRIAÇÃO", "REMOÇÃO", "BYTES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFilaProcessos.setFocusable(false);
        tabelaFilaProcessos.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaFilaProcessos.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tabelaFilaProcessos.getTableHeader().setResizingAllowed(false);
        tabelaFilaProcessos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaFilaProcessos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONFIGURAÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12))); // NOI18N

        btnImportarArquivo.setText("importar");
        btnImportarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarArquivoActionPerformed(evt);
            }
        });

        jLabel1.setText("Importar arquivo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImportarArquivo)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImportarArquivo)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MAPA DE MEMÓRIA FÍSICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 0, 12))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        textoLog.setEditable(false);
        textoLog.setColumns(20);
        textoLog.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        textoLog.setLineWrap(true);
        textoLog.setRows(5);
        textoLog.setBorder(null);
        textoLog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoLog.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(textoLog);

        btnSalvarLogTxt.setText(".txt");
        btnSalvarLogTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarLogTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvarLogTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvarLogTxt)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarArquivoActionPerformed
        // TODO add your handling code here:
        JFileChooser abrir = new JFileChooser();
        String caminhoArquivo = "";
        int retorno = abrir.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            caminhoArquivo += abrir.getSelectedFile().getAbsolutePath();
        }
        if (!caminhoArquivo.equals("")) {
            lerArquivo(caminhoArquivo);
        }
    }//GEN-LAST:event_btnImportarArquivoActionPerformed

    @SuppressWarnings("empty-statement")
    private void btnSalvarLogTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarLogTxtActionPerformed
        // TODO add your handling code here:
        /*JFileChooser abrir = new JFileChooser();
        String caminhoArquivo = "";
        int retorno = abrir.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            FileWriter arq = null;
            try {
                arq = new FileWriter(caminhoArquivo);
            } catch (IOException e) {
                textoLog.append("\n\n ** ERRO **: erro inesperado ao tentar salvar o arquivo.\nSaída inesperada: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro inesperado ao tentar salvar o arquivo:\n--:" + e.getMessage().toString(), "Erro - PagSimem - Simulador de Paginação de Memória", JOptionPane.ERROR_MESSAGE);
            }
            PrintWriter gravarArq = new PrintWriter(arq);
        }*/
        
        File arquivo = null;
	JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Arquivo de log PagSimem", "log");
        chooser.setFileFilter(fileFilter);
        
        int resultado = chooser.showSaveDialog(null);;
        if (resultado == JFileChooser.APPROVE_OPTION) 
        {
            File salvarArquivoEscolhido = chooser.getSelectedFile();
            
            arquivo = salvarArquivoEscolhido;
                        
            if (salvarArquivoEscolhido.exists() == true) 
            {
                int selecionaOpcao = JOptionPane.showConfirmDialog(null, " O arquivo já existe, deseja sobrescrevê-lo?", null, JOptionPane.OK_CANCEL_OPTION);
                if (selecionaOpcao == JOptionPane.OK_OPTION) 
                {
                    try {
                        FileWriter fileWriter;
                        fileWriter = new FileWriter (new File(arquivo.getAbsolutePath() + ".log"));
                        try (PrintWriter pw = new PrintWriter(fileWriter)) {
                            pw.format(textoLog.getText());
                            textoLog.append("\n\nArquivo de log salvo em: " + salvarArquivoEscolhido);
                        }
                    } catch (IOException e) {
                        textoLog.append("\n\n ** ERRO **\n\nSaída inesperada: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "\nErro de saída do sistema: " + e.getMessage(), "Erro - PagSimem - Simulador de Paginação de Memória", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else
            {
                try {
                        FileWriter fileWriter;
                        fileWriter = new FileWriter (new File(arquivo.getAbsolutePath() + ".log"));
                    try (PrintWriter pw = new PrintWriter(fileWriter)) {
                        pw.format(textoLog.getText());
                        textoLog.append("\n\nArquivo de log salvo em: " + salvarArquivoEscolhido);
                    }
                } catch (IOException e) {
                        textoLog.append("\n\n ** ERRO **\n\nSaída inesperada: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "\nErro de saída do sistema: " + e.getMessage(), "Erro - PagSimem - Simulador de Paginação de Memória", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarLogTxtActionPerformed

    void lerArquivo(String caminhoArquivo) {
        boolean sucesso = false;
        String conteudoArquivo[] = null;
        try {
            FileReader fileReader = new FileReader(caminhoArquivo);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linhas = "";
            String br;
            while ((br = bufferedReader.readLine()) != null) {
                linhas += br;
            }
            fileReader.close();
            bufferedReader.close();
            conteudoArquivo = linhas.split(Pattern.quote(","));
            textoLog.append("\n\nCarregando arquivo em: " + caminhoArquivo + "\n");
            textoLog.append("* sequencia de dados encontrada: " + linhas);
            sucesso = true;
        } catch (IOException e) {
            textoLog.append("\n\n ** ERRO **: o arquivo selecionado gerou uma saída inesperada do sistema.\nSaída inesperada: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro de arquivo\n--:" + e.getMessage().toString(), "Erro - PagSimem - Simulador de Paginação de Memória", JOptionPane.ERROR_MESSAGE);
        }
        if (sucesso)
        {
            carregarProcessos(conteudoArquivo);
        }
    }
    
    void carregarProcessos(String[] conteudoArquivo)
    {
        int aux = 0;
        try {
            while(aux < conteudoArquivo.length)
            {            
                String ID = conteudoArquivo[aux].toString().trim();
                aux++;
                int tempoC = Integer.parseInt(conteudoArquivo[aux].trim());
                aux++;
                int tempR = Integer.parseInt(conteudoArquivo[aux].trim());
                aux++;
                int bytes = Integer.parseInt(conteudoArquivo[aux].trim());
                aux++;
                Processo processo = new Processo(ID, tempoC, tempR, bytes);
                System.out.println(processo.toString());
                Processos.add(processo);
            }            
        } catch (Exception e)
        {
            // ERRO DE SAÍDA 1
            textoLog.append("\n\n ** ERRO **: o arquivo informado não está no formato corredo para este programa.\nSaída inesperada: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Formato errado de arquivo.\nErro de saída: " + e.getMessage(), "Erro - PagSimem - Simulador de Paginação de Memória", JOptionPane.ERROR_MESSAGE);
        }
            
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(PagSimem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagSimem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagSimem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagSimem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagSimem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImportarArquivo;
    private javax.swing.JButton btnSalvarLogTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaFilaProcessos;
    private javax.swing.JTextArea textoLog;
    // End of variables declaration//GEN-END:variables
}
