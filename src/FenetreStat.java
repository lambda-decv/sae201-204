import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreStat extends JFrame implements ActionListener {
    JButton exit;
    JLabel text;
    JPanel pano;
    GridBagConstraints cont;
    JMenu Menu;
    JMenuItem statBD, statRandom, statRandomCamen, statRandomHisto, statBDCamen, statBDHisto;

    public FenetreStat() {
        this.setTitle("Diagramme");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());


        init();

        statBDHisto.addActionListener(this);
        statRandomHisto.addActionListener(this);
        statBDCamen.addActionListener(this);
        statRandomCamen.addActionListener(this);
        exit.addActionListener(this);
        this.setBackground(new Color(0,150,0));
        this.setSize(600, 400);
        this.setVisible(true);

    }

    void init() {
        pano = new JPanel();
        pano.setLayout(new GridBagLayout());
        cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        this.setLayout(new GridBagLayout());


        exit=new JButton("left");
        cont.gridx=3;
        cont.gridy=3;
        pano.add(exit,cont);

        JMenuBar MenuBar = new JMenuBar();
        Menu = new JMenu("Stat génération");
        statBD = new JMenu("Données base de données");
        statRandom = new JMenu("Données de manière random");
        statBDHisto = new JMenuItem("Histogramme");
        statRandomHisto = new JMenuItem("Histogramme");
        statBDCamen = new JMenuItem("Diagramme circulaire");
        statRandomCamen = new JMenuItem("Diagramme circulaire");
        Menu.add(statBD);
        Menu.add(statRandom);
        statBD.add(statBDCamen);
        statBD.add(statBDHisto);
        statRandom.add(statRandomCamen);
        statRandom.add(statRandomHisto);
        MenuBar.add(Menu);
        this.setJMenuBar(MenuBar);

        cont.gridx = 0;
        cont.gridy = 0;
        ChartPanel graph = buildJrand();
        pano.add(graph, cont);
        graph.setPreferredSize(new java.awt.Dimension(400, 200));
      //  MenuBar.setBounds(0, 0, 500, 880);

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


        text = new JLabel("Température ressentie");
        text.setBorder(new BevelBorder(BevelBorder.LOWERED));
        cont.gridx = 2;
        cont.gridy = 0;
        pano.add(text, cont);
        this.setContentPane(pano);
        this.pack();


    }

    public ChartPanel buildhisto() {

//    Importation des data
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(Math.random() * 100000, "<30", "2000");
        dataset.addValue(Math.random() * 100000, "<20", "2001");
        dataset.addValue(Math.random() * 100000, "<10", "2002");


//    Créa du graphique
        JFreeChart barChart = ChartFactory.createBarChart("Température", "YOYOOO",
                "Unité vendue", dataset, PlotOrientation.VERTICAL, true, true, true);
        barChart.setTitle("Températures");
        barChart.setBackgroundPaint(new Color(135, 206, 235));
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

// set the color (r,g,b) or (r,g,b,a)
        renderer.setSeriesPaint(0, new Color(160, 176, 172));
        renderer.setSeriesPaint(1, new Color(236, 176, 23));
        renderer.setSeriesPaint(2, new Color(255, 128, 0));
        barChart.setBorderPaint(Color.black);
        barChart.setBorderVisible(true);
        ChartPanel cPanel = new ChartPanel(barChart);
        return cPanel;
    }


    public ChartPanel buildJrand() {

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("<30", new Integer((int) (Math.random() * 100)));
        pieDataset.setValue("<20", new Integer((int) (Math.random() * 100)));
        pieDataset.setValue("<10", new Integer((int) (Math.random() * 100)));



        JFreeChart pieChart = ChartFactory.createPieChart("Camenbert ensoleillement au cours de la journée", pieDataset, true, true, true);
        ChartPanel cPanel = new ChartPanel(pieChart);

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setSectionPaint("<30",  new Color(15, 5, 107));
        plot.setSectionPaint("<20", new Color(237, 127, 23));
        plot.setSectionPaint("<10", new Color(247, 227, 95));


        cPanel.setPreferredSize(new java.awt.Dimension(5, 5));

        return cPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Aller chercher les stat dans la bd
        if (e.getSource() == exit) {
            System.exit(0);

        }
        if (e.getSource() == statBDHisto) {
        }
            if (e.getSource() == statRandomCamen) {
                cont.gridx = 0;
                cont.gridy = 0;
                ChartPanel graph = buildJrand();
                pano.add(graph, cont);
                graph.setPreferredSize(new java.awt.Dimension(200, 200));
            }
            if (e.getSource() == statRandomHisto) {
                cont.gridx = 0;
                cont.gridy = 0;
                ChartPanel graph = buildhisto();
                pano.add(graph, cont);
                graph.setPreferredSize(new java.awt.Dimension(200, 200));
            }
        }

    }


