package CHUACODE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;

public class Code_demo_by_Thp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code_demo_by_Thp frame = new Code_demo_by_Thp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

private JTable table;
private JTextField xid;
private JTextField xname;
private JTextField xamount;
private JTextField xorigin;
private JTextField xprice;
private JTextField seach;
private JComboBox comboBox;
	/**
	 * Create the frame.
	 */
public void resetData()
             {
	try {
		
		Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
		
		
         DefaultTableModel model = new DefaultTableModel();
    	 model.addColumn("Mã sản phẩm (Id)");
    	 model.addColumn("Tên sản phẩm (Name)");
    	 model.addColumn("Số lượng");
    	 model.addColumn("Nguồn gốc (Amount)");
    	 model.addColumn("Giá tiền");
         try {
        	 String query = "select * from Tablepro";
            Statement st = connection.createStatement();
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
	

	public Code_demo_by_Thp() {
		addWindowListener(new WindowAdapter() {
			
			public void windowOpened(WindowEvent e) {
				Showdata();
				
			}
		});


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show all not Thống kê");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		btnNewButton.setBounds(676, 197, 199, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 242, 856, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
					int row=table.getSelectedRow();
					String id_=(table.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from Tablepro where id='"+id_+"'  ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						xid.setText(rs.getString("id"));
						xname.setText(rs.getString("name"));
						xamount.setText(rs.getString("amount"));
						xorigin.setText(rs.getString("origin"));
						xprice.setText(rs.getString("price"));
						
					}
					
					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		xid = new JTextField();
		xid.setBounds(113, 54, 86, 20);
		contentPane.add(xid);
		xid.setColumns(10);
		
		xname = new JTextField();
		xname.setBounds(113, 85, 86, 20);
		contentPane.add(xname);
		xname.setColumns(10);
		
		xamount = new JTextField();
		xamount.setBounds(113, 126, 86, 20);
		contentPane.add(xamount);
		xamount.setColumns(10);
		
		xorigin = new JTextField();
		xorigin.setBounds(113, 167, 86, 20);
		contentPane.add(xorigin);
		xorigin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("mã sp");
		lblNewLabel.setBounds(35, 57, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("tên sp");
		lblNewLabel_1.setBounds(35, 88, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("số lượng");
		lblNewLabel_2.setBounds(32, 129, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("nguồn gốc");
		lblNewLabel_3.setBounds(10, 170, 87, 14);
		contentPane.add(lblNewLabel_3);
		
		xprice = new JTextField();
		xprice.setBounds(113, 198, 86, 20);
		contentPane.add(xprice);
		xprice.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("giá tiền");
		lblNewLabel_4.setBounds(32, 201, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (xid.getText().equals("")||xname.getText().equals("")||xamount.getText().equals("")||xorigin.getText().equals("")||xprice.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin !");
					}
				else {
				try {
					Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
					
					String query = "insert into Tablepro (id,name,amount,origin,price) values (?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
				    pst.setString(1,xid.getText());
				    pst.setString(2,xname.getText());
				    pst.setString(3,xamount.getText());
				    pst.setString(4,xorigin.getText());
				    pst.setString(5,xprice.getText());
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Thêm thành công");
					pst.close();
				
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				resetData();
			}}
		});
		btnNewButton_1.setBounds(260, 84, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				if (i>=0) {
				int action=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa ? Dữ liệu sẽ không thể khôi phục . Vẫn xóa ?","Xóa",JOptionPane.YES_NO_OPTION);
				
				if(action==0) {
				try {
					Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
					
					String query = "delete from Tablepro where id='"+xid.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
				
					JOptionPane.showMessageDialog(null,"Đã xóa");
					pst.close();
				
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				resetData();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm để loại bỏ !");
				}
				
			}
		});
		btnNewButton_2.setBounds(260, 129, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				if (i>=0) {
				try {
					Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
					
					String query = "Update Tablepro set id='"+xid.getText()+"',name='"+xname.getText()+"',amount='"+xamount.getText()+"',origin='"+xorigin.getText()+"',price='"+xprice.getText()+"' where id='"+xid.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
				   
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Update thành công");
					pst.close();
				
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				resetData();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn sản phẩm để update !");
				}
			}
				
		});
		btnNewButton_3.setBounds(260, 184, 89, 23);
		contentPane.add(btnNewButton_3);
		
		seach = new JTextField();
		seach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
					String selection = (String)comboBox.getSelectedItem();
					
					String query = "select * from Tablepro where "+selection+"=? ";
					
				    System.out.println(query);
				    
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1,seach.getText());
					
					ResultSet rs = pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
                   
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		seach.setBounds(676, 123, 199, 20);
		contentPane.add(seach);
		seach.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setName("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"id", "name", "origin"}));
		comboBox.setBounds(564, 125, 86, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_4 = new JButton("Đóng");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn thoát","Đóng",JOptionPane.YES_NO_OPTION);
				if(action==0) {
				System.exit(0);
			}
			}
		});
		btnNewButton_4.setBounds(440, 503, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("DEATH IS LIKE THE WIN ALWAYS BY MY SIDE\r\n");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(408, 25, 467, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Hotline : 0999999999");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_6.setBounds(764, 507, 137, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("www.thesylphstore.com.vn");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(45, 507, 258, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tìm Kiếm");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(554, 103, 71, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tự edit đi mấy đứa con giời");
		lblNewLabel_9.setForeground(Color.MAGENTA);
		lblNewLabel_9.setBounds(376, 88, 174, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Chưa có thống kê đâu\r\n");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(402, 133, 137, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Có gì sai đâu các b sửa cho mìn <3");
		lblNewLabel_11.setForeground(new Color(0, 0, 255));
		lblNewLabel_11.setBounds(386, 170, 211, 14);
		contentPane.add(lblNewLabel_11);
		resetData();
	}
	
	
public void Showdata() {
		
		try {
			
			Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=quanlisanpham","sa","tranhuyphong");
			
			
             DefaultTableModel model = new DefaultTableModel();
             model.addColumn("Mã sản phẩm (Id)");
        	 model.addColumn("Tên sản phẩm (Name)");
        	 model.addColumn("Số lượng");
        	 model.addColumn("Nguồn gốc (Amount)");
        	 model.addColumn("Giá tiền");
             try {
            	 String query = "select * from Tablepro";
                Statement st = connection.createStatement();
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
}
