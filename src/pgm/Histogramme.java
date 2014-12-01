

package pgm;

import java.util.ArrayList;

/**
 *
 * @author ybellehi
 */
public class Histogramme {

    private Read image;
    private Read histo;
    private ArrayList<Integer> detail;

    /**
     *création d'un histogramme à partir d'une image
     * @param i
     */
    public Histogramme(Read i) {
       image = i;
       creerHistogramme();
        }

    /**
     * renvoie l'histogramme
     * @return 
     */
    
    public Read getHisto() {
        return histo;
    }
    
    

    /**
     *création d'un tableau regroupant le nombre d'apparition de chaque valeur de niveaux de gris
     */
    public void creerDetail() {

        ArrayList<Integer> details = new ArrayList();
        for (int i = 0; i < 256; i++) {
            details.add(i, 0);
        }

        for (int j = 0; j < image.getTableau().size(); j++) {
            
            details.add(image.getTableau().get(j), details.get(image.getTableau().get(j)) +  1);
        }
        detail=details;
    
    }
    
    /**
     * création d'histogramme au format image
     */
    public void creerHistogramme(){
        Read histo1 = new Read("");
        creerDetail();
        int max=0;
        for(int i=0;i<256;i++){
            if(detail.get(i)>max){
                max=detail.get(i);
            }
        }
        histo1.setNomfichier("histogramme");
        int largeur=256*2;
        int longueur=max;
        histo1.setLargeur(largeur);
        histo1.setLongueur(longueur);
        
        ArrayList<Integer> tableau = new ArrayList();
        for(int j=0;j<largeur;j++){
            for(int i=0;i<longueur;i++){
                if(detail.get(j)<longueur-i){
                    tableau.add(i*largeur+j, 0);
                }else{
                    tableau.add(i*largeur+j, 255);
                }
            }
        }
        
        histo1.setTableau(tableau);
        histo=histo1;
    }
}


