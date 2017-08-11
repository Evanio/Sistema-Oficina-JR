/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSC.JROficina.Apresentacao;

import DSC.JROficina.Aplicacao.CompraRepositorio;
import DSC.JROficina.Aplicacao.Compra;
import DSC.JROficina.Aplicacao.Fornecedor;
import DSC.JROficina.Aplicacao.FornecedorRepositorio;
import DSC.JROficina.Aplicacao.Peca;
import DSC.JROficina.Aplicacao.Repositorio;
import DSC.JROficina.Aplicacao.ViolacaoRegrasNegocioException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Rodrigo
 */
public class CompraEditar extends TelaEdicao{
    Repositorio<Peca> p;
    List<Peca> pecas;
    Peca pe;
    SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
    private float tot = 0;
    
    
    FornecedorRepositorio fornecedores = Repositorios.getFornecedorRepositorio();
    
     public CompraEditar() {
        
        initComponents();
        
        entidade = new Compra();
        
        pecas = new ArrayList<>();
        pe = new Peca();
        
        
        List<Fornecedor> lista = fornecedores.Buscar(null);
        
        lista.add(0, null);
        ComboBoxModel modelos = new DefaultComboBoxModel(lista.toArray());
        cbxFornecedor.setModel(modelos); 
        Date data = new Date(System.currentTimeMillis());   
        txtData.setText(String.valueOf(formatarDate.format(data)));
       
        rolParcelas.setValue(1);
     }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxFornecedor = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();
        cbxStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        bntNovaPeca = new javax.swing.JButton();
        btnRemoverPeca = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        rolParcelas = new javax.swing.JSpinner();
        txtVencimento = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bntAdcPeca = new javax.swing.JButton();
        txtUni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtParc = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Compra");

        jLabel1.setText("Fornecedor:");

        jLabel2.setText("Data:");

        jLabel3.setText("Status:");

        cbxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPecas);

        bntNovaPeca.setText("Nova Peça");
        bntNovaPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNovaPecaActionPerformed(evt);
            }
        });

        btnRemoverPeca.setText("Remover Peça");

        jLabel4.setText("Valor Total:");

        jLabel5.setText("Parcelas:");

        jLabel6.setText("Vencimento:");

        txtVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVencimentoActionPerformed(evt);
            }
        });

        jLabel8.setText("Descrição:");

        jLabel9.setText("Valor Unitario:");

        bntAdcPeca.setText("Adicionar Peça");
        bntAdcPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdcPecaActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor Parcela:");

        btnSalvar.setText("Salvar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton3.setText("Apagar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(bntAdcPeca)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bntNovaPeca)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesc))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(btnRemoverPeca)))
                        .addGap(22, 22, 22))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnSalvar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rolParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtParc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnRemoverPeca))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntNovaPeca)
                            .addComponent(jLabel8)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bntAdcPeca)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rolParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtParc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(jButton3))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVencimentoActionPerformed

    private void bntNovaPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNovaPecaActionPerformed
       
        AdcPeca adcpeca = new AdcPeca(new JFrame(), true);
        adcpeca.setVisible(true);
        
        if(adcpeca.isConfirmado()){
            pe = adcpeca.getPecas();
            txtDesc.setText(pe.toString());
            txtUni.setText(String.valueOf(pe.getValor_compra()));
            txtParc.setText(String.valueOf(10));
        }
    }//GEN-LAST:event_bntNovaPecaActionPerformed

    private void bntAdcPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdcPecaActionPerformed
        if(pe != null)
            pecas.add(pe);
        
        preencheTabela(pecas);
        pe = null;
        txtValorTotal.setText(String.valueOf(tot));
        
    }//GEN-LAST:event_bntAdcPecaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAdcPeca;
    private javax.swing.JButton bntNovaPeca;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverPeca;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxFornecedor;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner rolParcelas;
    private javax.swing.JTable tblPecas;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtParc;
    private javax.swing.JTextField txtUni;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JFormattedTextField txtVencimento;
    // End of variables declaration//GEN-END:variables

    @Override
    public void carregaCampos() {
       
    }

    @Override
    public void carregaObjeto() throws ViolacaoRegrasNegocioException {
      
    }

    @Override
    public boolean verificarCamposObrigatorios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void preencheTabela(List<Peca> listagem) {
        DefaultTableModel modelo;
        modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Nome");    
        modelo.addColumn("qtde");
        modelo.addColumn("Valor Unitario ");
        modelo.addColumn("Valor Total");
        
        tot = 0;
        
        
         for(Peca c : listagem){
            Vector linha = new Vector();
            linha.add(c.getId());
            linha.add(c.getNome());
            linha.add(c.getQtde());
            linha.add(c.getValor_compra());
            float total = (c.getQtde() * c.getValor_compra());
            linha.add(total);
            tot += total;
            modelo.addRow(linha);
            
        }    
        tblPecas.setModel(modelo);
        
    }
}
