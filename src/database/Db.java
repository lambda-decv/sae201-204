package database;

import java.sql.*;

public class Db {
    private String username;
    private String password;
    private String host;
    Statement stmt;

    public Db(String username, String password) {
        this.host = "jdbc:mariadb://iutbg-lamp.univ-lyon1.fr:3306/EDT";
        this.username = username;
        this.password = password;


        Connection co = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            //Class.forName("org.postgresql.Driver");
            co = DriverManager.getConnection(host, username, host);

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
            while (res.next()) {
                for (int i = 0; i < returnQueryElement; i++) {
                    if (i >= returnQueryElement) {
                        returnValue += res.getString(i);
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
