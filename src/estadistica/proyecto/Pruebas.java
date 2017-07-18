/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica.proyecto;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author moxb
 */
public class Pruebas {
    
    public float Moda(ArrayList<Float> dat) {
        
        Map<Float, Float> m = new HashMap<Float, Float>();
        
        for (float elemento : dat) {
            if (m.containsKey(elemento)) {
                m.put(elemento, m.get(elemento) + 1);
            } else {
                m.put(elemento, (float) 1.0);
            }
        }
        
        float repeticiones = 0;
        ArrayList<Float> moda = new ArrayList<Float>();
        
        Iterator<Entry<Float, Float>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<Float, Float> e = iter.next();
            
            if (e.getValue() > repeticiones) {
                moda.clear();
                moda.add(e.getKey());
                repeticiones = e.getValue();
            } else if (e.getValue() == repeticiones) {
                moda.add(e.getKey());
            }
            
        }
        if (moda.size() == dat.size()) {
            return 0;
        } else {
            return moda.get(0);
        }
    }
    
}
