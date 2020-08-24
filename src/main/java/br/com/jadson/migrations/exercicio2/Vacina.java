package br.com.jadson.migrations.exercicio2;

import java.sql.Connection;
import java.sql.Statement;

import br.com.jadson.database.Banco;

public class Vacina implements Migration{

    public void run() {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        String sqlContacts = "CREATE TABLE IF NOT EXISTS VACINAS (VACINAID INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT, NOME_VACINDA VARCHAR(50),NOME_PESQUISADOR_RESP VARCHAR(50), PAIS_ORIGEM VARCHAR(30), EST_PESQUISA VARCHAR(20), DT_INICIO_PESQUISA DATE)";

        try {
            stmt.executeUpdate(sqlContacts);
            System.out.println("[TABELA " + sqlContacts.split(" ")[5] + " ]: PROVISIONADA COM SUCESSO");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            Banco.closePreparedStatement(stmt);
            Banco.closeConnection(conn);
        }
    }
}
