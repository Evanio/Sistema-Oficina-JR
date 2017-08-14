/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSC.JROficina.Apresentacao;

import DSC.JROficina.Aplicacao.Cliente;
import DSC.JROficina.Aplicacao.ClienteRepositorio;
import DSC.JROficina.Aplicacao.MotoRepositorio;
import DSC.JROficina.Aplicacao.Peca;
import DSC.JROficina.Aplicacao.Repositorio;
import DSC.JROficina.Aplicacao.Servico;
import DSC.JROficina.Aplicacao.StatusTransacao;
import DSC.JROficina.Aplicacao.Venda;
import DSC.JROficina.Aplicacao.ViolacaoRegrasNegocioException;
import DSC.JROficina.Aplicacao.Moto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class VendaEditar extends TelaEdicao<Venda>{
    Repositorio<Peca> p;
    List<Peca> pecas;
    List<Servico> servicos;
    Peca pe;
    Servico se;
    SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
    private float tot = 0;
    private Date data;   
    
    ClienteRepositorio clientes = Repositorios.getClienteRepositorio();
    MotoRepositorio motos = Repositorios.getMotoRepositorio();
    
     public VendaEditar() {
        
        initComponents();
        
        pecas = new ArrayList<>();
        servicos = new ArrayList<>();
        pe = new Peca();
        se = new Servico();
        List<Cliente> lista = clientes.Buscar(null);
        lista.add(0, null);
        ComboBoxModel modelos = new DefaultComboBoxModel(lista.toArray());
        cbxCliente.setModel(modelos); 
        data = new Date(System.currentTimeMillis());   
        txtData.setText(String.valueOf(formatarDate.format(data)));
       
        rolParcelas.setValue(1);
        
        entidade = new Venda();
        txtPago.setText("0");
        txtTroco.setText("0");
        pe = new Peca();
        txtTroco.setEnabled(false);
        txtRestante.setEnabled(false);
        txtParc.setEnabled(false);
        txtValorTotal.setEnabled(false);
     }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        txtParc = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnRemoverPeca = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rolParcelas = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtVencimento = new javax.swing.JFormattedTextField();
        txtRestante = new javax.swing.JTextField();
        cbxCliente = new javax.swing.JComboBox<>();
        bntAdcPeca = new javax.swing.JButton();
        txtTroco = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        btnAdcServico = new javax.swing.JButton();
        btnRservico = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxMoto = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setTitle("Venda Editar");

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

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnRemoverPeca.setText("Remover Peça");
        btnRemoverPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPecaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Valor Total:");

        jButton3.setText("Apagar");

        jLabel5.setText("Parcelas:");

        jLabel10.setText("Valor Pago:");

        jLabel6.setText("Vencimento:");

        jLabel1.setText("Cliente");

        jLabel11.setText("Valor Restante:");

        jLabel12.setText("Troco:");

        jLabel2.setText("Data:");

        txtVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVencimentoActionPerformed(evt);
            }
        });

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        bntAdcPeca.setText("Adicionar Peça");
        bntAdcPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdcPecaActionPerformed(evt);
            }
        });

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor Parcela:");

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblServicos);

        btnAdcServico.setText("Adicionar Serviço");
        btnAdcServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdcServicoActionPerformed(evt);
            }
        });

        btnRservico.setText("Remover Servico");
        btnRservico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRservicoActionPerformed(evt);
            }
        });

        jLabel3.setText("Moto");

        cbxMoto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(btnSalvar)
                                .addGap(95, 95, 95)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(231, 231, 231)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtParc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rolParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(21, 21, 21)
                                .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bntAdcPeca)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel12)
                                                .addComponent(btnRemoverPeca)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdcServico)
                            .addComponent(btnRservico))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cbxMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bntAdcPeca)
                        .addGap(53, 53, 53)
                        .addComponent(btnRemoverPeca)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnAdcServico)
                        .addGap(26, 26, 26)
                        .addComponent(btnRservico)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(rolParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtParc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(jButton3))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPecaActionPerformed
        int x = 0;
        x = retornaIdSelecionado();
        Peca k = null;
        for(Peca c : pecas){
            if(c.getId() ==  x)
            k  = c;
        }
        pecas.remove(k);
        preencheTabela(pecas);
        somaTotal();
        if(entidade.getId() != 0)
            this.carregaCampos();
        else
            carregaCampos1();
        
    }//GEN-LAST:event_btnRemoverPecaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVencimentoActionPerformed

    private void bntAdcPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdcPecaActionPerformed
        AdcPeca adcpeca = new AdcPeca(new JFrame(), true);
        adcpeca.setVisible(true);
        pe = null;
        if(adcpeca.isConfirmado()){
            pe = adcpeca.getPecas();
        }

        if(pe != null)
        pecas.add(pe);

        preencheTabela(pecas);
        pe = null;
        txtValorTotal.setText(String.valueOf(tot));

        float x = tot/(Integer)rolParcelas.getValue();
        txtParc.setText(String.valueOf(x));
        somaTotal();
        if(entidade.getId() != 0)
            this.carregaCampos();
        else
            carregaCampos1();

    }//GEN-LAST:event_bntAdcPecaActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void btnAdcServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdcServicoActionPerformed
        AdcServico adcservico = new AdcServico(new JFrame(), true);
        adcservico.setVisible(true);
        se = null;
        if(adcservico.isConfirmado()){
            se = adcservico.getPecas();
        }

        if(se != null)
            servicos.add(se);

        preencheTabela1(servicos);
        se = null;
        txtValorTotal.setText(String.valueOf(tot));

        float x = tot/(Integer)rolParcelas.getValue();
        txtParc.setText(String.valueOf(x));
        somaTotal();
        if(entidade.getId() != 0)
            this.carregaCampos();
        else
            carregaCampos1();
    }//GEN-LAST:event_btnAdcServicoActionPerformed

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed
        Moto m = new Moto();
        m.setDono((Cliente) cbxCliente.getSelectedItem());
        List<Moto> listaa = new ArrayList<>();
        listaa = motos.Buscar(m);
        listaa.add(0, null);
        ComboBoxModel model = new DefaultComboBoxModel(listaa.toArray());
        cbxMoto.setModel(model); 
                
    }//GEN-LAST:event_cbxClienteActionPerformed

    private void btnRservicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRservicoActionPerformed
        int x = 0;
        x = retornaIdSelecionado();
        Servico k = null;
        for(Servico c : servicos){
            if(c.getId() ==  x)
            k  = c;
        }
        servicos.remove(k);
        preencheTabela1(servicos);
        somaTotal();
        if(entidade.getId() != 0)
            this.carregaCampos();
        else
            carregaCampos1();
    }//GEN-LAST:event_btnRservicoActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAdcPeca;
    private javax.swing.JButton btnAdcServico;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverPeca;
    private javax.swing.JButton btnRservico;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxMoto;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner rolParcelas;
    private javax.swing.JTable tblPecas;
    private javax.swing.JTable tblServicos;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtParc;
    private javax.swing.JTextField txtRestante;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JFormattedTextField txtVencimento;
    // End of variables declaration//GEN-END:variables

