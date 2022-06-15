package main;

import database.Db;
import window.FenetreStat;

import java.sql.*;
import java.time.Instant;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FenetreStat b=new FenetreStat();

        LocalTime time;
        String host = "192.168.149.199:5432/sae";
        String username = "administrator";
        String password = "admin";

        Db bdd = new Db(host,username,password);
        String request;
        double temp;

        for(int i=0;i<100;i++){
                time = java.time.LocalTime.now();
                temp = Math.random()*40;
                request = "INSERT INTO temperature VALUES(" +i+ ",'" +time+ "'," + temp +");";
            System.out.println(request);
                bdd.makeQuery(request,0 );
                b.updateDataset(temp,i);
                Thread.sleep(2000);
        }
    }
}
