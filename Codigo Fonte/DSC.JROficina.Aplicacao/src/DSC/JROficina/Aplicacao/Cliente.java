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

    /**
     *
     * @param nome
     * @throws ViolacaoRegrasNegocioException
     */
    public void setNomee(String nome) throws ViolacaoRegrasNegocioException{
        if(nome == null)
            throw new ViolacaoRegrasNegocioException("O nome do Cliente não pode ficar vazio!"); 
    
        
        
        char c;
        int cont = nome.length();
            
        //Verificação de numeros e/ou caracteres especiais
        for(int i =0; i<nome.length(); i++){
            c = nome.charAt(i);
            
            if(((c >= 60) && (c <= 90)) || ((c >= 97) && (c<= 122)) || (c == 'á')
            || (c == 'â') || (c == 'ã') || (c == 'Á') || (c == 'Â') || (c == 'Ã')
            || (c == 'ê') || (c == 'é') || (c == 'É') || (c == 'Ê') || (c == 'ó')
            || (c == 'ô') || (c == 'õ') || (c == 'Ó') || (c == 'Ô') || (c == 'Õ')){
              cont++; 
            }
        
        if(cont != nome.length())
            throw new ViolacaoRegrasNegocioException("O nome do Cliente não pode ter numeros e/ou caracteres especiais!");
        
        this.nome = nome;
        }
    }
        
}
