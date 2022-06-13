package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db {
    private String username;
    private String password;
    private String host;
    Statement stmt;

    Db(String host, String username, String password) {
        if (host.contains("jdbc:mariadb://")) {
            this.host = host;
        } else {
            this.host = "jdbc:mariadb://" + host;
        }
        this.username = username;
        this.password = password;

        try {
            Class.forName("org.mariadb.Driver");
            //Class.forName("org.postgresql.Driver");

            Connection co = DriverManager.getConnection(host, username, host);
            stmt = co.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
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
