// situa em qual package ou ?pacote? está a classe 
package controlador;
// faz as importações de classes necessárias para o funcionamento do programa 

import java.sql.Connection;
// conexão SQL para Java 
import java.sql.DriverManager;
// driver de conexão SQL para Java 
import java.sql.SQLException;
// classe para tratamento de exceções 

public class ConnectionDB {

    public Connection getConnection() {
        try {
            String 
                    DBServer = "jdbc:mysql://localhost/bdlivros",
                    user = "root",
                    pass = "";
            
            return DriverManager.getConnection(DBServer, user, pass);
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
