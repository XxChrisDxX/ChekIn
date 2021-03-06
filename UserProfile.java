import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author letzo
 */
public class UserProfile extends javax.swing.JFrame {

	private String name;
	private String uHost, uEmail, uPassword;

	public UserProfile(String fromLogin) {
		name = fromLogin;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		userHeader = new javax.swing.JLabel();
		userEmail = new javax.swing.JLabel();
		userEmailField = new javax.swing.JTextField();
		userPhoneField = new javax.swing.JTextField();
		userUpdatePhone = new javax.swing.JButton();
		userUpdate = new javax.swing.JButton();
		userFeedback = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		userRSVP = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		userHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		userHeader.setText("MyProfile");

		userEmail.setText("New E-Mail");

		userUpdate.setText("Update E-Mail");

		userFeedback.setText("Send Feedback");

		userUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userUpdateActionPerformed(evt);
			}
		});

		userUpdatePhone.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userUpdatePhoneActionPerformed(evt);
			}
		});

		userRSVP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userRSVPActionPerformed(evt);
			}
		});

		userFeedback.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userFeedbackActionPerformed(evt);
			}
		});

		jList1.addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						jList1ValueChanged(evt);
					}
				});
		// sets up list for event selection in combobox
		try {
			Database eventlist = new Database();
			String[] strings = new String[eventlist.readEventList().size()];
			for (int i = 0; i < strings.length; i++) {
				strings[i] = eventlist.readEventList().get(i);
			}
			jList1.setModel(new javax.swing.AbstractListModel<String>() {
				public int getSize() {
					return strings.length;
				}

				public String getElementAt(int i) {
					return strings[i];
				}
			});
		} catch (IOException e) {

		}
		jScrollPane1.setViewportView(jList1);

		userRSVP.setText("RSVP");

		jLabel1.setText("Event List");

		jLabel2.setText("New Phone");

		userUpdatePhone.setText("Update Phone");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap().addGroup(
								layout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING,
										false).addComponent(userEmailField,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												162, Short.MAX_VALUE)
										.addComponent(userEmail).addComponent(
												jLabel2).addComponent(
														userUpdatePhone)
										.addComponent(userPhoneField)
										.addComponent(userUpdate))
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								40, Short.MAX_VALUE).addGroup(layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup()
														.addComponent(jLabel1)
														.addGap(69, 69, 69))
										.addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup()
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																174,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap())))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
						.createSequentialGroup().addContainerGap().addComponent(
								userFeedback).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(userRSVP,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												110,
												javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(43, 43, 43)).addGroup(layout
								.createSequentialGroup().addGap(169, 169, 169)
								.addComponent(userHeader).addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap().addComponent(
								userHeader).addGap(25, 25, 25).addGroup(layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(userEmail).addComponent(
												jLabel1)).addGap(12, 12, 12)
						.addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(userEmailField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(userUpdate)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												32, Short.MAX_VALUE)
										.addComponent(jLabel2).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(userPhoneField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(userUpdatePhone).addGap(
												15, 15, 15)).addComponent(
														jScrollPane1)).addGap(
																18, 18, 18)
						.addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(userRSVP).addComponent(
										userFeedback)).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void userUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		String email = userEmailField.getText();
		try {
			Database update = new Database();
			update.writeEmail(name, email);
			setVisible(false);
			new CheckinScreen().setVisible(true);
		} catch (IOException e) {

		}

	}

	private void userUpdatePhoneActionPerformed(
			java.awt.event.ActionEvent evt) {
		String phone = userPhoneField.getText();
		try {
			Database update = new Database();
			update.writePhone(name, phone);
			setVisible(false);
			new CheckinScreen().setVisible(true);
		} catch (IOException e) {

		}

	}

	private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {

	}

	private void userRSVPActionPerformed(java.awt.event.ActionEvent evt) {
		String event = jList1.getSelectedValue();

		try {
			Database valid = new Database();
	        
	        if(valid.attendEvent(name, event)){
	        	valid.writeEvent(name, event);
	        	JOptionPane.showMessageDialog(null,
	    				"You are now RSVP'd for this event: " + event,
	    				"Success!",
	    				JOptionPane.INFORMATION_MESSAGE);
	        } else {
	        	JOptionPane.showMessageDialog(null,
	    				"You already RSVP'd for this event.",
	    				"Notice",
	    				JOptionPane.INFORMATION_MESSAGE);
	        }
		} catch (IOException e) {

		}

	}

	private void userFeedbackActionPerformed(java.awt.event.ActionEvent evt) {

		// HI IM WHERE USER WOULD LIKE TO SEND FEEDBACK TO ADMIN.
		// SINCE THIS USER IS LOGGED IN THEIR NAME IS STORED UNDER....NAME
		// VARIABLE ALREADY FOR SIGNING WHERE EMAIL HAS BEEN SENT FROM.
		// NO NEED TO STORE EMAILS LOCALLY JUST HAVE THEM STORED IN EMAIL ACCT.
		// AS FAR AS RSVP I DUNNO. IT WOULD HAVE TO BE SEPERATE FROM EMAIL.
		// MAYBE A BUTTON ON USER PROFILE...BUT THEN THEY WOULD HAVE TO HAVE A
		// LIST OF EVENTS IN USER PROFILE....DOABLE YES....
		try {
			Database valid = new Database();
	        
			uEmail = valid.readEmail(name);
			String line = uEmail;
			int length = line.length();
			int beg = 0;
			
			for(int i = 0; i<length;i++){
				if(line.charAt(i)=='@'){
					beg = i;
				}
				if(beg != 0){
					uHost = "smtp." + line.substring(beg+1, length);
					break;
				}
			}
		} catch (IOException e) {

		}
		uPassword = JOptionPane.showInputDialog("Enter password for email address.");				
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	File properties = new File("smtp.properties");
            	properties.delete();
                new SwingEmailSender(uHost, uEmail, uPassword).setVisible(true);
            }
        });

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UserProfile("").setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField userPhoneField;
	private javax.swing.JButton userUpdatePhone;
	private javax.swing.JList<String> jList1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel userEmail;
	private javax.swing.JTextField userEmailField;
	private javax.swing.JButton userFeedback;
	private javax.swing.JLabel userHeader;
	private javax.swing.JButton userRSVP;
	private javax.swing.JButton userUpdate;
	// End of variables declaration//GEN-END:variables
}
