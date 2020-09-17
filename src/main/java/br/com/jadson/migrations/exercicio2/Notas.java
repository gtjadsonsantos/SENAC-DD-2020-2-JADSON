package br.com.jadson.migrations.exercicio2;

import java.sql.Connection;
import java.sql.Statement;

import br.com.jadson.database.Banco;

public class Notas implements Migration{

    public void run() {

        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        String sqlContacts = "CREATE TABLE IF NOT EXISTS NOTAS (NOTASID, PESSOAID INTEGER NOT NULL,VACINAID INTEGER NOT NULL, NOTA INTEGER, FOREIGN KEY (PESSOAID) REFERENCES PESSOAS (PESSOAID),FOREIGN KEY (VACINAID) REFERENCES VACINAS (VACINAID))";
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
// PESQUISADOR, INSTITUIÇÃO