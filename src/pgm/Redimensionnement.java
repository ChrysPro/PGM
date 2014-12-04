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
    int b;
    double a;
    
    public Redimensionnement(Read im){
        image=im;
    }
    
    
    public Read setHauteur(int newHauteur){
        
        double r = (Math.floor(((double)newHauteur/(double)image.getLargeur())*1000)/1000);//Ratio de redimensionnement
        a=0;//1-reste à utiliser de l'image à redimensionner
        b=0;//ligne courante de l'image à redimensionner
        Read newImage = new Read ("redimLongueur");//image redimensionné
        ArrayList<Integer> newTableau = new ArrayList();
        
        for(int i=0;i<image.getLargeur()*newHauteur;i++){
            newTableau.add(1);
        }
        
        for(int i=0;i<newHauteur;i++){
            
            this.parLigne(image, r, i, newTableau);
        }
        
        newImage.setTableau(newTableau);
        newImage.setLargeur(image.getLargeur());
        newImage.setLongueur(newHauteur);
        
        return newImage;
    }
    
    public void parLigne(Read image, double r, int i, ArrayList<Integer> newTableau){
        double c=0;//% de remplissage de la nouvelle ligne
        double d;
        
        while(c<1 && b<image.getLongueur() ){
            if(r-a<=1-c){
                d=r-a;
            }else{
                d=1-c;
            }
            
            for(int j=0; j<image.getLargeur();j++){
                double p = image.getTableau().get(j+b*image.getLargeur())*d;
                int m = (int)p;
                newTableau.set(j+i*image.getLargeur(), m);
               
            }
            
             c=c+d;
             a=a+d;
                
            if(a==r){
                a=0;
                b++;
            }

            
        }
    }
    
    public Read setLargeur(int newLargeur){
        

        double r = (Math.floor(((double)newLargeur/(double)image.getLargeur())*1000)/1000);//Ratio de redimensionnement
        System.out.println("r = " + r + " " + image.getLargeur() + " " + newLargeur);
        a=0;//1-reste à utiliser de l'image à redimensionner
        b=0;//colonne courante de l'image à redimensionner
        Read newImage = new Read ("redimLargeur");//image redimensionné
        ArrayList<Integer> newTableau = new ArrayList();
        for(int i=0;i<image.getLongueur()*newLargeur;i++){
            newTableau.add(1);
        }
        
        for(int i=0;i<newLargeur;i++){
            
            this.parColonne(image, r, i, newTableau, newLargeur);

        }
        
        newImage.setTableau(newTableau);
        newImage.setLargeur(newLargeur);
        newImage.setLongueur(image.getLongueur());
        
        return newImage;
        
    }
    
    
    public void parColonne(Read image, double r, int i, ArrayList newTableau, int newLargeur){
        double c = 0;//% de remplissage de la nouvelle ligne
        double d = 0;
  
        
        while(c<1){
           
            if(r-a<=1-c){
                d=r-a;
            }else{
                d=1-c;
            }
             
            
            for(int j=0; j<image.getLongueur()-1;j++){
                newTableau.set(j*newLargeur+i,image.getTableau().get(j*image.getLargeur()+b)*d);
                
            }
            c=c+d;
            a=a+d;
            
            
            
            if(a==r){
                b++;
                a=0;
                
            }
            
        }

    }
    
    
}
