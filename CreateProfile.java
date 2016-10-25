import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author letzo
 */
public class CreateProfile extends javax.swing.JFrame {

	private String name;
	
    public CreateProfile(String fromCheckin) {
    	name = fromCheckin;
        initComponents();
        createFirstField.setText(name.substring(0, name.indexOf(' ')));
        createLastField.setText(name.substring(name.indexOf(' ')+1, name.length()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createHeader = new javax.swing.JLabel();
        createFirst = new javax.swing.JLabel();
        createLast = new javax.swing.JLabel();
        createSubmit = new javax.swing.JButton();
        createEmail = new javax.swing.JLabel();
        createDOB = new javax.swing.JLabel();
        createFirstField = new javax.swing.JTextField();
        createLastField = new javax.swing.JTextField();
        createEmailField = new javax.swing.JTextField();
        createBirthField = new javax.swing.JTextField();
        createBirthExample = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createHeader.setText("Create Your Profile");

        createFirst.setText("First Name");

        createLast.setText("Last Name");

        createSubmit.setText("Submit");
        createSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSubmitActionPerformed(evt);
            }
        });

        createEmail.setText("E-mail");

        createDOB.setText("Birth Date");

        createBirthExample.setText("mm/dd/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(createHeader)
                            .addComponent(createSubmit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createFirstField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createLast)
                                    .addComponent(createEmail)
                                    .addComponent(createDOB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createBirthField)
                                    .addComponent(createLastField)
                                    .addComponent(createEmailField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createBirthExample)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createHeader)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createFirst)
                    .addComponent(createFirstField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createLast)
                    .addComponent(createLastField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createEmail)
                    .addComponent(createEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createDOB)
                    .addComponent(createBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createBirthExample))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(createSubmit)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSubmitActionPerformed
        try{
        Database create = new Database();
        if(createFirstField.getText().isEmpty()||createLastField.getText().isEmpty()||createEmailField.getText().isEmpty()||createBirthField.getText().isEmpty())
        {}
        else
        	create.writeUser(createFirstField.getText() + " " + createLastField.getText()
        					+":"+createEmailField.getText()+":"+createBirthField.getText()+"%0"+"[]");
        	new CheckinScreen().setVisible(true);
        	setVisible(false);	
        }
        catch(IOException e){
        }    
    
    
    }//GEN-LAST:event_createSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateProfile("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createBirthExample;
    private javax.swing.JTextField createBirthField;
    private javax.swing.JLabel createDOB;
    private javax.swing.JLabel createEmail;
    private javax.swing.JTextField createEmailField;
    private javax.swing.JLabel createFirst;
    private javax.swing.JTextField createFirstField;
    private javax.swing.JLabel createHeader;
    private javax.swing.JLabel createLast;
    private javax.swing.JTextField createLastField;
    private javax.swing.JButton createSubmit;
    // End of variables declaration//GEN-END:variables
}
