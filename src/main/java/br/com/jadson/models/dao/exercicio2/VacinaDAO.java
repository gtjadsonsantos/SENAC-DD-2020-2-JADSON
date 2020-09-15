package br.com.jadson.models.dao.exercicio2;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import br.com.jadson.database.Banco;
import br.com.jadson.models.vo.exercicio2.VacinaVO;

public class VacinaDAO {

    private DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public int criar(VacinaVO vacinaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        String query = "INSERT INTO VACINAS (NOME_VACINDA,NOME_PESQUISADOR_RESP,PAIS_ORIGEM,EST_PESQUISA,DT_INICIO_PESQUISA) VALUES ('"
                + vacinaVO.getNomeVacina() + "','" + vacinaVO.getNomePesquisador() + "','" + vacinaVO.getPaisOrigem()
                + "','" + vacinaVO.getEst_pesquisa() + "','" + vacinaVO.getDtInicioPesquisa() + "')";

        try {
            resultado = stmt.executeUpdate(query);
            System.out.println("Sucesso em efetuar o cadastro da vacina");
        } catch (SQLException e) {
            System.out.println("Erro ao efetuar o cadastro da vacina");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;
    }

    public int atualizar(VacinaVO vacinaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        String query = "UPDATE VACINAS SET NOME_VACINDA='" + vacinaVO.getNomeVacina() + "',NOME_PESQUISADOR_RESP='"
                + vacinaVO.getNomePesquisador() + "',PAIS_ORIGEM='" + vacinaVO.getPaisOrigem() + "',EST_PESQUISA='"
                + vacinaVO.getEst_pesquisa() + "',DT_INICIO_PESQUISA='" + vacinaVO.getDtInicioPesquisa() + "'"
                + "WHERE VACINAID=" + vacinaVO.getId();

        try {
            resultado = stmt.executeUpdate(query);
            System.out.println("Sucesso em efetuar o atualizar vacina");
        } catch (SQLException e) {
            System.out.println("Erro ao efetuar o atualizar vacina");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;

    }

    public int deletar(VacinaVO vacinaVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;

        String query = "DELETE FROM VACINAS WHERE VACINAID=" + vacinaVO.getId();

        try {
            resultado = stmt.executeUpdate(query);
            System.out.println("Sucesso em efetuar o deletar vacina");
        } catch (SQLException e) {
            System.out.println("Erro ao efetuar o deletar vacina");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return resultado;

    }

    public ArrayList<VacinaVO> buscar() {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        ArrayList<VacinaVO> listaVacinaVO = new ArrayList<VacinaVO>();

        String query = "SELECT VACINAID,NOME_VACINDA,NOME_PESQUISADOR_RESP,PAIS_ORIGEM,EST_PESQUISA,DT_INICIO_PESQUISA FROM VACINAS ";

        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                VacinaVO vacina = new VacinaVO();

                int id = Integer.parseInt(resultado.getString(1));
                String nomeVacina = resultado.getString(2);
                String nomePesquisador = resultado.getString(3);
                String paisOrigem = resultado.getString(4);
                String est_pesquisa = resultado.getString(5);
                LocalDate dtInicioPesquisa = LocalDate.parse(resultado.getString(6));


                vacina.setId(id);
                vacina.setNomePesquisador(nomePesquisador);
                vacina.setNomeVacina(nomeVacina);
                vacina.setPaisOrigem(paisOrigem);
                vacina.setEst_pesquisa(est_pesquisa);
                vacina.setDtInicioPesquisa(dtInicioPesquisa);

                listaVacinaVO.add(vacina);

            }

            System.out.println("Sucesso em efetuar o buscar vacina");
        } catch (SQLException e) {
            System.out.println("Erro ao efetuar o buscar vacina");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }

        return listaVacinaVO;

    }
}