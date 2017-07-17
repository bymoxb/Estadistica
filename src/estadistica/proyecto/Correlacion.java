package estadistica.proyecto;

import java.util.ArrayList;

public class Correlacion {

    private ArrayList<Float> x;
    private ArrayList<Float> y;
    private int n;

    public Correlacion(ArrayList<Float> x, ArrayList<Float> y) {
        this.x = x;
        this.y = y;
        this.n = NparesOrdenados();
    }

    public float Media(ArrayList<Float> lista) {
        float media = 0;
        for (int i = 0; i < lista.size(); i++) {
            media += lista.get(i);
        }
        return (media / lista.size());
    }

    private int NparesOrdenados() {
        if (x.size() == y.size()) {
            this.n = x.size();
        } else {
            this.n = 0;
            System.out.println("ERROR");
        }
        return this.n;
    }

    public float Snn(char op) {
        float aux1 = 0, aux2 = 0, sxx = 0;
        ArrayList<Float> lista;

        op = Character.toUpperCase(op);
        if (op == 'X') {
            lista = this.x;
        } else {
            lista = this.y;
        }

        //SUMATORIA ( (X)^2 )
        for (int i = 0; i < lista.size(); i++) {
            aux1 += Math.pow((lista.get(i)), 2);
        }

        //( SUMATORIA ( X ) )^2
        for (int i = 0; i < lista.size(); i++) {
            aux2 += lista.get(i);
        }
        aux2 = (float) (Math.pow(aux2, 2));
        sxx = aux1 - (aux2 / this.n);
        lista = null;
        return sxx;
    }

    public float Sxy() {
        float sxy = 0;
        float aux1 = 0;
        float aux2 = 0;
        float acumx = 0, acumy = 0;

        // SUMATORIA (X*Y)
        for (int i = 0; i < x.size(); i++) {
            aux1 += (x.get(i) * y.get(i));
        }

        // ( (SUMATORIA (X)) * (SUMATORIA(Y)) )
        for (int i = 0; i < n; i++) {
            acumx += x.get(i);
            acumy += y.get(i);
        }
        aux2 = (acumx * acumy);

        sxy = (aux1 - (aux2 / n));
        return sxy;
    }

    public float R() {
        float r;

        r = (float) (Sxy() / (Math.sqrt(Snn('x') * Snn('y'))));

        return r;
    }

    public ArrayList getX() {
        return this.x;
    }

    public ArrayList getY() {
        return this.y;
    }

    public float Beta1() {
        float numerador = 0, denominador = 0;
        float mediax = Media(this.x), mediay = Media(this.y);

        for (int i = 0; i < this.NparesOrdenados(); i++) {
            numerador += ((this.x.get(i) - mediax) * (this.y.get(i) - mediay));
        }

        for (int i = 0; i < NparesOrdenados(); i++) {
            denominador += (Math.pow((this.x.get(i) - mediax), 2));
        }

        return (numerador / denominador);

    }

    public float Beta0() {
        float beta0;
        return beta0 = (Media(this.y) - (Beta1() * Media(this.x)));
    }

    public float R2() {
        return (float) (Math.pow((R()), 2));
    }

}
