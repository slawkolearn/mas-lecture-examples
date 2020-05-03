package mt.mas.swingworker.util;

import java.util.LinkedList;
import java.util.List;

/**
 * A sample utilization of ProgressWorker:
 * Generation of random numbers and storing them in a collection.
 * 
 * @author Mariusz
 */
public class NumberGenerator extends ProgressWorker<List<Integer>, Void> {
    private List<Integer> numbers;
    private int maxCount;
    
    public NumberGenerator(int maxCount) {
        // We need to call the super-class constructor with the user's message
        super("Generating numbers (" + maxCount + ")... Please wait...");

        // System.out.println("Generowanie liczb (" + maxCount + ")... Prosze czekac");
        
        this.maxCount = maxCount;   
    }
    
    /**
     * Generates numbers and returns them as a list.
     */
    @Override
    protected List<Integer> doInBackground() throws Exception {
        final int maxNumber = 1000;
        int i = 1;
        
        numbers = new LinkedList<Integer>();
        
        while(i < maxCount && isCancelled() == false) {
            Integer curInt = new Integer((int)(Math.random() * (double) maxNumber));
            numbers.add(curInt);

            if(i % 100 == 0) {
                // Update progress info
                setProgress((int)(100.0 * (float)i / maxCount));                
            }
            
            i++;
        }     
        
        return numbers;
    }
}
