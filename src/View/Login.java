package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connection.DBController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	public Login() {
		Container con = getContentPane();
		JLabel lbbg = new JLabel();
		lbbg.setIcon(new ImageIcon(Login.class.getResource("/background/san1.jpg")));
		lbbg.setSize(1000,505);
		
		JPanel pnmain = new JPanel();
		pnmain.setBounds(380, 200, 500, 300);
		pnmain.setLayout(new BorderLayout());
		pnmain.setOpaque(false);
        
		
		JPanel pnmain1 = new JPanel();
		pnmain1.setLayout(new BorderLayout());
        pnmain1.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt
		
		
		JPanel pnmain2 = new JPanel();
		FlowLayout flpn2 = new FlowLayout();
		flpn2.setHgap(10);
		pnmain2.setLayout(flpn2);
        pnmain2.setBackground(new Color(255, 255, 255, 100));  // Đặt màu nền trong suốt
		
		
		JPanel pn1 = new JPanel();
		pn1.setForeground(new Color(255, 255, 255));
		FlowLayout flpn1 = new FlowLayout();
		flpn1.setVgap(20);
		pn1.setLayout(flpn1);
		pn1.setOpaque(false);  // Đặt độ trong suốt
        
		
		
		JPanel pn2 = new JPanel();
		GridLayout gl_pn2 = new GridLayout(2,2);
		gl_pn2.setHgap(-300);
		gl_pn2.setVgap(50);
		pn2.setLayout(gl_pn2);
		pn2.setOpaque(false);  // Đặt độ trong suốt
        
		
		
		JPanel pn3 = new JPanel();
		FlowLayout flpn3 = new FlowLayout();
		flpn3.setVgap(30);
		pn3.setLayout(flpn3);
		pn3.setOpaque(false);  // Đặt độ trong suốt
       
		
		JLabel lbloginnow = new JLabel("LOGIN NOW");
		lbloginnow.setFont(new Font("Arial", Font.BOLD, 18));
		lbloginnow.setForeground(new Color(220, 20, 60));
		JLabel lbuser = new JLabel("Username");
		lbuser.setForeground(new Color(0, 0, 255));
		lbuser.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		JLabel lbpass = new JLabel("Password");
		lbpass.setForeground(new Color(0, 0, 255));
		lbpass.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		JLabel lbregis = new JLabel("New User? Register here");
		lbregis.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lbregis.setForeground(new Color(124, 252, 0));

		final JTextField tfuser = new JTextField();
		final JPasswordField tfpass = new JPasswordField();
		JButton jblogin = new JButton("LOGIN");
		jblogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton jbregis = new JButton("Register");
		
		
		pn1.add(lbloginnow);
		pn2.add(lbuser);
		pn2.add(tfuser);
		pn2.add(lbpass);
		pn2.add(tfpass);
		
		pn3.add(jblogin);
		
		pnmain1.add(pn1, BorderLayout.NORTH);
		pnmain1.add(pn2, BorderLayout.CENTER);
		pnmain1.add(pn3, BorderLayout.SOUTH);
		
		pnmain2.add(lbregis);
		pnmain2.add(jbregis);
		
		
		pnmain.add(pnmain1, BorderLayout.CENTER);
		pnmain.add(pnmain2, BorderLayout.SOUTH);
		con.add(pnmain);
		con.add(lbbg);
		
		jblogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = new DBController().getConnection();
				String sql = "Select * from account WHERE taikhoan = ? AND matkhau = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, tfuser.getText());
					stm.setString(2, tfpass.getText());
					ResultSet rs = stm.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						setVisible(false);
						new MainGUI();
					}
					else
						JOptionPane.showMessageDialog(null, "Tài khoản và mật khẩu không chính xác");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		jbregis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Register();
				setVisible(false);
			}
		});
		
		
		setSize(1280,750);
		setTitle("Log in VLEAGUE");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login();
	}
}
