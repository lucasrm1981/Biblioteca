// situa em qual package ou ?pacote? est� a classe 
package controlador;
// faz as importa��es de classes necess�rias para o funcionamento do programa 

import java.sql.Connection;
// conex�o SQL para Java 
import java.sql.DriverManager;
// driver de conex�o SQL para Java 
import java.sql.SQLException;
// classe para tratamento de exce��es 

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
