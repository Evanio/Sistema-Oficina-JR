/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSC.JROficina.Aplicacao;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Compra implements Entidade{

    private int id;
    private double valor;
    private List<Peca> pecas;
    private Pessoa aliado;
    private Date data;
    private StatusTransacao status;
    private int parcelas;
    private double valor_parc; 
    private Date vencimento;

    public Compra(int id, double valor, List<Peca> pecas, Pessoa aliado, Date data, StatusTransacao status) {
        this.id = id;
        this.valor = valor;
        this.pecas = pecas;
        this.aliado = aliado;
        this.data = data;
        this.status = status;
    }
   
    public Compra(){    
    }
    
    
    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValor_parc() {
        return valor_parc;
    }

    public void setValor_parc(double valor_parc) {
        this.valor_parc = valor_parc;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public Pessoa getAliado() {
        return aliado;
    }

    public void setAliado(Pessoa aliado) {
        this.aliado = aliado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
}
