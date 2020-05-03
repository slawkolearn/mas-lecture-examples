package mt.mas.swingworker.simple;

import javax.swing.SwingWorker;

/**
 * A simple utilization of the SwingWorker class.
 * We do not use the second generic type, hence the 'Void' is passed.
 * 
 * @author Mariusz
 */
public class Worker extends SwingWorker<Integer, Void> {

    @Override
    /**
     * Count the sum of numbers from 1 to the given maxNumber and return it as String.
     */
    protected Integer doInBackground() throws Exception {
        // Count the sum of numbers from 1 to the given maxNumber
        final int maxNumber = 500000000;
        int sum = 0;

        for (long i = 1; i < maxNumber; i++) {
            sum += i;
        }

        return sum;
    }
}
