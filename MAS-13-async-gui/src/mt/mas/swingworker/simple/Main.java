package mt.mas.swingworker.simple;

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
        Worker worker = new Worker();

        System.out.println("Counting...");
        
        // Start the long-lasting action
        worker.execute();
        
        // But the control flow returns immediately
        System.out.println("Waiting for the result...");
        
        // Exceptions required by SwingWorker
        try {
            // Waiting and checking if it is finished
            while(!worker.isDone()) {
                Thread.sleep(1000);
            }            

            // We have the result - get it
            var sum = worker.get();

            System.out.println("The result: " + sum);            
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
}
