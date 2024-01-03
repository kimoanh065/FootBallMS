package View;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import Connection.DBController;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Login_view extends JFrame {
	
	JPanel pn1 = new JPanel();
	
	JPanel pn2 = new JPanel();
	
	JLabel lblogin = new JLabel("Welcome to Football Management System");
	JLabel lbemail = new JLabel("Tài khoản");
	JLabel lbpass = new JLabel ("Mật khẩu");
	
	JTextField tfemail = new JTextField();
	JPasswordField tfpass = new JPasswordField();
	
	JLabel lbicon = new JLabel();
	
	JLabel lbcomment = new JLabel("Nếu bạn chưa có tài khoản");
	
	JButton jblogin = new JButton("Đăng nhập");
	JButton jbdk = new JButton("Đăng ký");
	
	
	public Login_view() {
		Container con = this.getContentPane();
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		
		pn1.setBackground(Color.WHITE);
		pn1.setBounds(0, 0, 154, 263);
		pn1.setForeground(Color.WHITE);
		con.add(pn1);
		pn1.setLayout(null);
		lbicon.setBackground(Color.WHITE);
		lbicon.setForeground(Color.WHITE);
		lbicon.setBounds(0, 0, 154, 263);
		lbicon.setHorizontalAlignment(SwingConstants.CENTER);
		lbicon.setFont(new Font("Tahoma", Font.PLAIN, 6));
		lbicon.setIcon(new ImageIcon("C:\\Users\\kimoa\\Downloads\\V.League_1_new_logo.svg (1).png"));
		pn1.add(lbicon);
		
		pn2.setBackground(new Color(224, 255, 255));
		pn2.setBounds(0, 0, 586, 263);
		con.add(pn2);
		pn2.setLayout(null);
		
		lbemail.setForeground(new Color(220, 20, 60));
		lbemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbemail.setBounds(175, 80, 70, 13);
		
		pn2.add(lbemail);
		lbpass.setForeground(new Color(0, 191, 255));
		lbpass.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbpass.setBounds(175, 125, 70, 13);
		pn2.add(lbpass);
		tfemail.setBounds(243, 77, 291, 19);
		pn2.add(tfemail);
		tfpass.setBounds(243, 122, 291, 19);
		pn2.add(tfpass);
		
		pn2.add(lblogin);
		lblogin.setBackground(new Color(255, 255, 255));
		lblogin.setForeground(new Color(50, 205, 50));
		lblogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblogin.setSize(373, 30);
		lblogin.setLocation(184, 25);
		jbdk.setBackground(new Color(233, 150, 122));
		jbdk.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jbdk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new test_resgister();
				
			}
		});
		
		pn2.add(jbdk);
		jbdk.setLocation(384, 223);
		jbdk.setSize(88, 30);
		jblogin.setBackground(new Color(255, 255, 0));
		jblogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		pn2.add(jblogin);
		jblogin.setSize(107, 30);
		jblogin.setLocation(406, 164);
		lbcomment.setBackground(new Color(255, 255, 255));
		lbcomment.setForeground(new Color(255, 69, 0));
		lbcomment.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lbcomment.setSize(137, 30);
		lbcomment.setLocation(237, 224);
		pn2.add(lbcomment);
		
		
		jblogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Connection con = new DBController().getConnection();
				String sql = "Select * from account WHERE taikhoan = ? AND matkhau = ?";
				PreparedStatement stm;
				
			try {
				stm = con.prepareStatement(sql);
				stm.setString(1, tfemail.getText());
				stm.setString(2, tfpass.getText());
				ResultSet rs = stm.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					setVisible(false);
					new MainGUI();
				}
				else 
					JOptionPane.showMessageDialog(null, "Tài khoản và mật khẩu không đúng");
			} catch (SQLException e1) {
				// TODO: handle exception
			}
			}
		});
		
		
		setSize(600,300);
		setTitle("Login");
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Login_view();
	}
	

}
