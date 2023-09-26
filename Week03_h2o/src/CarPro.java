import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CarPro extends JFrame {
    BufferedImage img = null;
    int img_x = 75, img_y = 30;

    class MyPanel extends JPanel {

        public MyPanel() {
            try {
                img = ImageIO.read(new File("car.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // KeyBindings를 사용하여 키 이벤트 처리
            this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "moveUp");
            this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
            this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
            this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");

            this.getActionMap().put("moveUp", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    img_y -= 10;
                    repaint();
                }
            });

            this.getActionMap().put("moveDown", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    img_y += 10;
                    repaint();
                }
            });

            this.getActionMap().put("moveLeft", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    img_x -= 10;
                    repaint();
                }
            });

            this.getActionMap().put("moveRight", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    img_x += 10;
                    repaint();
                }
            });

            this.requestFocus();
            setFocusable(true);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, img_x, img_y, null);
        }
    }

    public CarPro() {
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPanel());
        JPanel p = new JPanel();
        JButton b1 = new JButton("LEFT");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                img_x -= 10;
                repaint();
            }
        });
        JButton b2 = new JButton("RIGHT");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                img_x += 10;
                repaint();
            }
        });
        p.add(b1);
        p.add(b2);
        add(p, "South");
        setVisible(true);
    }

    public static void main(String[] args) {
        CarPro s = new CarPro();
    }
}
