import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest_2 extends JFrame {
	private JLabel label;
	
	Thread t;
	
	class Counter extends Thread {
		public void run() {
			for (int i=0; i<=10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
				label.setText(i+"");
			}
		}
	}
	
	public CountDownTest_2() {
		setTitle("카운트다운");
		setSize(400, 150);
		getContentPane().setLayout(null);
		label = new JLabel("0");
		label.setBounds(0, 0, 384, 111);
		label.setFont(new Font("고딕", Font.BOLD, 100));
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("카운터 중지");
		btnNewButton.setBounds(247, 25, 125, 23);
		
		btnNewButton.addActionListener(e -> t.interrupt());
		getContentPane().add(btnNewButton);
		setVisible(true);
		t = new Counter();
		t.start();
	}
	
	public static void main(String[] args) {
		CountDownTest_2 t = new CountDownTest_2();
	}
}