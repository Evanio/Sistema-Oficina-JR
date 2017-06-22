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
public class Cliente extends Pessoa{
    private String cpf_cnpj;
    private int tipo;

    public Cliente(String nome, String telefone, int id, String endereco, String cpf_cnpj, int tipo) {
        super(nome, telefone, id, endereco);
        this.tipo = tipo;
        this.cpf_cnpj = cpf_cnpj;
    }
    
    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public int getTipo() {
        return tipo;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    

}
