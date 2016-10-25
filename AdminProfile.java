import javax.swing.JList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author letzo
 */
public class AdminProfile extends javax.swing.JFrame {

	private String name;
	private static String event;
    public AdminProfile(String fromLogin) {
    	name = fromLogin;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminHeader = new javax.swing.JLabel();
        adminTabPanel = new javax.swing.JTabbedPane();
        adminUserPanel = new javax.swing.JPanel();
        adminUserSearch = new javax.swing.JLabel();
        adminUserSearchField = new javax.swing.JTextField();
        adminUserNameList = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        adminEventPanel = new javax.swing.JPanel();
        adminEventHeader = new javax.swing.JLabel();
        adminEventList = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        adminEventEdit = new javax.swing.JButton();
        adminEventEnd = new javax.swing.JButton();
        adminEventCreate = new javax.swing.JButton();
        adminEventStart = new javax.swing.JButton();
        adminStatPanel = new javax.swing.JPanel();
        adminStatHeader = new javax.swing.JLabel();
        adminStatEventMenu = new javax.swing.JComboBox<>();
        adminStatEvent = new javax.swing.JLabel();
        adminStatAgeMenu = new javax.swing.JComboBox<>();
        adminStatData = new javax.swing.JLabel();
        adminStatReport = new javax.swing.JLabel();
        adminStatPopular = new javax.swing.JCheckBox();
        adminStatAverage = new javax.swing.JCheckBox();
        adminStatBest = new javax.swing.JCheckBox();
        adminStatGenerate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminHeader.setText("Event Management");

        adminUserSearch.setText("Search Members:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        adminUserNameList.setViewportView(jTextArea1);

        javax.swing.GroupLayout adminUserPanelLayout = new javax.swing.GroupLayout(adminUserPanel);
        adminUserPanel.setLayout(adminUserPanelLayout);
        adminUserPanelLayout.setHorizontalGroup(
            adminUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(adminUserNameList)
                    .addGroup(adminUserPanelLayout.createSequentialGroup()
                        .addComponent(adminUserSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminUserSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        adminUserPanelLayout.setVerticalGroup(
            adminUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminUserSearch)
                    .addComponent(adminUserSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminUserNameList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        adminTabPanel.addTab("Users", adminUserPanel);

        adminEventHeader.setText("Event List");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Event 1", "Event 2", "Event 3", "Event 4" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        
        adminEventList.setViewportView(jList1);

        adminEventEdit.setText("Edit");

        adminEventEnd.setText("End Event");

        adminEventCreate.setText("Create New Event");

        adminEventStart.setText("Start Event");

        javax.swing.GroupLayout adminEventPanelLayout = new javax.swing.GroupLayout(adminEventPanel);
        adminEventPanel.setLayout(adminEventPanelLayout);
        adminEventPanelLayout.setHorizontalGroup(
            adminEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminEventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminEventHeader)
                    .addGroup(adminEventPanelLayout.createSequentialGroup()
                        .addComponent(adminEventList, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(adminEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(adminEventStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminEventEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminEventEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(adminEventCreate)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        adminEventPanelLayout.setVerticalGroup(
            adminEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminEventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminEventHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminEventList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(adminEventPanelLayout.createSequentialGroup()
                        .addGroup(adminEventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminEventEdit)
                            .addComponent(adminEventCreate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminEventStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminEventEnd)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        adminTabPanel.addTab("Events", adminEventPanel);

        adminStatHeader.setText("Generate Event Statistics");

        adminStatEventMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fundraiser", "study", "?", "?" }));
        adminStatEventMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminStatEventMenuActionPerformed(evt);
            }
        });

        adminEventStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminEventStartActionPerformed(evt);
            }
        });        

        adminEventEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminEventEndActionPerformed(evt);
            }
        });  
        
        adminStatEvent.setText("Event Type");

        adminStatAgeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Age", "Attendance", "Day", "Frequency" }));
        adminStatAgeMenu.setToolTipText("");

        adminStatData.setText("Data Type");

        adminStatReport.setText("Event Reports");

        adminStatPopular.setText("Popular");

        adminStatAverage.setText("Averages");

        adminStatBest.setText("YTD Best");

        adminStatGenerate.setText("Generate!");
        adminStatGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminStatGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminStatPanelLayout = new javax.swing.GroupLayout(adminStatPanel);
        adminStatPanel.setLayout(adminStatPanelLayout);
        adminStatPanelLayout.setHorizontalGroup(
            adminStatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminStatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminStatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminStatPanelLayout.createSequentialGroup()
                        .addGroup(adminStatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminStatEventMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminStatEvent))
                        .addContainerGap(294, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminStatPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(adminStatHeader)
                        .addGap(117, 117, 117))
                    .addGroup(adminStatPanelLayout.createSequentialGroup()
                        .addGroup(adminStatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminStatAverage)
                            .addComponent(adminStatPopular)
                            .addComponent(adminStatAgeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminStatData)
                            .addComponent(adminStatReport))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(adminStatPanelLayout.createSequentialGroup()
                        .addComponent(adminStatBest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminStatGenerate))))
        );
        adminStatPanelLayout.setVerticalGroup(
            adminStatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminStatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminStatHeader)
                .addGap(3, 3, 3)
                .addComponent(adminStatEvent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminStatEventMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(adminStatData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminStatAgeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adminStatReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminStatPopular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminStatAverage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminStatBest)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminStatPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(adminStatGenerate))
        );

        adminTabPanel.addTab("Statistics", adminStatPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminHeader)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addComponent(adminTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(adminHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminTabPanel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminStatEventMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminStatEventMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminStatEventMenuActionPerformed

    private void adminStatGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminStatGenerateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminStatGenerateActionPerformed

    private void adminEventStartActionPerformed(java.awt.event.ActionEvent evt) {
    	event = jList1.getSelectedValue();
    	setVisible(false);
    	new CheckinScreen().setVisible(true);
    }

    private void adminEventEndActionPerformed(java.awt.event.ActionEvent evt) {
    	event = "";
    	setVisible(false);
    	new CheckinScreen().setVisible(true);
    }
    
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    

    }
    

    public static String getEvent(){
    	return event;
    }
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
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminProfile("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminEventCreate;
    private javax.swing.JButton adminEventEnd;
    private javax.swing.JButton adminEventStart;
    private javax.swing.JButton adminEventEdit;
    private javax.swing.JLabel adminEventHeader;
    private javax.swing.JScrollPane adminEventList;
    private javax.swing.JPanel adminEventPanel;
    private javax.swing.JLabel adminHeader;
    private javax.swing.JComboBox<String> adminStatAgeMenu;
    private javax.swing.JCheckBox adminStatAverage;
    private javax.swing.JCheckBox adminStatBest;
    private javax.swing.JLabel adminStatData;
    private javax.swing.JLabel adminStatEvent;
    private javax.swing.JComboBox<String> adminStatEventMenu;
    private javax.swing.JButton adminStatGenerate;
    private javax.swing.JLabel adminStatHeader;
    private javax.swing.JPanel adminStatPanel;
    private javax.swing.JCheckBox adminStatPopular;
    private javax.swing.JLabel adminStatReport;
    private javax.swing.JTabbedPane adminTabPanel;
    private javax.swing.JScrollPane adminUserNameList;
    private javax.swing.JPanel adminUserPanel;
    private javax.swing.JLabel adminUserSearch;
    private javax.swing.JTextField adminUserSearchField;
    private javax.swing.JList<String> jList1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
