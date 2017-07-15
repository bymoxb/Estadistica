/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica.proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author moxb
 */
public class TablaT {

    public float tabla(int tam, int NC) throws FileNotFoundException {
        tam = tam - 1;
        NC = NC - 1;

        File f = new File("tabla t.txt");
        Scanner arch = new Scanner(f);
        String aux, dato = "";
        String[] temp;
        int n = 0;

        if (tam <= 100) {
            while (arch.hasNext() && n != tam) {
                n++;
                aux = arch.nextLine();
                temp = aux.split(";");
                if (n == tam) {
                    dato = temp[NC];
                }

            }
        } else {
            while (arch.hasNext()) {
                n++;
                aux = arch.nextLine();
                temp = aux.split(";");
                if (n == 101) {
                    dato = temp[NC];
                }
            }
        }
        return Float.parseFloat(dato);
    }

}
