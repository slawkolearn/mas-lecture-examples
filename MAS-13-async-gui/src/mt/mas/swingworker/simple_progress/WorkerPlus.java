package mt.mas.swingworker.simple_progress;

import javax.swing.SwingWorker;

/**
 * A simple example of using SwingWorker together with a progress information (console only).
 *
 * @author Mariusz
 */
public class WorkerPlus extends SwingWorker<Integer, Void> {

	/**
	 * Count the sum of numbers from 1 to the given maxNumber with updates.
	 */
	@Override
	protected Integer doInBackground() throws Exception {
		// Count the sum of numbers from 1 to the given maxNumber
		final int maxNumber = 500000000;
		int sum = 0;

		for (int i = 1; i < maxNumber; i++) {
			sum += i;
			if(i % 100 == 0) {
				// Store the progress info
				double percentage = 100.0 * (float) i / maxNumber;
				setProgress((int) percentage);
			}
		}

		return sum;
	}
}
