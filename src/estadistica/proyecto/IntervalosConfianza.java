/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica.proyecto;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author moxb
 */
public class IntervalosConfianza {

    private ArrayList<Float> lista;
    private int NC;

    public IntervalosConfianza(ArrayList<Float> lista, int NC) {
        this.lista = lista;
        this.NC = NC;   // 1 -> 90%     2 -> 95%     3 -> 98%       4 -> 99%
    }

    public float Media() {
        float aux = 0;
        for (int i = 0; i < lista.size(); i++) {
            aux += lista.get(i);
        }
        return (aux / lista.size());
    }

    public float Desviacion() {
        float aux = 0;
        float media = Media();
        for (int i = 0; i < lista.size(); i++) {
            aux += ((float) (Math.pow(lista.get(i) - media, 2)));
        }
        return (float) (Math.sqrt(aux / (lista.size() - 1)));
    }

    public float LimitesS() throws FileNotFoundException {
        float media = Media();
        float desviacion = Desviacion();
        TablaT tabla = new TablaT();
        float t = tabla.tabla(lista.size(), NC);

        return (media + (t * (desviacion / ((float) (Math.sqrt(lista.size()))))));
    }

    public float LimitesI() throws FileNotFoundException {
        float media = Media();
        float desviacion = Desviacion();
        TablaT tabla = new TablaT();
        float t = tabla.tabla(lista.size(), NC);

        return (media - (t * (desviacion / ((float) (Math.sqrt(lista.size()))))));
    }

    public float getT() throws FileNotFoundException {
        TablaT tabla = new TablaT();
        float t = tabla.tabla(lista.size(), NC);
        return t;
    }

}
