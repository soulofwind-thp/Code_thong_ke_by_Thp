package CHUACODE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class table {

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table window = new table();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public table() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Showdata();
			}
		});
		frame.setBounds(100, 100, 1058, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 149, 1022, 376);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("DEATH IS LIKE THE WIND ALWAYS BY MY SIDE !\r\nHasagi");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(205, 11, 699, 84);
		frame.getContentPane().add(lblNewLabel);
	}

	public void Showdata() {
		
		try {
			
			
			Connection con = con();
             DefaultTableModel model = new DefaultTableModel();
        	 model.addColumn("Mã sản phẩm");
        	 model.addColumn("Tên sản phẩm");
        	 model.addColumn("Số lượng");
        	 model.addColumn("Nguồn gốc");
        	 model.addColumn("Giá tiền");
             try {
            	 String query = "select * from <name_table>";
                Statement st = con.createStatement();
            	 ResultSet rs = st.executeQuery(query);
            	 
            	 while (rs.next()) {
            		 model.addRow(new Object[] {
            				 rs.getString("id"),
            				 rs.getString("name"),
            				 rs.getString("amount"),
            				 rs.getString("origin"),
            				 rs.getString("price"),
            		 });
            	 }
            	 rs.close();
            	  st.close();
            	 con.close();
            	 
            	 table.setModel(model);
            	 table.setAutoResizeMode(1);
            	 
            	
            	 
             }
             catch (Exception e) {
            	 
            	System.out.println("Lỗi " + e);
             }
			
			
			
		} catch ( Exception e) {
        	e.printStackTrace();
		}
	}
	
	static Connection con() {
   	 try {
           	
           	String dbURL = "jdbc:sqlserver://localhost;databaseName=?" ;
               String user = "sa";
               String pass = "?";
               System.out.println("WOW. SEVER ĐÃ ĐƯỢC KẾT NỐI THÀNH CÔNG RỒI NÈ <3 ");
               return DriverManager.getConnection(dbURL, user, pass);
           
           }
           catch (SQLException e) 
           {
           	System.out.println("HUHU , KHÔNG ỔN RỒI, SAI ĐÂU RỒI, KẾT NỐI KHÔNG THÀNH CÔNG RỒI :( ");
       }
		return null;
	}
	}
