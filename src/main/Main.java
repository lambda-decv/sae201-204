package main;

import database.Db;

import java.sql.*;
import java.time.Instant;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Timestamp time;
        String host = "192.168.0.149:5432/sae";
        String username = "administrator";
        String password = "admin";

        Db bdd = new Db(host,username,password);
        String request;
        for(int i=0;i<100;i++){
                time = new Timestamp(System.currentTimeMillis());
                request = "INSERT INTO temperature VALUES(" +i+ ",'" +time+ "'," + Math.random()*40 +");";
                System.out.println(request);
                bdd.makeQuery(request,0 );
                Thread.sleep(2000);
        }
    }
}
