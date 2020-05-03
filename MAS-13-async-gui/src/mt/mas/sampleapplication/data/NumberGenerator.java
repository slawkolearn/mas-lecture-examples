/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mt.mas.sampleapplication.data;

import mt.mas.swingworker.util.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Przyklad uzycia ProgressWorker'a.
 * Generowanie losowych liczb i dodawanie ich do kolekcji.
 * Nie uzywamy drugiego parametru, wiec stosujemy Void.
 * 
 * @author Mariusz
 */
public class NumberGenerator extends ProgressWorker<List<Integer>, Void> {
    private int maxCount;
    private static List<Integer> numbers = null;
    
    public NumberGenerator(List<Integer> numbers, int maxCount) {
        super("Generowanie liczb (" + maxCount + ")... Prosze czekac");

        // System.out.println("Generowanie liczb (" + maxCount + ")... Prosze czekac");
        
        this.maxCount = maxCount;  
        this.numbers = numbers;
    }
    
    @Override
    /**
     * Generujemy liczby i dodajemy jedo listy.
     */
    protected List<Integer> doInBackground() throws Exception {
        // Generujemy liczby i dodajemy je do listy      
        final int maxNumber = 1000;
        int i = 1;
        
        numbers.clear();
        
        while(i < maxCount && isCancelled() == false) {
            Integer curInt = new Integer((int)(Math.random() * (double) maxNumber));
            numbers.add(curInt);

            if(i % 100 == 0) {
                // Ewentualna informacja o postepach
                setProgress((int)(100.0 * (float)i / maxCount));                
            }
            
            i++;
            
            Thread.sleep(1);
        }     
        
        return numbers;
    }
}
