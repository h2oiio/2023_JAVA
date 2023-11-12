import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDownTest_ extends JFrame {
    private JLabel label;
    private Thread t;

    class Counter extends Thread {
        public void run() {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                label.setText(i + "");
            }
        }
    }

    public CountDownTest_() {
        setTitle("카운트다운");
        setSize(400, 150);
        getContentPane().setLayout(null);

        label = new JLabel("0");
        label.setBounds(0, 0, 384, 111);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().add(label);

        JButton stopButton = new JButton("카운트 중지");
        stopButton.setBounds(240, 25, 130, 23);
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t != null && t.isAlive()) {
                    t.interrupt();
                }
            }
        });
        getContentPane().add(stopButton);

        JButton resumeButton = new JButton("카운트 다시시작");
        resumeButton.setBounds(240, 60, 130, 23);
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t = new Counter();
                t.start();
            }
        });
        getContentPane().add(resumeButton);

        setVisible(true);
        t = new Counter();
        t.start();
    }

    public static void main(String[] args) {
        CountDownTest_ t = new CountDownTest_();
    }
}
