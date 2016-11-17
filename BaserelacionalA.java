
package baserelacionala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author julián
 */
public class BaserelacionalA {

    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Oracle o = new Oracle();
        o.conectar();
       // o.insireProduto("p3","tachas",5);

        o.actualizarpre("p2", 120);

        o.borrarFila("p3");
        o.amosarFila("p1");

        o.listar();
        o.conn.close();
    }
}
