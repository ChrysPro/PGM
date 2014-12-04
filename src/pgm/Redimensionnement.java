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
    
    
    public Read setHauteur(int newHauteur){
        
        int r=newHauteur/image.getLongueur();//Ratio de redimensionnement
        int a=0;//1-reste à utiliser de l'image à redimensionner
        int b=0;//ligne courante de l'image à redimensionner
        Read newImage = new Read ("redimLongueur");//image redimensionné
        ArrayList<Integer> newTableau=null;
        
        for(int i=0;i<newHauteur;i++){
            
            this.parLigne(image, r, a, b, i, newTableau);
        }
        
        newImage.setTableau(newTableau);
        newImage.setLargeur(image.getLargeur());
        newImage.setLongueur(newHauteur);
        
        return newImage;
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
            
            for(int j=0; j<image.getLargeur();j++){
                newTableau.add(j+i*image.getLargeur(),image.getTableau().get(j+b*image.getLargeur())*d);
                c=c+d;
                a=a+d;
            }
            if(a==r){
                b++;
            }
            
        }
    }
    
    public Read setLargeur(int newLargeur){
        
        int r=newLargeur/image.getLargeur();//Ratio de redimensionnement
        int a=0;//1-reste à utiliser de l'image à redimensionner
        int b=0;//colonne courante de l'image à redimensionner
        Read newImage = new Read ("redimLargeur");//image redimensionné
        ArrayList<Integer> newTableau=null;
        for(int i=0;i<image.getLongueur()*newLargeur;i++){
            newTableau.add(i,0);
        }
        
        for(int i=0;i<newLargeur;i++){
            
            this.parColonne(image, r, a, b, i, newTableau);
        }
        
        newImage.setTableau(newTableau);
        newImage.setLargeur(newLargeur);
        newImage.setLongueur(image.getLongueur());
        
        return newImage;
        
    }
    
    
    public void parColonne(Read image, int r, int a, int b, int i, ArrayList newTableau){
        int c=0;//% de remplissage de la nouvelle ligne
        int d;
        
        while(c!=1){
            if(r<=1-c){
                d=r;
            }else{
                d=1-c;
            }
            
            for(int j=0; j<image.getLongueur();j++){
                newTableau.add(j*image.getLongueur()+i,image.getTableau().get(j*image.getLongueur()+b)*d);
                c=c+d;
                a=a+d;
            }
            
            
            
            if(a==r){
                b++;
            }
            
        }
    }
    
    
}
