/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import java.io.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nbrandt
 */
public class Read {
    
    /**
     * Le nom du fichier pgm à lire
     */
    public String filename;
    /**
     *
     */
    public int hauteur;
    /**
     *
     */
    public int largeur;
    /**
     *
     */
    public ArrayList tableau;

    /**
     * Le constructeur 
     * @param filename
     */
    public Read(String filename) {
        this.filename = filename;
        this.largeur=0;
        this.hauteur=0;
        this.tableau= new ArrayList();
    }
 
    
    /**
     *Lit une ligne du fichier pgm et rempli l'Arraylist en fonction
     * ainsi que les dimensions dans des attributs séparés
     * @param ligne
     * @param lect
     * @param buffer
     */
    public int creerObjet (String ligne, Read lect, int test) {
            String delimiters = " .,;";
            String mot;
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiters);
            mot = tokenizer.nextToken();
            switch (mot) {
                case "P2":
                    break;
                //La ligne commençant par # annonce que la prochaine ligne concernera les dimensions de l'image
                case "#":
                // la variable test permet de considerer de maniere particulière les 2 lignes après le dièse.
                        test=1;                
                    break;
                default:
                    if (test==1) {
                     lect.largeur=Integer.parseInt(mot);
                     mot= tokenizer.nextToken();
                     lect.hauteur=Integer.parseInt(mot);
                     test=2;
                     break;
                    } else if (test==2) {
                        test = 0;
                        break;
                    }
                    else {
                    lect.tableau.add(Integer.parseInt(mot));
                    while (tokenizer.hasMoreTokens()) {
                        mot = tokenizer.nextToken();
                    }
                    
                    lect.tableau.add(Integer.parseInt(mot));
                    break;}
            }
        return test;
    }
    
    /**
     *Fonction qui permet de lire intégralement le fichier pgm et de l'insérer dans les attributs de la classe Read
     * @param filename
     * @return
     */
    public Read lecture(String filename) {
        Read lect=new Read(filename);
        try {
            String ligne;
            String mot;
            int test=0;
            BufferedReader buffer = new BufferedReader(new FileReader(filename));
             while ((ligne = buffer.readLine()) !=null){
                System.out.println(ligne);
               test=creerObjet(ligne, lect, test);
                }
             }
        catch (Exception e) {
            e.printStackTrace();
}
return lect;}
}
    

