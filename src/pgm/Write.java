/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author nbrandt
 */
public class Write {
    public Write (Read test, String filename) {
       BufferedWriter buffer = null;
       try {
           int count=0;
           buffer= new BufferedWriter(new FileWriter(filename));
           buffer.write("P2");
           buffer.newLine();
           buffer.write("#");
           buffer.newLine();
           buffer.write(test.largeur+" "+test.hauteur);
           buffer.newLine();
           buffer.write("255");
           while (count+1 != test.tableau.size()){
               if (count%70==0) {
                   buffer.newLine();
               }
           buffer.write(test.tableau.get(count)+" ");
           count ++;
           }
       }
        catch (FileNotFoundException ex) {
                   ex.printStackTrace();
                  } 
               catch(IOException ex) {
                   ex.printStackTrace();
                  }
               finally {
                    try{
                        if(buffer !=null) {
                            buffer.flush();
                            buffer.close();

                            }
                        }

                    catch(IOException ex) {
                        ex.printStackTrace();
                        }
                        }
               }
            
           }
         


