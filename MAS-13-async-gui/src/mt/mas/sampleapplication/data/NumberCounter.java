/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mt.mas.sampleapplication.data;

import mt.mas.swingworker.util.*;
import java.util.List;

/**
 *
 * @author mariuszadmin
 */
public class NumberCounter extends ProgressWorker<Integer, Void> {
    private List<Integer> numbers;
    Integer numberToFind;
    
    public NumberCounter(List<Integer> numbers, Integer numberToFind) {
        super("Wyszukiwanie liczby wystapien dla " + numberToFind + "...");
        
        this.numberToFind = numberToFind;
        this.numbers = numbers;
    }
    
    @Override
    protected Integer doInBackground() throws Exception {
        int count = 0;
        int i = 0;
        
        for(Integer number : numbers) {
            if(isCancelled()) {
                return new Integer(count);
            }
            
            if(number.equals(numberToFind)) {
                count++;
            }

            if(i % 100 == 0) {
                // Ewentualna informacja o postepach
                setProgress((int)(100.0 * (float)i / numbers.size()));                
            }
            
            Thread.sleep(1);
            i++;
        }
        
        return new Integer(count);
    }

}
