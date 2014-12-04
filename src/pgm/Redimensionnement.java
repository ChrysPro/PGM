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
public class Redimensionnement {
    
    Read image;
    
    public Redimensionnement(Read im){
        image=im;
    }
    
    
    public void setHauteur(int newHauteur){
        
        int r=newHauteur/image.getLongueur();//Ratio de redimensionnement
        int a=0;//1-reste à utiliser de l'image à redimensionner
        int b=0;//ligne courante de l'image à redimensionner
        Read newImage = new Read ("redim");//image redimensionné
        ArrayList<Integer> newTableau=null;
        
        for(int i=0;i<newHauteur;i++){
            
            this.parLigne(image, r, a, b, i, newTableau);
        }
        
    }
    
    public void parLigne(Read image, int r, int a, int b, int i, ArrayList<Integer> newTableau){
        int c=0;//% de remplissage de la nouvelle ligne
        int d;
        
        while(c!=1){
            if(r<=1-c){
                d=r;
            }else{
                d=1-c;
            }
            
            for(int j=0+; j<image.getLargeur();j++){
                newTableau.add(j,image.getTableau().get(j)*d);
            }
            
        }
    }
    
    
}
