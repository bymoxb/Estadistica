/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica.proyecto;

import java.util.ArrayList;

public class Basica {

    private ArrayList<Float> lista;

    private ArrayList<Float> resta;
    private float media, mediana, moda, varianza, desviacion;

    public Basica(ArrayList<Float> lista) {
        Ordenar ordenar = new Ordenar();
        this.lista = ordenar.Ordenar(lista);
    }

    public ArrayList getlista() {
        return this.lista;
    }

    public float Media() {
        float acum = 0;
        float media;

        for (int i = 0; i < lista.size(); i++) {
            acum += lista.get(i);
        }

        media = acum / lista.size();

        return media;
    }

    public float Mediana() {
        float mediana;
        int n;

        if (lista.size() % 2 == 0) {
            n = lista.size() / 2;

            mediana = (lista.get(n - 1) + lista.get(n)) / 2;

        } else {

            n = (lista.size() - 1) / 2;
            mediana = lista.get(n);
        }
        return mediana;
    }

    public void Moda() {
        ArrayList<Object> x = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (j > i) {
                    if (lista.get(i).equals(lista.get(j))) {
                        x.add(lista.get(i));
                    }
                }
            }
        }

        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
    }

    public void resta() {
        resta = new ArrayList();

        //  X-Xp
        for (int i = 0; i < lista.size(); i++) {
            resta.add((lista.get(i) - Media()));
        }

    }

    private void VarianzaDesviacion() {
        resta();

        ArrayList<Float> listaaux = new ArrayList();
        float aux;

        // (X-Xp)^2
        for (int i = 0; i < resta.size(); i++) {
            aux = (float) (Math.pow((resta.get(i)), 2));
            listaaux.add(aux);
        }

        //SUMATORIA DE TODOS LOS ELEMENTOS DE (X-Xp)^2
        aux = 0;
        for (int i = 0; i < listaaux.size(); i++) {
            aux += listaaux.get(i);
        }

        //VARIANZA S^2
        this.varianza = (aux / (lista.size() - 1));

        //DESVIACION S
        this.desviacion = ((float) (Math.sqrt(this.varianza)));
        listaaux = null;

    }

    public float Varianza() {
        VarianzaDesviacion();
        return this.varianza;
    }

    public float DesviacionEstandar() {
        return this.desviacion;
    }

    public float Minimo() {
        return lista.get(0);
    }

    public float Maximo() {
        return lista.get(lista.size() - 1);
    }

    float Cvariacion() {
        float cvariacion;
        return cvariacion = DesviacionEstandar() / Media();
    }

    float Rango() {
        float rango;
        return rango = (lista.get(lista.size() - 1)) - (lista.get(0));

    }

    private ArrayList RestayDiv(int n) {
        ArrayList<Float> listaaux = new ArrayList();
        ArrayList<Float> listaaux2 = new ArrayList();
        float aux;

        //(X-Xp)/S
        for (int i = 0; i < resta.size(); i++) {
            aux = (resta.get(i) / DesviacionEstandar());
            listaaux.add(aux);
        }

        //((X-Xp)/S)^n
        for (int i = 0; i < listaaux.size(); i++) {
            aux = (float) (Math.pow((listaaux.get(i)), n));
            listaaux2.add(aux);
        }

        listaaux = null;
        return listaaux2;
    }

    float Asimetria() {
        ArrayList<Float> listaaux = RestayDiv(3);
        float as, acum = 0;
        for (int i = 0; i < listaaux.size(); i++) {
            acum += listaaux.get(i);
        }

        as = (lista.size() - 1) * (lista.size() - 2);
        as = lista.size() / as;
        as = as * acum;
        listaaux = null;
        return as;
    }

    float Curtosis() {
        ArrayList<Float> listaaux = RestayDiv(4);

        float k, y, acum = 0;

        for (int i = 0; i < listaaux.size(); i++) {
            acum += listaaux.get(i);
        }

        k = (lista.size() * (lista.size() + 1));
        k = k / ((lista.size() - 1) * (lista.size() - 2) * (lista.size() - 3));
        k = k * acum;
        y = (float) (3 * Math.pow((lista.size() - 1), 2));
        y = y / ((lista.size() - 2) * (lista.size() - 3));
        k = k - y;
        listaaux = null;
        return k;
    }
}
