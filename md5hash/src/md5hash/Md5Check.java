package md5hash;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Md5Check {

	private JFrame frmMdHashChecker;
	private JTextField tfPath;
	private JComboBox<String> cbAlgorithm;
	private JTextField tfHash;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField tfCheck;
	private JLabel lblHash;
	private JLabel lblCheck;
	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Md5Check window = new Md5Check();
					window.frmMdHashChecker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Md5Check() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMdHashChecker = new JFrame();
		frmMdHashChecker.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMdHashChecker.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmMdHashChecker.setTitle("MD5 - SHA Checker (V0.2)");
		frmMdHashChecker.setSize(new Dimension(600, 200));
		frmMdHashChecker.setBounds(100, 100, 451, 166);
		frmMdHashChecker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMdHashChecker.getContentPane().setLayout(null);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFile.setBounds(10, 12, 48, 14);
		frmMdHashChecker.getContentPane().add(lblFile);
		
		tfPath = new JTextField();
		tfPath.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfPath.setBounds(56, 9, 272, 20);
		frmMdHashChecker.getContentPane().add(tfPath);
		tfPath.setColumns(40);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				chooseFile();
			}
		});
		btnChoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChoose.setBounds(335, 9, 89, 23);
		btnChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					chooseFile();
				}
			}
		});
		frmMdHashChecker.getContentPane().add(btnChoose);
		
		tfHash = new JTextField();
		tfHash.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfHash.setBounds(56, 38, 272, 20);
		frmMdHashChecker.getContentPane().add(tfHash);
		tfHash.setColumns(40);
		
		label = new JLabel("");
		label.setBounds(420, 64, 0, 0);
		frmMdHashChecker.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(424, 64, 0, 0);
		frmMdHashChecker.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(428, 64, 0, 0);
		frmMdHashChecker.getContentPane().add(label_2);
		
		cbAlgorithm = new JComboBox<>();
		cbAlgorithm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbAlgorithm.setBounds(335, 38, 89, 20);
		cbAlgorithm.setModel(new DefaultComboBoxModel<>(new String[] {"MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"}));
		cbAlgorithm.setSelectedIndex(0);
		frmMdHashChecker.getContentPane().add(cbAlgorithm);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				calcHash();
			}
		});
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == MouseEvent.BUTTON1) {
					calcHash();
				}
			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalculate.setBounds(335, 64, 89, 23);
		frmMdHashChecker.getContentPane().add(btnCalculate);
		
		tfCheck = new JTextField();
		tfCheck.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfCheck.setBounds(56, 67, 272, 20);
		frmMdHashChecker.getContentPane().add(tfCheck);
		tfCheck.setColumns(40);
		
		lblHash = new JLabel("Hash:");
		lblHash.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHash.setBounds(10, 41, 48, 14);
		frmMdHashChecker.getContentPane().add(lblHash);
		
		lblCheck = new JLabel("Check:");
		lblCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheck.setBounds(10, 68, 48, 14);
		frmMdHashChecker.getContentPane().add(lblCheck);
		
		// ... Choose file and hash algorithm before calculate!
		lblMessage = new JLabel("Choose file and hash algorithm befor calculate!");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setOpaque(true);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessage.setBackground(Color.GRAY);
		lblMessage.setBounds(10, 96, 415, 18);
		frmMdHashChecker.getContentPane().add(lblMessage);
	}
	
	/**
	 * Choose file
	 */
	private void chooseFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		
		int returnVal = fileChooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			tfPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
		}		
	}
	
	/**
	 * Calculate and display hash code
	 */
	private void calcHash(){
		tfCheck.setText("Calculation is running!");
		tfCheck.validate();
		Md5Hash mhash = new Md5Hash();
		tfCheck.setText(mhash.get(cbAlgorithm.getSelectedItem().toString(),tfPath.getText()));

		if (tfCheck.getText().compareTo(tfHash.getText())==0){
			lblMessage.setText("MATCH - The two hash values are the same.");
			lblMessage.setForeground(Color.BLACK);
			lblMessage.setBackground(Color.GREEN);
			tfHash.setForeground(Color.BLACK);
		} else {
			lblMessage.setText("MISMATCH - The two hash values are different!");
			lblMessage.setForeground(Color.BLACK);
			lblMessage.setBackground(Color.RED);
			tfHash.setForeground(Color.RED);
		}		
	}
}
/**
 * Useful links:
 * 
 * [1] https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#MessageDigest
 * 
 */

