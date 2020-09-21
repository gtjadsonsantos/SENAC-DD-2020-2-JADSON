package br.com.jadson.models.dao.exercicio2;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.jadson.database.Banco;
import br.com.jadson.models.vo.exercicio2.PessoaVO;

public class PessoaDAO {
    public int criar(PessoaVO pessoaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        String query = "INSERT INTO PESSOAS (NOME, SEXO,TIPO,CPF,INSTITUICAO) VALUES ('" + pessoaVO.getNome() + "','"
                + pessoaVO.getSexo() + "', '" + pessoaVO.getTipo() + "', '" + pessoaVO.getCpf() + "','"+ pessoaVO.getInstituicao()+"')";

        try {
            resultado = stmt.executeUpdate(query);
            System.out.println("Sucesso em efetuar o cadastro da pessoa");
        } catch (SQLException e) {
            System.out.println("Erro ao efetuar o cadastro da pessoa");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;
    }

    public int deletar(PessoaVO pessoaVO) {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        String query = "DELETE FROM PESSOAS WHERE PESSOAID = " + pessoaVO.getId();

        try {
            resultado = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Erro ao executar o deletar usuario");
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;
    }

    public int atualizar(PessoaVO pessoaVO) {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        String query = "UPDATE PESSOAS SET NOME='" + pessoaVO.getNome() + "',SEXO='" + pessoaVO.getSexo() + "',TIPO="
                + pessoaVO.getTipo() + ",CPF='" + pessoaVO.getCpf() + "', INSTITUICAO='"+ pessoaVO.getInstituicao()+"' WHERE PESSOAID = " + pessoaVO.getId();
        try {
            resultado = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Erro ao executar o atualizar pessoa");
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;
    }

    public ArrayList<PessoaVO> buscar(PessoaVO pessoaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;

        ArrayList<PessoaVO> listaPessoasVO = new ArrayList<PessoaVO>();

        String query = "SELECT PESSOAID, NOME,SEXO,TIPO,CPF,INSTITUICAO FROM PESSOAS WHERE PESSOAID = " + pessoaVO.getId();

        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                PessoaVO pessoa = new PessoaVO();

                pessoa.setId(Integer.parseInt(resultado.getString(1)));
                pessoa.setNome(resultado.getString(2));
                pessoa.setSexo(resultado.getString(3).charAt(0));
                pessoa.setTipo(resultado.getString(4));
                pessoa.setCpf(resultado.getString(5));
                pessoa.setInstituicao(resultado.getString(6));

                listaPessoasVO.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar os usuarios");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return listaPessoasVO;

    }
    public ArrayList<PessoaVO> buscarByTipo(PessoaVO pessoaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;

        ArrayList<PessoaVO> listaPessoasVO = new ArrayList<PessoaVO>();

        String query = "SELECT PESSOAID, NOME,SEXO,TIPO,CPF,INSTITUICAO FROM PESSOAS WHERE TIPO = '"+ pessoaVO.getTipo() + "'";

        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                PessoaVO pessoa = new PessoaVO();

                pessoa.setId(Integer.parseInt(resultado.getString(1)));
                pessoa.setNome(resultado.getString(2));
                pessoa.setSexo(resultado.getString(3).charAt(0));
                pessoa.setTipo(resultado.getString(4));
                pessoa.setCpf(resultado.getString(5));
                pessoa.setInstituicao(resultado.getString(6));

                listaPessoasVO.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar os usuarios");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return listaPessoasVO;

    }
}