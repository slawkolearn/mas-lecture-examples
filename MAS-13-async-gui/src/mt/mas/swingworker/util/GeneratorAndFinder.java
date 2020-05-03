package mt.mas.swingworker.util;

import java.awt.HeadlessException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author  Mariusz
 */
public class GeneratorAndFinder extends javax.swing.JFrame {

    /** Creates new form GeneratorAndFinder */
    public GeneratorAndFinder() {
        initComponents();
    }

    private void GenerateFind() throws NumberFormatException, HeadlessException {

        try {
            // Generate a list with numbers
            NumberGenerator gen = new NumberGenerator((Integer) spnCount.getValue());
            gen.start();

            // Check if cancelled
            if(gen.isCancelled()) {
                JOptionPane.showMessageDialog(null, "The operation has been cancelled.");
                return;
            }

            // Get the result list
            List<Integer> numbers = gen.get();

            JOptionPane.showMessageDialog(null, "The generated list constains: " + numbers.size() + " numbers.\nPress OK to start counting occurencies.");
            
            // Count the occurencies of the given number
            NumberFinder finder = new NumberFinder(numbers, Integer.parseInt(txtNumberToFind.getText()));
            finder.start();

            // Check if cancelled
            if(finder.isCancelled()) {
                JOptionPane.showMessageDialog(null, "The operation has been cancelled.");
                return;
            }
            
            // Get the result
            int count = finder.get();
            
            // Show the result
            JOptionPane.showMessageDialog(null, "The number " + txtNumberToFind.getText() + " occured " + count + " times.");
  
        } catch (InterruptedException ex) {
            Logger.getLogger(GeneratorAndFinder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(GeneratorAndFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spnCount = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtNumberToFind = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Liczba liczb do generowania");

        spnCount.setModel(new javax.swing.SpinnerNumberModel(500000, 100000, 1000000, 10000));

        jLabel2.setText("Liczba do wyszukania");

        txtNumberToFind.setText("100");

        btnStart.setText("Rozpocznij");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumberToFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(btnStart)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spnCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumberToFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnStart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        GenerateFind();    
}//GEN-LAST:event_btnStartActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneratorAndFinder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner spnCount;
    private javax.swing.JTextField txtNumberToFind;
    // End of variables declaration//GEN-END:variables

}