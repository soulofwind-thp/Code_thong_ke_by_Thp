package CHUACODE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Code_thong_ke_by_Thp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JFrame frame;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code_thong_ke_by_Thp frame = new Code_thong_ke_by_Thp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Code_thong_ke_by_Thp() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Showdata();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Showdata1();
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 902, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH SẢN PHẨM CỬA HÀNG THE SYLPH");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(232, 11, 475, 56);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 137, 831, 146);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn thoát","Đóng",JOptionPane.YES_NO_OPTION);
				if(action==0) {
					
					dispose();
				//System.exit(0);
				
			}
			}
		});
		btnNewButton.setBounds(389, 510, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 338, 831, 146);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("DANH SÁCH SẢN PHẨM ĐÃ HẾT HÀNG");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(27, 313, 268, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DANH SÁCH SẢN PHẨM CÒN HÀNG");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(27, 112, 201, 14);
		contentPane.add(lblNewLabel_2);
	}
public void Showdata() {
		
		try {
			
			Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
			
			
             DefaultTableModel model = new DefaultTableModel();
             model.addColumn("Mã sản phẩm (Id)");
        	 model.addColumn("Tên sản phẩm (Name)");
        	 model.addColumn("Số lượng");
        	 model.addColumn("Nguồn gốc (Amount)");
        	 
             try {
            	 String query = "select id,name,amount,origin from Tablepro where amount > 0 ";
                Statement st = connection.createStatement();
            	 ResultSet rs = st.executeQuery(query);
            	 
            	 while (rs.next()) {
            		 model.addRow(new Object[] {
            				 rs.getString("id"),
            				 rs.getString("name"),
            				 rs.getString("amount"),
            				 rs.getString("origin"),
            				
            		 });
            	 }
            	 rs.close();
            	  st.close();
            	 connection.close();
            	 
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
public void Showdata1() {
	
	try {
		
		Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
		
		
         DefaultTableModel model = new DefaultTableModel();
         model.addColumn("Mã sản phẩm (Id)");
    	 model.addColumn("Tên sản phẩm (Name)");
    	 model.addColumn("Số lượng");
    	 model.addColumn("Nguồn gốc (Amount)");
    	 
         try {
        	 String query = "select id,name,amount,origin from Tablepro where amount <= 0 ";
            Statement st = connection.createStatement();
        	 ResultSet rs = st.executeQuery(query);
        	 
        	 while (rs.next()) {
        		 model.addRow(new Object[] {
        				 rs.getString("id"),
        				 rs.getString("name"),
        				 rs.getString("amount"),
        				 rs.getString("origin"),
        				
        		 });
        	 }
        	 rs.close();
        	  st.close();
        	 connection.close();
        	 
        	 table_1.setModel(model);
        	 table_1.setAutoResizeMode(1);
        	 
        	 
         }
         catch (Exception e) {
        	 
        	System.out.println("Lỗi " + e);
         }
		
		
		
	} catch ( Exception e) {
    	e.printStackTrace();
	}
}
}
