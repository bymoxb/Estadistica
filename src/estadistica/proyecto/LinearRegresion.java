/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica.proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

/**
 *
 * @author Jonathan
 */
public class LinearRegresion {

    SimpleRegression sr = new SimpleRegression();
    Plot2DPanel plot = new Plot2DPanel();
    JTextArea resultado = new JTextArea();

    void LinearRegresion(ArrayList<Float> a, ArrayList<Float> b) {
//        Map<Integer, Integer> m = new HashMap<Ingeter, Integer>();
        double[] x = new double[a.size()];
        double[] y = new double[b.size()];
        for (int i = 0; i < x.length; i++) {
            x[i] = a.get(i);

        }

        for (int i = 0; i < y.length; i++) {
            y[i] = b.get(i);

        }

        for (int i = 0; i < x.length; i++) {
            sr.addData(x[i], y[i]);
        }
        double[] yc = new double[y.length];
        for (int i = 0; i < x.length; i++) {
            yc[i] = sr.predict(x[i]);
        }

        plot.addLegend("South");
        plot.addScatterPlot("Datos", x, y);
        plot.addLinePlot("Regresion", x, yc);
        BaseLabel titulo = new BaseLabel("Regresion Lineal", Color.blue, 0.5, 1.1);
        plot.addPlotable(titulo);
        JFrame frame = new JFrame("Regresion Lineal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.add(plot, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
