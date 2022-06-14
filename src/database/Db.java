package database;

import java.sql.*;

public class Db {
    private String username;
    private String password;
    private String host;
    Statement stmt;

    public Db(String host,String username, String password) {
        this.host = "jdbc:postgresql://" + host;
        this.username = username;
        this.password = password;


        Connection co = null;
        try {
            //Class.forName("org.mariadb.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            co = DriverManager.getConnection(this.host, username, password);

            stmt = co.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public String makeQuery(String query, int returnQueryElement) {
        String returnValue = "";
        try {
            ResultSet res = stmt.executeQuery(query);
            if(returnQueryElement<=0){
                System.out.println("Request successfully executed !");
                return null;
            }
            while (res.next()) {
                for (int i = 1; i <= returnQueryElement; i++) {
                    if (i >= returnQueryElement) {
                        returnValue += res.getString(i) + "\n";
                    } else {
                        returnValue += res.getString(i) + " : ";
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnValue;
    }
}
