package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Connection.DBController;

import java.awt.Color;

public class Register extends JFrame {
	
	
	public Register() {
		Container con = getContentPane();
		JLabel lbbg = new JLabel();
		lbbg.setIcon(new ImageIcon(Register.class.getResource("/background/san1.jpg")));
		lbbg.setSize(1000,505);
		
		JPanel pnmain = new JPanel();
		pnmain.setBounds(380, 200, 500, 300);
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
        
		
		JPanel pn1 = new JPanel();
		pn1.setForeground(new Color(255, 255, 255));
		FlowLayout flpn1 = new FlowLayout();
		flpn1.setVgap(20);
		pn1.setLayout(flpn1);
		pn1.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt     
		
		JPanel pn2 = new JPanel();
		GridLayout grpn2 = new GridLayout(3,2);
		grpn2.setHgap(-200);
		grpn2.setVgap(50);
		pn2.setLayout(grpn2);
		pn2.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt 
        
		
		JPanel pn3 = new JPanel();
		FlowLayout flpn3 = new FlowLayout();
		flpn3.setHgap(20);
		flpn3.setVgap(20);
		pn3.setLayout(flpn3);
		pn3.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt 
       
		
		JLabel lbregisnow = new JLabel("REGISTER NOW");
		lbregisnow.setFont(new Font("Arial", Font.BOLD, 18));
		lbregisnow.setForeground(new Color(50, 205, 50));
		JLabel lbuser = new JLabel("Username");
		lbuser.setForeground(new Color(0, 0, 255));
		lbuser.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lbpass = new JLabel("Password");
		lbpass.setForeground(new Color(0, 0, 255));
		lbpass.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lbconfirm = new JLabel("Confirm Password");
		lbconfirm.setForeground(new Color(220, 20, 60));
		lbconfirm.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lbregis = new JLabel("New User? Register here");
		lbregis.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lbregis.setForeground(new Color(153, 204, 102));

		final JTextField tfuser = new JTextField();
		final JTextField tfpass = new JTextField();
		final JTextField tfconfirm = new JTextField();
		
		JButton jbback = new JButton("BACK");
		jbback.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton jbregis = new JButton("REGISTER");
		jbregis.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jbregis.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
				
				if (tfpass.getText().equals(tfconfirm.getText())) {
					String sql = "INSERT INTO account VALUES (?, ?)";
					try {
						Connection con = new DBController().getConnection();
						PreparedStatement stm = con.prepareStatement(sql);
						stm.setString(1, tfuser.getText());
						stm.setString(2, tfpass.getText());
						stm.execute();
						JOptionPane.showMessageDialog(null, "Đăng ký thành công");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu chưa nhập");
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Hai mật khẩu không giống nhau");
				}
			}
		});
		
		jbback.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login();
				setVisible(false);
			}
		});
		
		pn1.add(lbregisnow);
		pn2.add(lbuser);
		pn2.add(tfuser);
		pn2.add(lbpass);
		pn2.add(tfpass);
		pn2.add(lbconfirm);
		pn2.add(tfconfirm);
		
		pn3.add(jbregis);
		pn3.add(jbback);
		
		
		pnmain.add(pn1, BorderLayout.NORTH);
		pnmain.add(pn2, BorderLayout.CENTER);
		pnmain.add(pn3, BorderLayout.SOUTH);
		con.add(pnmain);
		con.add(lbbg);
		
		setSize(1280,750);
		setTitle("Register");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Register();
	}

}
