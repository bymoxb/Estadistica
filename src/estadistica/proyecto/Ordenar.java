/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica.proyecto;

import java.util.ArrayList;

/**
 *
 * @author moxb
 */
public class Ordenar {

    public ArrayList Ordenar(ArrayList<Float> lista) {
        Float auxlista;
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(j + 1) < lista.get(j)) {
                    auxlista = lista.get(j + 1);
                    lista.set(j + 1, lista.get(j));
                    lista.set(j, auxlista);
                }
            }
        }
        return lista;
    }

}
