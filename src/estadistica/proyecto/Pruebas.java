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
public class Pruebas {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Float> x = new ArrayList();
        ArrayList<Float> y = new ArrayList();

        String[] temp;
        String aux;
        File f = new File("C:\\Users\\moxb\\Desktop\\correlacion.csv");
        Scanner arch = new Scanner(f);
        try {
            while (arch.hasNext()) {
                aux = arch.nextLine();
                aux = aux.replace(',', '.');
                temp = aux.split(";");
                x.add(Float.parseFloat(temp[0]));
                y.add(Float.parseFloat(temp[1]));
                System.out.println(temp[0] + "\t" + temp[1]);
            }

        } catch (Exception e) {
        }

    }

}
