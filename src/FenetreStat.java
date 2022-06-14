import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreStat extends JFrame implements ActionListener {
    JPanel pano;
    GridBagConstraints cont;
    JMenu Menu;
    JMenuItem statBD, statRandom;

    public FenetreStat() {
        this.setTitle("Diagramme");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());



        init();

        statBD.addActionListener(this);
        statRandom.addActionListener(this);
        this.setSize(900,900);
        this.setVisible(true);

    }

    void init() {
        pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        this.setLayout(new GridBagLayout());

        JMenuBar MenuBar = new JMenuBar();
        Menu = new JMenu("Stat génération");
        statBD = new JMenuItem("Données base de données");
        statRandom = new JMenuItem("Données de manière random");
        Menu.add(statBD);
        Menu.add(statRandom);
        MenuBar.add(Menu);
        this.setJMenuBar(MenuBar);

        //cont.gridx=0;
        //cont.gridy=0;
        //ChartPanel a = buildJrand();
        //pano.add(a,cont);
        //cont.gridx=0;
        //cont.gridy=1;
        //ChartPanel aDZ = buildJrand();
        //pano.add(aDZ,cont);

        //cont.gridx=1;
        //cont.gridy=0;
        //ChartPanel aD = buildJrand();
        //pano.add(aD,cont);
        //cont.gridx=1;
        //cont.gridy=1;
        //ChartPanel aCD = buildJrand();
        //pano.add(aCD,cont);

        this.setContentPane(pano);
        this.pack();

    }

    public Color getColor(){
        return new Color((int)(Math.random() * 0x1000000));
    }

    public ChartPanel buildhisto(){

//    Importation des data
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Math.random() * 100000, "Produit 1", "2000");
        dataset.addValue(Math.random() * 100000, "Produit 1", "2001");
        dataset.addValue(Math.random() * 100000, "Produit 1", "2002");
        dataset.addValue(Math.random() * 100000, "Produit 2", "2000");
        dataset.addValue(Math.random() * 100000, "Produit 2", "2001");
        dataset.addValue(Math.random() * 100000, "Produit 2", "2002");
        dataset.addValue(Math.random() * 100000, "Produit 3", "2000");
        dataset.addValue(Math.random() * 100000, "Produit 3", "2001");
        dataset.addValue(Math.random() * 100000, "Produit 3", "2002");

//    Créa du graphique
        JFreeChart barChart = ChartFactory.createBarChart("Evolution des ventes", "YOYOOO",
                "Unité vendue", dataset, PlotOrientation.HORIZONTAL, true, true, true);
        barChart.setTitle("daronne à jules");
        barChart.setBackgroundPaint(Color.red);
        barChart.setBorderPaint(Color.blue);
        barChart.setBorderVisible(true);
        ChartPanel cPanel = new ChartPanel(barChart);
       return cPanel;
    }

    public ChartPanel buildJrand(Color color) {

        DefaultPieDataset pieDatasetC = new DefaultPieDataset();
        pieDatasetC.setValue("Femme", new Integer((int) (Math.random() * 100)));
        pieDatasetC.setValue("Homme", new Integer((int) (Math.random() * 100)));


        JFreeChart pieChart = ChartFactory.createPieChart("Rapport H/F", pieDatasetC, true, true, true);
        ChartPanel cPanel = new ChartPanel(pieChart);

        return cPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == statBD) {
// Aller chercher les stat dans la bd
        }
        if (e.getSource() == statRandom) {
            for (int i = 0; i < 2; i++) {
                for (int y = 0; y < 2; y++) {
                    cont.gridx=i;
                    cont.gridy=y;
                    ChartPanel a = buildhisto();
                    a.setPreferredSize(new java.awt.Dimension(600, 600));
                   // a.setBounds(5*(i*600),5*(y*600),30,30);
                    pano.add(a,cont);
            }
            }
        }
    }
}

