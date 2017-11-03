import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.bson.Document;
//import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmergencyRoomGUI {

	private JFrame frmEmergencyRoom;
	private JTextField tbxPatientId;
	private JTextField tbxForename;
	private JTextField tbxIssue;
	private JTextField tbxCardNo;
	private JTextField tbxDoctor;
	private JTextField tbxSurname;
	private JCheckBox chckbxUrgent;
	private JTable tblData;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {				
				try {				
					EmergencyRoomGUI window = new EmergencyRoomGUI();
					window.frmEmergencyRoom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public EmergencyRoomGUI() throws Exception {		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmergencyRoom = new JFrame();
		frmEmergencyRoom.setResizable(false);
		frmEmergencyRoom.setTitle("Emergency Room ");
		frmEmergencyRoom.setBounds(100, 100, 602, 321);
		frmEmergencyRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmergencyRoom.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 11, 151, 271);
		frmEmergencyRoom.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Controls");
		lblNewLabel.setBounds(46, 11, 51, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Add Patient...");
		
		btnNewButton.setBounds(10, 39, 131, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search Patient...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchItem = JOptionPane.showInputDialog("Enter ");
				searchPatient(searchItem);
			}
		});
		btnNewButton_1.setBounds(10, 85, 131, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Patient...");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePatient();
			}
		});
		btnNewButton_2.setBounds(10, 131, 131, 35);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove Patient...");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removePatient();
			}
		});
		btnNewButton_3.setBounds(10, 177, 131, 35);
		panel.add(btnNewButton_3);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(167, 11, 269, 271);
		frmEmergencyRoom.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPatientDetails = new JLabel("Patient Details");
		lblPatientDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientDetails.setBounds(10, 11, 96, 14);
		panel_1.add(lblPatientDetails);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(10, 36, 62, 14);
		panel_1.add(lblPatientId);
		
		JLabel lblIssue = new JLabel("Issue");
		lblIssue.setBounds(10, 115, 62, 14);
		panel_1.add(lblIssue);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 168, 252, 93);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMedicalCard = new JLabel("Medical Card");
		lblMedicalCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicalCard.setBounds(10, 11, 96, 14);
		panel_2.add(lblMedicalCard);
		
		JLabel lblCardNo = new JLabel("Card No.");
		lblCardNo.setBounds(10, 39, 70, 14);
		panel_2.add(lblCardNo);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(10, 64, 70, 14);
		panel_2.add(lblDoctor);
		
		tbxCardNo = new JTextField();
		tbxCardNo.setColumns(10);
		tbxCardNo.setBounds(71, 37, 124, 20);
		panel_2.add(tbxCardNo);
		
		tbxDoctor = new JTextField();
		tbxDoctor.setColumns(10);
		tbxDoctor.setBounds(71, 62, 124, 20);
		panel_2.add(tbxDoctor);
		
		JLabel lblName = new JLabel("Forename");
		lblName.setBounds(10, 61, 62, 14);
		panel_1.add(lblName);
		
		tbxPatientId = new JTextField();
		tbxPatientId.setBounds(82, 30, 124, 20);
		panel_1.add(tbxPatientId);
		tbxPatientId.setColumns(10);
		
		tbxForename = new JTextField();
		tbxForename.setBounds(82, 55, 124, 20);
		panel_1.add(tbxForename);
		tbxForename.setColumns(10);
		
		tbxIssue = new JTextField();
		tbxIssue.setBounds(82, 109, 124, 20);
		panel_1.add(tbxIssue);
		tbxIssue.setColumns(10);
		
		chckbxUrgent = new JCheckBox("Urgent?");
		chckbxUrgent.setBounds(10, 136, 97, 23);
		panel_1.add(chckbxUrgent);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 89, 62, 14);
		panel_1.add(lblSurname);
		
		tbxSurname = new JTextField();
		tbxSurname.setColumns(10);
		tbxSurname.setBounds(82, 83, 124, 20);
		panel_1.add(tbxSurname);
		
		tblData = new JTable();
		tblData.setFillsViewportHeight(true);
		tblData.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PatientID", "Name", "Issue"
			}
		));
		tblData.setBounds(442, 11, 144, 271);
		frmEmergencyRoom.getContentPane().add(tblData);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPatient();
			}
		});
		
		fillTable();
	}
	
	public void addPatient() {
		try {

			MongoCollection<Document> collection = connectToDatabase();
			
			Document doc = new Document("patient", tbxPatientId.getText())	               
		               .append("forename", tbxForename.getText())
		               .append("surname", tbxSurname.getText())
		               .append("issue", tbxIssue.getText())
		               .append("urgent", chckbxUrgent.isSelected())
		               .append("medicalCard", new Document("cardNumber", tbxCardNo.getText())
	                           .append("doctor", tbxDoctor.getText()));
			collection.insertOne(doc);
	        
			JOptionPane.showMessageDialog(null, "Added new Patient", "Success", JOptionPane.INFORMATION_MESSAGE);	
	        System.out.println("Inserted value");	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Incorrect values entered: \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);			
		}

		clearGui();
		fillTable();
	}
	
	public Document searchPatient(String patientId){
		try{
			MongoCollection<Document> collection = connectToDatabase();
		
			String patient = "";
			String forename = "";
			String surname = "";
			String issue = "";
			boolean isUrgent = false;
			String cardNumber = "";
			String doctor = "";
			Document foundDocument = null;
			
			BasicDBObject query = new BasicDBObject();
			query.put("patient", patientId);
					
			for( Document document : collection.find(query) ) {
				foundDocument = document;
				patient = (String) document.get("patient");
				forename = (String) document.get("forename");
				surname = (String) document.get("surname");
				issue = (String) document.get("issue");
				isUrgent = (boolean) document.get("urgent");
				
				//nested
				Document medicalCard = (Document) document.get("medicalCard"); 
				
				cardNumber = (String) medicalCard.get("cardNumber");
				doctor = (String) medicalCard.get("doctor");
                   
			}
			
			tbxPatientId.setText(patient);
			tbxForename.setText(forename);
			tbxSurname.setText(surname);	
			tbxIssue.setText(issue);
			chckbxUrgent.setSelected(isUrgent);
			tbxCardNo.setText(cardNumber);
			tbxDoctor.setText(doctor);
			
			return foundDocument;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error Incorrect values entered: \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);		
		}
		return null;
	}
	
	public void updatePatient(){
		try {

			MongoCollection<Document> collection = connectToDatabase();
			
	        String searchedDocument = JOptionPane.showInputDialog("Enter patient Id of document to be updated ");
	        
	        BasicDBObject query = new BasicDBObject();
			query.put("patient", searchedDocument);
					
	        
			Document doc = new Document("patient", tbxPatientId.getText())	               
		               .append("forename", tbxForename.getText())
		               .append("surname", tbxSurname.getText())
		               .append("issue", tbxIssue.getText())
		               .append("urgent", chckbxUrgent.isSelected())
		               .append("medicalCard", new Document("cardNumber", tbxCardNo.getText())
	                           .append("doctor", tbxDoctor.getText()));
			collection.updateOne(query, new Document("$set", doc));
			
			JOptionPane.showMessageDialog(null, "Updated Patient", "Success", JOptionPane.INFORMATION_MESSAGE);	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, unable to update: \n" + e.getMessage(), "Unable to Update", JOptionPane.ERROR_MESSAGE);			
		}
			
		clearGui();
		fillTable();
	}
	
	public void removePatient() {
		try {
			MongoCollection<Document> collection = connectToDatabase();
		
			String searchedDocument = JOptionPane.showInputDialog("Enter patient Id of document to be deleted ");
		
			BasicDBObject query = new BasicDBObject();
			query.put("patient", searchedDocument);
			collection.deleteOne(query);
			
			JOptionPane.showMessageDialog(null, "Deleted Patient", "Success", JOptionPane.INFORMATION_MESSAGE);	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, unable to delete: \n" + e.getMessage(), "Unable to Delete", JOptionPane.ERROR_MESSAGE);
		}		
		
		clearGui();
		fillTable();
	}
	
	public void fillTable() {
		
		
		MongoCollection<Document> collection = connectToDatabase();
		
		DefaultTableModel model = (DefaultTableModel) tblData.getModel();
		
		model.setRowCount(0);
		
		Object[] headers = { "PatientID", "Name", "Issue" };
		model.addRow(headers);
		
		String patient = "";
		String forename = "";
		String surname = "";
		String issue = "";
		
		for( Document document : collection.find() ) {
			patient = (String) document.get("patient");
			forename = (String) document.get("forename");
			surname = (String) document.get("surname");
			issue = (String) document.get("issue");    
			
			Object[] data = { patient, surname + ", " + forename, issue };
			model.addRow(data);
		}
	}
	
	public MongoCollection<Document> connectToDatabase() {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("patients");        
		System.out.println("Connected to Database " + db.toString());
    
		MongoCollection<Document> collection = db.getCollection("patients");       
		System.out.println("Collection created successfully" + collection.toString());
		return collection;
		 
	}
	
	public void clearGui() {
		tbxPatientId.setText("");
		tbxForename.setText("");
		tbxSurname.setText("");
		tbxIssue.setText("");
		chckbxUrgent.setSelected(false);
		tbxCardNo.setText("");
		tbxDoctor.setText("");
	}
}
