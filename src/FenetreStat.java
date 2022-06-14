import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreStat extends JFrame implements ActionListener {

    JButton exit;
    JButton random;
    JButton bd;
    JLabel textCamen;
    JLabel textHisto;

    JPanel pano;
    GridBagConstraints cont;
    private Jours Jours;


    public FenetreStat() {
        this.setTitle("Diagramme");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(128, 150, 138));

        init();

        // statBDHisto.addActionListener(this);
        // statRandomHisto.addActionListener(this);
        // statBDCamen.addActionListener(this);
        // statRandomCamen.addActionListener(this);

        this.setSize(800, 480);
        this.setVisible(true);

    }

    void init() {
        pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        this.setLayout(new GridBagLayout());


        //Graphes
        cont.gridwidth = 3;
        cont.gridheight = 3;


        cont.gridx = 2;
        cont.gridy = 4;
        ChartPanel camenbert = drawnCircu();
        camenbert.setPreferredSize(new java.awt.Dimension(310, 175));
        camenbert.setBorder(new BevelBorder(BevelBorder.RAISED));
        pano.add(camenbert, cont);

        cont.gridx = 9;
        cont.gridy = 4;
        ChartPanel histogram = drawnHisto();
        histogram.setPreferredSize(new java.awt.Dimension(310, 175));
        histogram.setBorder(new BevelBorder(BevelBorder.RAISED));
        pano.add(histogram, cont);

        cont.gridwidth = 12;
        cont.gridheight = 1;
        cont.gridx = 0;
        cont.gridy = 1;
        ChartPanel line= drawnLine();
        line.setPreferredSize(new java.awt.Dimension(200, 200));
        line.setBorder(new BevelBorder(BevelBorder.RAISED));
        pano.add(line, cont);

        //Button
        cont.gridwidth = 1;
        cont.gridheight = 1;


        random = new JButton("Random()");
        cont.gridx = 8;
        cont.gridy = 5;
        pano.add(random, cont);

        cont.gridwidth = 1;
        cont.gridheight = 1;
        bd = new JButton("BD");
        cont.gridx = 8;
        cont.gridy = 6;
        pano.add(bd, cont);


        cont.gridheight = 1;
         exit=new JButton("Fermer");
          cont.gridx=8;
         cont.gridy=7;
         pano.add(exit,cont);

        textCamen = new JLabel("Température max de ces 7 derniers jours");
        textCamen.setBorder(new BevelBorder(BevelBorder.LOWERED));
        cont.gridx = 9;
        cont.gridy = 7;
        pano.add(textCamen, cont);

        textHisto = new JLabel("Taux température de la journée");
        textCamen.setBorder(new BevelBorder(BevelBorder.LOWERED));
        cont.gridx = 2;
        cont.gridy = 7;
        pano.add(textHisto, cont);

        exit.addActionListener(this);
        bd.addActionListener(this);
        random.addActionListener(this);

        this.setContentPane(pano);
        this.pack();
    }



    //Diagramme ligne
    public  ChartPanel drawnLine() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(33, "20", "20"); // (Temp, on s'en fout, seconde)
        dataset.addValue(24, "25", "30");
        dataset.addValue(28, "20", "40");
        dataset.addValue(36, "33", "50");
      JFreeChart chart= ChartFactory.createLineChart("Température actuel","Temps (s)","Température",dataset,PlotOrientation.VERTICAL,true,true,true);
      chart.setBackgroundPaint(new Color(128, 150, 138));
        ChartPanel frame=new  ChartPanel(chart);
        return frame;
    }


    public ChartPanel drawnHisto() {
//    Importation des data
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i=0;i<7;i++) {
            dataset.addValue(15+Math.random() * 25, "<30", "j"+i); //Avec l'enum recup les jours
        }

//    Créa du graphique
        JFreeChart barChart = ChartFactory.createBarChart("évolution de la température", "Jours",
                "Température", dataset, PlotOrientation.VERTICAL, false, true, true);
        barChart.setTitle("Températures");
        barChart.setBackgroundPaint(new Color(128, 150, 138));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

// set the color (r,g,b) or (r,g,b,a)
        renderer.setSeriesPaint(0, new Color(255, 128, 0));
        renderer.setSeriesPaint(1, new Color(0, 128, 0));
        renderer.setSeriesPaint(2, new Color(128,208, 208));
        barChart.setBorderPaint(Color.black);
        barChart.setBorderVisible(true);
        ChartPanel cPanel = new ChartPanel(barChart);
        return cPanel;
    }


    public ChartPanel drawnCircu() {

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("<30", new Integer((int) (Math.random() * 100)));
        pieDataset.setValue("<20", new Integer((int) (Math.random() * 100)));
        pieDataset.setValue("<10", new Integer((int) (Math.random() * 100)));


        JFreeChart pieChart = ChartFactory.createPieChart("Taux température de la journée", pieDataset, true, true, true);
        pieChart.setBackgroundPaint(new Color(128, 150, 138));
        ChartPanel cPanel = new ChartPanel(pieChart);

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setSectionPaint("<30", new Color(255, 128, 0));
        plot.setSectionPaint("<20", new Color(0, 128, 0));
        plot.setSectionPaint("<10", new Color(128,208, 208));


        cPanel.setPreferredSize(new java.awt.Dimension(5, 5));

        return cPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Aller chercher les stat dans la bd
        if (e.getSource() == exit) {
            System.exit(0);

        }
        if (e.getSource() ==random) {
            init();
        }
        if (e.getSource() ==bd) {
            //cont.gridx = 0;
            //cont.gridy = 0;
            //ChartPanel graph = drawnCircu();
            //pano.add(graph, cont);
            //
            //graph.setPreferredSize(new java.awt.Dimension(200, 200));
        }
       // if (e.getSource() ==exit) {
         //   cont.gridx = 0;
           // cont.gridy = 0;
            //ChartPanel graph = buildhisto();
            //pano.add(graph, cont);
            //graph.setPreferredSize(new java.awt.Dimension(200, 200));
       // }
    }
}
