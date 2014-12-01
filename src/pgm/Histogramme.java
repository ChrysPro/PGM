/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import java.util.ArrayList;

/**
 *
 * @author ybellehi
 */
public class Histogramme {

    private PGM image;
    private PGM histo;
    private ArrayList<Integer> detail;

    public Histogramme(PGM i) {
        image = i;
    }

    public void creerDetail() {

        for (int i = 0; i < 256; i++) {
            detail.add(i, 0);
        }

        for (int j = 0; j < image.setArrayList.length(); j++) { //TODO jusqu'à la derniere valeur de l'ArrayList

            detail.add(image.setArrayList.get(j), detail.get(image.setArrayList.get(j)) + 1);//TODO remplacer ArrayList par la fonction necessaire
        }
    }
}


