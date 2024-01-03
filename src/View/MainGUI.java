package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class MainGUI extends JFrame {
	public MainGUI() {
		Container con = getContentPane();
		
		JPanel pnmain = new JPanel();
		pnmain.setBounds(80, 100, 1100, 600);
		FlowLayout fl_pnmain = new FlowLayout();
		fl_pnmain.setVgap(20);
		fl_pnmain.setHgap(120);
		pnmain.setLayout(fl_pnmain);
		pnmain.setOpaque(false);
		
		
		JButton jbcauthu = new JButton();
		jbcauthu.setIcon(new ImageIcon(MainGUI.class.getResource("/background/ronan2.jpg")));
		Dimension buttonSize = new Dimension(200, 250);
		jbcauthu.setPreferredSize(buttonSize);
		
		JButton jbdoibong = new JButton();
		jbdoibong.setIcon(new ImageIcon(MainGUI.class.getResource("/background/vleague2023.jpg")));
		jbdoibong.setPreferredSize(buttonSize);
		
		JButton jblich = new JButton();
		jblich.setIcon(new ImageIcon(MainGUI.class.getResource("/background/iconball.jpg")));
		jblich.setPreferredSize(buttonSize);
		
		JButton jbketqua = new JButton();
		jbketqua.setIcon(new ImageIcon(MainGUI.class.getResource("/background/result.jpg")));
		jbketqua.setPreferredSize(buttonSize);
		
		JButton jbxephang = new JButton();
		jbxephang.setIcon(new ImageIcon(MainGUI.class.getResource("/background/rank.png")));
		jbxephang.setPreferredSize(buttonSize);
		
		JLabel lbimage = new JLabel();
		lbimage.setIcon(new ImageIcon(MainGUI.class.getResource("/background/san2.jpg")));
		
		JMenuBar mbar = new JMenuBar();
		JMenu cauthu = new JMenu("Cầu thủ");
		JMenu doibong = new JMenu("Đội bóng");
		JMenu lichthidau = new JMenu("Lịch thi đấu");
		JMenu ketqua = new JMenu("Kết quả");
		JMenu xephang = new JMenu("Bảng xếp hạng");
		JMenu taitro = new JMenu("Tài trợ");
		
		JMenuItem itemqlcauthu = new JMenuItem("Quản lý");
		
		JMenuItem itemdscauthu = new JMenuItem("Danh sách");
		
		jbcauthu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FootballPlayer();
				setVisible(false);
			}
		});
		itemqlcauthu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FootballPlayer();
				setVisible(false);
			}
		});
		
		jbdoibong.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FootBallTeam();
				setVisible(false);
			}
		});
		
		jblich.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new schedule();
				setVisible(false);
			}
		});
		
		jbketqua.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new result();
				setVisible(false);
			}
		});
		
		jbxephang.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Rank();
				setVisible(false);
			}
		});
		
		cauthu.add(itemdscauthu);
		cauthu.add(itemqlcauthu);
		
		mbar.add(cauthu);
		mbar.add(doibong);
		mbar.add(lichthidau);
		mbar.add(ketqua);
		mbar.add(xephang);
		mbar.add(taitro);
		
		pnmain.add(jbcauthu);
		pnmain.add(jbdoibong);
		pnmain.add(jblich);
		pnmain.add(jbketqua);
		pnmain.add(jbxephang);
		
		con.add(pnmain);
		con.add(lbimage);
		
		
	
		setJMenuBar(mbar);
		
		setTitle("VLEAGUE");
		setSize(1280,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

	}
	public static void main(String[] args) {
		new MainGUI();
	}
}
