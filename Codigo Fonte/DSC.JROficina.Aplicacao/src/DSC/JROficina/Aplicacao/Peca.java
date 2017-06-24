/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSC.JROficina.Aplicacao;

/**
 *
 * @author Rodrigo
 */
public class Peca implements Entidade{

    private int id;
    private String desc;
    private int qtde;
    private float valor_compra;
    private float valor_venda;
    Fornecedores fornecedor;

    public String getDesc() {
        return desc;
    }

    public int getQtde() {
        return qtde;
    }

    public float getValor_compra() {
        return valor_compra;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public void setValor_compra(float valor_compra) {
        this.valor_compra = valor_compra;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    public Peca(int id, String desc, int qtde, float valor_compra, float valor_venda, Fornecedores fornecedor) {
        this.id = id;
        this.desc = desc;
        this.qtde = qtde;
        this.valor_compra = valor_compra;
        this.valor_venda = valor_venda;
        this.fornecedor = fornecedor;
    }
}
