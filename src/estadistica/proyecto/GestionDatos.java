/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica.proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author moxb
 */
public class GestionDatos {

    private ArrayList<Float> x;
    private ArrayList<Float> y;
    int n;

    public boolean leerDatos(String ruta) throws FileNotFoundException {
        boolean error;

        x = new ArrayList();
        y = new ArrayList();

        String[] temp;
        String aux;
        File f = new File(ruta);
        Scanner arch = new Scanner(f);
        try {
            while (arch.hasNext()) {
                aux = arch.nextLine();
                aux = aux.replace(',', '.');
                temp = aux.split(";");
                this.x.add(Float.parseFloat(temp[0]));
                this.y.add(Float.parseFloat(temp[1]));
            }

            return error = false;
        } catch (Exception e) {
            return error = true;
        }
    }

    public int NparesOrdenados() {
        if (x.size() == y.size()) {
            this.n = x.size();
        } else {
            this.n = 0;
            System.out.println("ERROR");
        }

        return this.n;
    }

    public ArrayList getX() {
        return this.x;
    }

    public ArrayList getY() {
        return this.y;
    }

}
