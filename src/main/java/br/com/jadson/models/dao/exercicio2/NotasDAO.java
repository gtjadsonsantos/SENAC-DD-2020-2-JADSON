package br.com.jadson.models.dao.exercicio2;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.jadson.database.Banco;
import br.com.jadson.models.vo.exercicio2.NotasVO;


public class NotasDAO {
    public int criar(NotasVO notasVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        try {
            resultado = stmt.executeUpdate(query);
            System.out.println("Sucesso em efetuar o cadastro da notas");
        } catch (SQLException e) {
            System.out.println("Erro ao efetuar o cadastro da notas");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;
    }

    public int deletar(NotasVO notasVO) {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        String query = "DELETE FROM PESSOAS WHERE PESSOAID = " + notasVO.getId();

        try {
            resultado = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Erro ao executar o deletar notas");
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;
    }

    public int atualizar(NotasVO notasVO) {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

   
        try {
            resultado = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Erro ao executar o atualizar notas");
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;
    }

    public ArrayList<NotasVO> buscar() {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;

        ArrayList<NotasVO> listaPessoasVO = new ArrayList<NotasVO>();

        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar os notas");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return listaPessoasVO;

    }
}