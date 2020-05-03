package mt.mas.swingworker.gui;

import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingWorker;

/**
 * An example of using SwingWorker with GUI.
 * Generating some random numbers and adding them to a collection.
 * Only the first generic type is utilized (List<Integer>) henece the second one is Void.
 * 
 * @author Mariusz
 */
public class NumberGenerator extends SwingWorker<List<Integer>, Void> {
    private List<Integer> numbers;
    private int maxCount;
    ProgressDialog progressDialog;
    
    public NumberGenerator(int maxCount, ProgressDialog progressDialog) {
        super();

        this.maxCount = maxCount;   
        this.progressDialog = progressDialog;
    }
    
    /**
     * Generates the numbers and returns them as a list.
     */
    @Override
    protected List<Integer> doInBackground() throws Exception {
        final int maxNumber = 1000;
        int i = 1;
        
        numbers = new LinkedList<Integer>();

        // Check if we already generated all required numbers all the operation has been cancelled
        while(i < maxCount && isCancelled() == false) {
            Integer curInt = new Integer((int)(Math.random() * (double) maxNumber));
            numbers.add(curInt);

            if(i % 100 == 0) {
                // Store the update info
                setProgress((int)(100.0 * (float)i / maxCount));                
            }
            
            i++;
        }     
        
        return numbers;
    }

    @Override
    protected void done() {
        super.done();
        
        // Hide the GUI (dialog window)
        progressDialog.setVisible(false);
    }
}
