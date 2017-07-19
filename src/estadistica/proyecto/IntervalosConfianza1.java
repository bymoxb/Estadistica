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
public class IntervalosConfianza1 {

    private ArrayList<Float> lista;
    private float alfa2, z;
    private int NC;

    public IntervalosConfianza1(ArrayList<Float> lista, int NC) {
        this.lista = lista;
        this.NC = NC;
    }

    public void valorZ() {
        System.out.println(this.NC);
        if (this.NC == 1) {
            this.z = Float.parseFloat("1.65");
            this.alfa2 = Float.parseFloat("0.05");
        } else {
            if (this.NC == 2) {
                this.z = Float.parseFloat("1.96");
                this.alfa2 = Float.parseFloat("0.025");
            } else {
                if (this.NC == 3) {
                    this.z = Float.parseFloat("2.33");
                    this.alfa2 = Float.parseFloat("0.01");
                } else {
                    this.z = Float.parseFloat("2.58");
                    this.alfa2 = Float.parseFloat("0.005");
                }
            }
        }
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

    public float MargenError() {
        valorZ();
        System.out.println(this.z);
        return (float) ((this.z) * (Desviacion() / (Math.sqrt(lista.size()))));
    }

    public float LimiteS() {
        return (Media() + MargenError());
    }

    public float LimiteI() {
        return (Media() - MargenError());
    }

    public float getZ() {
        return this.z;
    }

    public float getAlfa() {
        return alfa2;
    }
}
