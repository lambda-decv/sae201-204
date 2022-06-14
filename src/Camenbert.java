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
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.data.general.DefaultPieDataset;


public class Camenbert extends JDialog {
    jfreetest.Fenetre mere;

    public Camenbert() {
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

    public void buildJfree(){
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("Femme", new Integer(75));
        pieDataset.setValue("Homme", new Integer(25));


        JFreeChart pieChart = ChartFactory.createPieChart("Rapport H/F", pieDataset, true, true, true);
        ChartPanel cPanel = new ChartPanel(pieChart);
        this.add(cPanel);
    }


}
