import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.desktop.PrintFilesEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Students extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JPasswordField passwordField;
	private JButton btnNewButton1;
	private JButton btnNewButton2;

	public Students() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 237);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("덕성여대 화이팅");
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(36, 45, 151, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("학번");
		lblNewLabel_1.setBounds(36, 70, 151, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("성적");
		lblNewLabel_2.setBounds(36, 95, 113, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("학생 등록하기");
		lblNewLabel_4.setFont(new Font(" ",Font.PLAIN, 16));
		lblNewLabel_4.setBounds(36, 10, 151, 25);
		contentPane.add(lblNewLabel_4);
		
		textField1 = new JTextField();
		textField1.setBounds(187, 45, 116, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(187, 70, 116, 21);
		contentPane.add(textField3);
		textField3.setColumns(10); 
		
		textField2 = new JTextField();
		textField2.setBounds(187, 95, 116, 21);
		contentPane.add(textField2);
		textField2.setColumns(10); 
			
		btnNewButton1 = new JButton("등록하기");
		btnNewButton1.setBounds(90, 130, 97, 23);
		contentPane.add(btnNewButton1);
		
		btnNewButton2 = new JButton("취소");
		btnNewButton2.setBounds(206, 130, 97, 23);
		contentPane.add(btnNewButton2);
	}
	
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()==btnNewButton1)
			{
				System.out.println("이름:");
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Students frame = new Students();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}

// 20221019 이수정