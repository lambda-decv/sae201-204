package jfreetest;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author narut
 */
public class Fenetre extends JFrame implements ActionListener{
    JMenu Menu;
    JMenuItem graph1,graph2;

    public Fenetre(){
        this.setTitle("suyce");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400,400));

        init();

        graph1.addActionListener(this);
        graph2.addActionListener(this);
        this.setVisible(true);
    }

    public void init(){
        JPanel pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;

        JMenuBar MenuBar=new JMenuBar();
        Menu= new JMenu("Pizza");
        graph1=new JMenuItem("Camenbert");
        graph2=new JMenuItem("Histogramme");
        Menu.add(graph1);
        Menu.add(graph2);
        MenuBar.add(Menu);
        this.setJMenuBar(MenuBar);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==graph1){
            jfreetest.Camenbert b =new jfreetest.Camenbert();
            b.setVisible(true);

        }
        if(e.getSource()==graph2){
            jfreetest.Histogramme b =new jfreetest.Histogramme();
            b.setVisible(true);
        }
    }
}
