package mt.mas.swingworker.util;

import java.util.List;

/**
 *
 * @author Mariusz
 */
public class NumberFinder extends ProgressWorker<Integer, Void> {
    private List<Integer> numbers;
    Integer numberToFind;
    
    public NumberFinder(List<Integer> numbers, Integer numberToFind) {
        super("Counting occurencies of the number: " + numberToFind + "...");
        
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
                // Update progress info
                setProgress((int)(100.0 * (float)i / numbers.size()));                
            }
            
            i++;
        }
        
        return new Integer(count);
    }
}
