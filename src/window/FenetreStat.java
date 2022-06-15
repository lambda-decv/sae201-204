package window;

import database.Db;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreStat extends JFrame implements ActionListener,Runnable {
    JButton exit;
    JButton random;
    JButton bd;
    JLabel textCamen;
    JLabel textHisto;

    JPanel pano;
    GridBagConstraints cont;
    JMenu Menu;
    XYSeries data = new XYSeries("Temperature");
    boolean appui = false;
    public FenetreStat() {
        this.setTitle("Diagramme");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(128, 150, 138));
        //this.database = database;

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
        cont.gridx = 0;
        cont.gridy = 0;
        ChartPanel line = drawnLine(data);
        line.setPreferredSize(new java.awt.Dimension(200, 200));
        line.setBorder(new BevelBorder(BevelBorder.RAISED));
        pano.add(line, cont);


        cont.gridheight = 3;
        cont.gridwidth = 1;
        cont.gridx = 0;
        cont.gridy = 1;
        ChartPanel camenbert = drawnCircu();
        camenbert.setPreferredSize(new java.awt.Dimension(310, 175));
        camenbert.setBorder(new BevelBorder(BevelBorder.RAISED));
        pano.add(camenbert, cont);

        cont.gridx = 2;
        cont.gridy = 1;
        ChartPanel histogram = drawnHisto();
        histogram.setPreferredSize(new java.awt.Dimension(310, 175));
        histogram.setBorder(new BevelBorder(BevelBorder.RAISED));
        pano.add(histogram, cont);

        //Button
        cont.gridheight = 1;

        random = new JButton("Random()");
        cont.gridx = 1;
        cont.gridy = 1;
        pano.add(random, cont);

        bd = new JButton("BD");
        cont.gridx = 1;
        cont.gridy = 2;
        pano.add(bd, cont);

        exit = new JButton("Fermer");
        cont.gridx = 1;
        cont.gridy = 3;
        pano.add(exit, cont);

        cont.fill = GridBagConstraints.CENTER;

        textCamen = new JLabel("Température max de ces 7 derniers jours");
        //textCamen.setBorder(new BevelBorder(BevelBorder.LOWERED));
        cont.gridx = 2;
        cont.gridy = 4;
        pano.add(textCamen, cont);

        textHisto = new JLabel("Taux température de la journée");
        //textCamen.setBorder(new BevelBorder(BevelBorder.LOWERED));
        cont.gridx = 0;
        cont.gridy = 4;
        pano.add(textHisto, cont);

        exit.addActionListener(this);
        bd.addActionListener(this);
        random.addActionListener(this);

        this.setContentPane(pano);
        this.pack();
    }


    //Diagramme ligne
    public ChartPanel drawnLine(XYSeries data) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(data);
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Température actuel",
                "Temps (s)",
                "Température",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                true
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);
        chart.setBackgroundPaint(new Color(128, 150, 138));
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        return chartPanel;
    }


    public ChartPanel drawnHisto() {
//    Importation des data
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 7; i++) {
            dataset.addValue(15 + Math.random() * 25, "<30", "m" + i);
        }

//    Créa du graphique
        JFreeChart barChart = ChartFactory.createBarChart(
                "évolution de la température",
                "Jours",
                "Température",
                dataset, PlotOrientation.VERTICAL,
                false,
                true,
                true
        );
        barChart.setTitle("Températures");
        barChart.setBackgroundPaint(new Color(128, 150, 138));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

// set the color (r,g,b) or (r,g,b,a)
        renderer.setSeriesPaint(0, new Color(255, 128, 0));
        renderer.setSeriesPaint(1, new Color(0, 128, 0));
        renderer.setSeriesPaint(2, new Color(128, 208, 208));
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
        plot.setSectionPaint("<10", new Color(128, 208, 208));


        cPanel.setPreferredSize(new java.awt.Dimension(5, 5));

        return cPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Aller chercher les stat dans la bd
        if (e.getSource() == exit) {
            System.exit(0);

        }
        if (e.getSource() == random) {
            init();
        }
        if (e.getSource() == bd) {

        }
        // if (e.getSource() ==exit) {
        //   cont.gridx = 0;
        // cont.gridy = 0;
        //ChartPanel graph = buildhisto();
        //pano.add(graph, cont);
        //graph.setPreferredSize(new java.awt.Dimension(200, 200));
        // }
    }

    public void updateDataset(double temp, int time){
        data.add(time, temp);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread content");
            try{
                Thread.sleep(10000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
