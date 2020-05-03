package mt.mas.swingworker.simple_progress;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariusz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var worker = new WorkerPlus();
        
        System.out.println("Counting...");

        // Start the long-lasting action
        worker.execute();
        
        // But the control flow returns immediately
        System.out.println("Waiting for the result...");
        
        
        // Exceptions required by SwingWorker
        try {
            // Waiting and checking if it is finished
            while(!worker.isDone()) {
                System.out.println("Progress: " + worker.getProgress());
                Thread.sleep(100);
            }            

            // We have the result - get it
            int floatSum = worker.get();

            System.out.println("The result: " + String.valueOf(floatSum));
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
}
