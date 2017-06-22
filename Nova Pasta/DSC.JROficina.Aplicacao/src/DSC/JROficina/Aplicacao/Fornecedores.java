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
public class Fornecedores extends Pessoa{
    private String cnpj;

    public Fornecedores(String nome, String telefone, int id, String endereco, String cnpj) {
        super(nome, telefone, id, endereco);
        this.cnpj = cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
    
    
    
    
  
    
    
}
