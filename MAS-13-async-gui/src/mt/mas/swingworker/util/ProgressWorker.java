package mt.mas.swingworker.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingWorker;
import mt.mas.swingworker.gui.ProgressDialog;

/**
 * Encapsulates all functionality for executing a long-lasting activities together with GUI progress info.
 * Remember to check for the isCancelled() and update necessary progress info.
 * @author mariusza
 */
public abstract class ProgressWorker<finalResult, partialResult> extends SwingWorker<finalResult, partialResult> {
    private ProgressDialog progressDialog;
    
    /**
     * Creates a new instance presenting the user's message.
     * @param progressMessage
     */
    public ProgressWorker(String progressMessage) {
        super();

        progressDialog = new ProgressDialog(null, progressMessage);
        progressDialog.setWorker(this);

        // Add a listener to have updates about the progress
        addPropertyChangeListener(
                new PropertyChangeListener() {

                    public void propertyChange(PropertyChangeEvent evt) {
                        if ("progress".equals(evt.getPropertyName())) {
                            progressDialog.setValue((Integer) evt.getNewValue());
                        }
                    }
                }
        );
    }
    
    /**
     * Starts the long-lasting activity and shows GUI.
     * This method should be executed instead of the execute() method.
     */
    public void start() {
        execute();
        
        progressDialog.setVisible(true);
    }

    /**
     * Executed automatically when all calcutaions are finished or cancelled.
     * Call the super method and hides the GUI.
     */
    @Override
    protected void done() {
        super.done();
        
        // Hide GUI
        progressDialog.setVisible(false);
    }
}
