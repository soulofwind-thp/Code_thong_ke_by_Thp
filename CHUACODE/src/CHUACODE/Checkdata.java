package CHUACODE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Checkdata extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkdata frame = new Checkdata();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection= con();
private JScrollPane scrollPane;
private JScrollPane scrollPane_1;
	/**
	 * Create the frame.
	 */
	public Checkdata() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from quanlisanpham123";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch ( Exception e) {
	            	e.printStackTrace();
				}
			}
		});
		btnLoadTable.setBounds(605, 29, 202, 34);
		contentPane.add(btnLoadTable);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 133, 859, 372);
		contentPane.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	 static Connection con() {
    	 try {
            	
            	String dbURL = "jdbc:sqlserver://localhost;databaseName=quanlisanpham" ;
                String user = "sa";
                String pass = "tranhuyphong";
                System.out.println("WOW. SEVER ĐÃ ĐƯỢC KẾT NỐI THÀNH CÔNG RỒI NÈ <3 ");
                return DriverManager.getConnection(dbURL, user, pass);
            	//Connection connection = DriverManager.getConnection(dbURL, user, pass);
            	
            //System.out.println("WOW. SEVER ĐÃ ĐƯỢC KẾT NỐI THÀNH CÔNG RỒI NÈ <3 ");
            }
            catch (SQLException e) 
            {
            	System.out.println("HUHU , KHÔNG ỔN RỒI, SAI ĐÂU RỒI, KẾT NỐI KHÔNG THÀNH CÔNG RỒI :( ");
        }
		return null;
	}
}
