import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frmEmergencyRoom;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmEmergencyRoom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmergencyRoom = new JFrame();
		frmEmergencyRoom.setTitle("Emergency Room ");
		frmEmergencyRoom.setBounds(100, 100, 451, 328);
		frmEmergencyRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmergencyRoom.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 11, 140, 269);
		frmEmergencyRoom.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Controls");
		lblNewLabel.setBounds(35, 11, 51, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Add Patient...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 39, 120, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search Patient...");
		btnNewButton_1.setBounds(10, 73, 120, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Patient...");
		btnNewButton_2.setBounds(10, 107, 120, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Patient...");
		btnNewButton_3.setBounds(10, 141, 120, 23);
		panel.add(btnNewButton_3);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3}));
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(156, 11, 269, 269);
		frmEmergencyRoom.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPatientDetails = new JLabel("Patient Details");
		lblPatientDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientDetails.setBounds(10, 11, 96, 14);
		panel_1.add(lblPatientDetails);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(10, 36, 54, 14);
		panel_1.add(lblPatientId);
		
		JLabel lblIssue = new JLabel("Issue");
		lblIssue.setBounds(10, 86, 54, 14);
		panel_1.add(lblIssue);
		
		JLabel lblUrgent = new JLabel("Urgent?");
		lblUrgent.setBounds(10, 111, 54, 14);
		panel_1.add(lblUrgent);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 141, 252, 117);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMedicalCard = new JLabel("Medical Card");
		lblMedicalCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicalCard.setBounds(10, 11, 96, 14);
		panel_2.add(lblMedicalCard);
		
		JLabel lblNameOnCard = new JLabel("Name On Card");
		lblNameOnCard.setBounds(10, 36, 70, 14);
		panel_2.add(lblNameOnCard);
		
		JLabel lblCardNo = new JLabel("Card No.");
		lblCardNo.setBounds(10, 61, 70, 14);
		panel_2.add(lblCardNo);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(10, 86, 70, 14);
		panel_2.add(lblDoctor);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 33, 124, 20);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(90, 58, 124, 20);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(90, 83, 124, 20);
		panel_2.add(textField_6);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 61, 54, 14);
		panel_1.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(74, 33, 124, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 58, 124, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 83, 124, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 108, 124, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_4, textField_5, textField_6, textField, textField_1, textField_2, textField_3}));
	}
}
