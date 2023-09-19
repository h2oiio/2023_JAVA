import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

	public LoginPage() {
		setTitle("회원 등록하기");
		setSize(300, 200);
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.add(new JLabel("이름"));
		panel.add(new JTextField(20));
		panel.add(new JLabel("패스워드"));
		panel.add(new JPasswordField(20));
		
		JButton login = new JButton("등록하기");
		panel.add(login);
		
		JButton cancel = new JButton("cancle");
		panel.add(cancel);
		
		setVisible(true);
	}
}