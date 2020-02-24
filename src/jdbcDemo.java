
import java.sql.*;
@SuppressWarnings("ALL")
public class jdbcDemo {
    private String url = "jdbc:mysql://localhost:3306/sakila";
    private String user = "akmal";
    private String password = "";
    public jdbcDemo(){

    }
    public static void main(String[] args) {
        jdbcDemo jdbcDemo1 = new jdbcDemo();
        jdbcDemo1.removeData();
    }
    public void getData(){
        try{
            // 1. get a connection
            Connection myConn = DriverManager.getConnection(url, user, password);

            //2. create a statement

            Statement myStmt = myConn.createStatement();
            //3. execute sql query
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM sakila.actor;");

            // 4. process result
            while (myRs.next()){
                System.out.println("first name: " + myRs.getString("first_name") +
                        "last name:" + myRs.getString("last_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void insertData(){
        try{
            // 1. get a connection
            Connection myConn = DriverManager.getConnection(url, user , password);

            //2. create a statement

            Statement myStmt = myConn.createStatement();
            //3. execute sql query
            String sql  = "INSERT INTO actor "
                    + " (first_name, last_name)"
                    + "VALUES ( 'ak', 'miah')";

            myStmt.executeUpdate(sql);

            System.out.println("insert complete");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateData(){
        try {
            // 1. get a connection
            Connection myConn = DriverManager.getConnection(url, user, password);

            // 2. create a statement
            Statement myStmt = myConn.createStatement();

            // 3. execute sql statement
            String sql = "UPDATE actor "
                    + " set first_name='imrane!!',last_name='sudovbwe'"
                    + " WHERE actor_id=201";
            myStmt.executeUpdate(sql);

            System.out.println("update complete");


        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void removeData(){

        try {
            // 1. get a connection
            Connection myConn = DriverManager.getConnection(url, user, password);

            // 2. create a statement
            Statement myStmt = myConn.createStatement();

            // 3. execute sql statement
            String sql = "DELETE from actor WHERE last_name='sudovbwe'";
            int rowsAffected = myStmt.executeUpdate(sql);

            System.out.println("rows affected: " + rowsAffected);
            System.out.println("delete complete");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
