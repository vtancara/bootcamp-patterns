package singleton;

import java.sql.*;


public class PostgresDBClient {
    public static PostgresDBClient client = null;
    public static Connection postgresClient;
    private PostgresDBClient()
    {
        System.out.println("no se ve ni cuando entra : ");
        try
        {
            String url = "jdbc:postgres://localhost:5432/postgresAutomatizacion";
            String user = "vtancara";
            String pass = "postgres";
            try {
                System.out.println("11111 : " + postgresClient);
                Class.forName("org.postgresql.Driver");
                postgresClient = DriverManager.getConnection(url, user, pass);
                System.out.println("22222 : " + postgresClient);
            } catch (ClassNotFoundException e) {
                System.out.println("Database Connection Creation Failed : " + e.getMessage());
            }
        }
        catch( SQLException me)
        {
            me.getStackTrace();
        }
    }
    public static PostgresDBClient getClient()
    {
        if (client == null){
            System.out.println("Primera vez");
            client = new PostgresDBClient();
            System.out.println("cuando finaliza : " + client);
        }
        return client;
    }

    public String getData(){
        String SQL = "SELECT * FROM conection";
        System.out.println("clienteData : " + postgresClient);
        try( Connection conn = postgresClient;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            return rs.toString();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "No se encontraron datos.";
    }

}
