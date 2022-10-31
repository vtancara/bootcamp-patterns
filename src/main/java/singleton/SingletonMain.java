package singleton;

public class SingletonMain {

    public static void main(String[]arg){
        PostgresDBClient postgresDBClient = PostgresDBClient.getClient();
        //System.out.println(postgresDBClient.getData());
        PostgresDBClient postgresDBClient2 = PostgresDBClient.getClient();
        //System.out.println(postgresDBClient2.getData());
        PostgresDBClient postgresDBClient3 = PostgresDBClient.getClient();
        //System.out.println(postgresDBClient3.getData());


    }
}
