import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;


class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("명함");
        setSize(550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        ImageIcon icon = new ImageIcon("profile.jpg");
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(30, 20, 130, 160);
        add(imageLabel);

        JLabel nameLabel = new JLabel("이수정");
        nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        nameLabel.setBounds(190, 40, 150, 30);
        add(nameLabel);

        JLabel positionLabel = new JLabel("프로젝트 매니저");
        positionLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        positionLabel.setBounds(190, 85, 200, 30);
        add(positionLabel);

        JLabel companyLabel = new JLabel("덕성주식회사");
        companyLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        companyLabel.setBounds(190, 130, 150, 30);
        add(companyLabel);

        setVisible(true);
    }
}
 

public class BusinessCard {

    public static void main(String[] args) {
        MyFrame F = new MyFrame();
    }
}