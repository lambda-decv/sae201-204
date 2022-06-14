/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jfreetest;

/**
 *
 * @author narut
 */

import java.awt.*;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class Histogramme extends JDialog {
    jfreetest.Fenetre mere;

    public Histogramme() {
        this.mere=mere;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(750, 600);
        this.setLocationRelativeTo(mere);
        this.setLayout(new GridBagLayout());


        init();

        buildJfree();





    }


    void init(){
//        GridBagConstraints cont = new GridBagConstraints();
//        cont.fill = GridBagConstraints.BOTH;
//      this.setLayout(new GridBagLayout());
//        GridBagConstraints cont = new GridBagConstraints();
//        cont.fill = GridBagConstraints.BOTH;
    }

    void buildJfree(){

//    Importation des data
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(120000.0, "Produit 1", "2000");
        dataset.addValue(550000.0, "Prry-jhyrrt 1", "2001");
        dataset.addValue(180000.0, "Produit 1", "2002");
        dataset.addValue(270000.0, "Produit 2", "2000");
        dataset.addValue(600000.0, "Produit 2", "2001");
        dataset.addValue(230000.0, "Produit 2", "2002");
        dataset.addValue(90000.0, "Produit 3", "2000");
        dataset.addValue(450000.0, "Produit 3", "2001");
        dataset.addValue(170000.0, "Produit 3", "2002");

//    Créa du graphique
        JFreeChart barChart = ChartFactory.createBarChart("Evolution des ventes", "YOYOOO",
                "Unité vendue", dataset, PlotOrientation.HORIZONTAL, true, true, true);
        barChart.setTitle("daronne à jules");
        barChart.setBackgroundPaint(Color.red);
        barChart.setBorderPaint(Color.blue);
        barChart.setBorderVisible(true);
        ChartPanel cPanel = new ChartPanel(barChart);
        this.add(cPanel);
    }

}