@Override
    public void carregaCampos() {
        cbxCliente.setSelectedItem(entidade.getAliado());
        cbxMoto.setSelectedItem(entidade.getVeiculo());
        txtData.setText(String.valueOf(formatarDate.format(entidade.getData())));
        txtPago.setText(String.valueOf(entidade.getValor_pago()));
        txtTroco.setText("0");
        txtValorTotal.setText(String.valueOf(entidade.getValor()));
        txtVencimento.setText(String.valueOf(formatarDate.format(entidade.getVencimento())));
        rolParcelas.setValue(entidade.getParcelas());
        preencheTabela(entidade.getPecas());
        pecas = entidade.getPecas();
        if(entidade.getValor() <= entidade.getValor_pago()){
            txtRestante.setText("0");
            txtParc.setText("0");
        }else{ 
            txtRestante.setText(String.valueOf(entidade.getValor() - entidade.getValor_pago()));
            txtParc.setText(String.valueOf((entidade.getValor() - entidade.getValor_pago()) / entidade.getParcelas()));
        }
        
        
        preencheTabela1(entidade.getServicos());
    }

    @Override
    public void carregaObjeto() throws ViolacaoRegrasNegocioException {
           
       entidade.setPecas(pecas);
       entidade.setServicos(servicos);
       entidade.setData(data);       
        try {
            entidade.setVencimento((Date) formatarDate.parseObject(txtVencimento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(CompraEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
       entidade.setValor(Float.valueOf(txtValorTotal.getText()));
       entidade.setValor_parc(Float.valueOf(txtParc.getText()));
       entidade.setParcelas((Integer) rolParcelas.getValue());
       entidade.setAliado((Cliente) cbxCliente.getSelectedItem());
       entidade.setValor_pago(Float.valueOf(txtPago.getText()));
       if(Float.valueOf(txtPago.getText()) >= (Float.valueOf(txtValorTotal.getText())))
           entidade.setStatus(StatusTransacao.PAGO);
       else
           entidade.setStatus(StatusTransacao.PENDENTE);
       entidade.setTipo(2);
       entidade.setVeiculo((Moto) cbxMoto.getSelectedItem());
    }

    @Override
    public boolean verificarCamposObrigatorios() {
        return !txtVencimento.getText().isEmpty() || cbxCliente.getSelectedItem() == null;
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
            double total = (c.getQtde() * c.getValor_compra());
            linha.add(total);
            tot += total;
            modelo.addRow(linha);   
        }    
         
        tblPecas.setModel(modelo);
        
    }
    
    public void preencheTabela1(List<Servico> listagem) {
        DefaultTableModel modelo;
        modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Descricao");    
        modelo.addColumn("Valor");
       
        tot = 0;
       
         for(Servico c : listagem){
            Vector linha = new Vector();
            linha.add(c.getId());
            linha.add(c.getDescricao());
            linha.add(c.getValor());
            double total = c.getValor();
            linha.add(total);
            tot += total;
            modelo.addRow(linha);   
        }    
         
        tblServicos.setModel(modelo);
        
    }
    
    public int retornaIdSelecionado() {
       int linha = tblPecas.getSelectedRow();
       int id = Integer.parseInt(tblPecas.getModel().getValueAt(linha,0).toString());
       return id;
    }
    
    private void somaTotal(){
        tot = 0;
        for(Peca i : pecas)
            tot += i.getValor_venda() * i.getQtde();
        
        for(Servico i : servicos)
            tot += i.getValor();
    }

    public void carregaCampos1() {
       float x = (tot - Float.valueOf(txtPago.getText()));
       int y = (Integer)rolParcelas.getValue();
       txtValorTotal.setText(String.valueOf(tot));
       txtParc.setText(String.valueOf(x / y));
       txtRestante.setText(String.valueOf(x));
       if(Float.valueOf(txtPago.getText()) > tot)
           txtTroco.setText(String.valueOf(x * (-1)));
    }
}
