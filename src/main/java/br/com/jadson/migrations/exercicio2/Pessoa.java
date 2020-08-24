package br.com.jadson.migrations.exercicio2;

import java.sql.Connection;
import java.sql.Statement;

import br.com.jadson.database.Banco;

public class Pessoa implements Migration{

    public void run() {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        String sqlContacts = "CREATE TABLE IF NOT EXISTS PESSOAS (PESSOAID INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT,NOME VARCHAR(50),DT_NASCIMENTO DATE,SEXO CHAR,CPF VARCHAR(11),TIPO CHAR )";
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
