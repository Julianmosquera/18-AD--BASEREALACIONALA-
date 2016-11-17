package baserelacionala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author Julian
 */
public class Oracle {

    final String usuario = "hr";

    private final String pass = "hr";

    private final String sid = "orcl";

    private final String host = "localhost.localdomain";

    private final int puerto = 1521;

    private final String driver = "jdbc:oracle:thin:";

    private final String url = driver + usuario + "/" + pass + "@" + host + ":" + puerto + ":" + sid;

    public final Statement s = null;

    Connection conn;

    public Oracle() throws SQLException {
        this.conn = DriverManager.getConnection(url);
    }

    /**
     * Método para conectarse a la base de datos
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void conectar() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.OracleDriver");

        conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Conexion exitosa!");
        } else {
            System.out.println("Conexion fallida!");
        }

    }

    public void insireProduto(String codigo, String descricion, int prezo) {

        try {

            PreparedStatement hjm = conn.prepareStatement("insert into Productos values (?,?,?)");
            hjm.setString(1, codigo);
            hjm.setString(2, descricion);
            hjm.setInt(3, prezo);
            hjm.executeUpdate();
            hjm.close();
            System.out.println("Insercion realizada");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void listar() throws SQLException {
        Statement li = conn.createStatement();

        String consulta = ("select * from productos");

        ResultSet rs = li.executeQuery(consulta);

        while (rs.next()) {
            System.out.print(rs.getString(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));

        }
        rs.close();
    }

    public void actualizarpre(String codigo, int prezo) throws SQLException {
        Statement li = conn.createStatement();

        li.executeUpdate("update productos set prezo=" + prezo + " where codigo='" + codigo + "'");

        System.out.println("Actualizado");
        conn.commit();

    }

    public void borrarFila(String codigo) throws SQLException {
        Statement state = conn.createStatement();

        state.executeUpdate("delete from productos where codigo='" + codigo + "'");

        conn.commit();

    }

    public void amosarFila(String codigo) throws SQLException {
        Statement li = conn.createStatement();

        String consulta = ("select * from productos where codigo='" + codigo + "'");

        ResultSet rs = li.executeQuery(consulta);

        while (rs.next()) {
            System.out.print(rs.getString(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));

        }
        rs.close();
    }
}
    
    

    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    






    


