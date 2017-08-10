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
public class TranTemItem {
    private int item;
    private int quantidade;
    private int transacao;
    private float valor;

    public TranTemItem(){
        
    }
    
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTransacao() {
        return transacao;
    }

    public void setTransacao(int transacao) {
        this.transacao = transacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
    
}
