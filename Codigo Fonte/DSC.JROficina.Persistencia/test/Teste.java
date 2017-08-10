
import DSC.JROficina.Aplicacao.Compra;
import DSC.JROficina.Aplicacao.Fornecedor;
import DSC.JROficina.Aplicacao.Peca;
import DSC.JROficina.Aplicacao.StatusTransacao;
import DSC.JROficina.Persistencia.CompraDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class Teste {
      public static void main(String args[]) throws ClassNotFoundException, SQLException{
          CompraDAO d = new CompraDAO();
          Compra c = new Compra();
          Fornecedor f = new Fornecedor();
          f.setId(14);
          f.setNome("Dois Irmaos Moto Pecas");
          c.setAliado(f);
          c.setData(null);
          c.setParcelas(5);
          c.setStatus(StatusTransacao.Pago);
          c.setValor(100);
          c.setVencimento(null);
          
          Peca x = new Peca();
          x.setId(1);
          List<Peca> l = new ArrayList<>();
          l.add(x);
          c.setPecas(l);
          if(d.Salvar(c)){
              System.out.println("Salvo");
          }else{
              System.out.println("Se fudeu");
          }
          
          
      }
}
