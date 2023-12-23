import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// 총알 클래스
class Bullet {
    int x, y;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 적 클래스
class Enemy {
    int x, y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class GalagaGame extends JPanel implements ActionListener, KeyListener {
    private static final int WIDTH = 450;
    private static final int HEIGHT = 500;

    private Timer timer;
    private int playerX, playerY;
    private int playerSpeed;
    private ArrayList<Bullet> bullets;
    private ArrayList<Enemy> enemies;
    private Image playerImage;

    // 게임 오버 여부를 저장하는 변수
    private boolean gameOver = false;
    private boolean spacePressed;

    public GalagaGame() {
        playerX = WIDTH / 2 - 20;
        playerY = HEIGHT - 85;
        playerSpeed = 0;
        spacePressed = false;

        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        // 타이머 설정
        timer = new Timer(10, this);
        timer.start();

        // 이벤트 리스너 등록
        addKeyListener(this);
        setFocusable(true);

        // 플레이어 이미지
        playerImage = new ImageIcon("player.png").getImage();
    }

    // 타이머에 의해 주기적으로 호출되는 메서드
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    // 게임 상태 업데이트 메서드
    public void update() {
        // 게임 오버 상태일 때는 업데이트 중지
        if (gameOver) {
            return;
        }

        // 플레이어 위치 업데이트
        playerX += playerSpeed; // 이동 속도만큼 플레이어 위치 업데이트

        // 플레이어가 화면을 벗어났을 때, 다시 화면 안으로 돌아오도록 처리
        if (playerX < 0) {
            playerX = 0;
        } else if (playerX > WIDTH - 58) {
            playerX = WIDTH - 58;
        }

        // 총알 위치 업데이트
        for (Bullet bullet : bullets) {
            bullet.y -= 5;
        }

        // 일정 확률로 새로운 적 생성
        if (Math.random() < 0.02) {
            enemies.add(new Enemy((int) (Math.random() * WIDTH), 0));
        }

        // 적 위치 업데이트
        for (Enemy enemy : enemies) {
            enemy.y += 1;
        }

        // 충돌 검사
        for (Bullet bullet : new ArrayList<>(bullets)) {
            for (Enemy enemy : new ArrayList<>(enemies)) {
                // 총알과 적이 일정 범위 내에 닿으면 충돌로 판정
                if (Math.abs(bullet.x - enemy.x) < 20 && Math.abs(bullet.y - enemy.y) < 20) {
                    bullets.remove(bullet);
                    enemies.remove(enemy);
                }
            }
        }

        // 화면을 벗어난 총알 제거
        bullets.removeIf(bullet -> bullet.y < 0);

        // 화면을 벗어난 적 제거
        enemies.removeIf(enemy -> enemy.y > HEIGHT);

        // 게임 오버 검사
        for (Enemy enemy : enemies) {
            // 플레이어와 적이 일정 범위 내에 닿으면 게임 오버
            if (Math.abs(enemy.x - playerX) < 30 && Math.abs(enemy.y - 5 - playerY) < 20) {
                gameOver();
            }
        }
    }

    // 그래픽을 그리는 메서드
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 플레이어 그리기
        g.drawImage(playerImage, playerX, playerY, 45, 45, this);

        // 총알 그리기
        g.setColor(Color.RED); // 총알 색 변경
        for (Bullet bullet : bullets) {
            g.fillRect(bullet.x, bullet.y, 5, 10);
        }

        // 적 그리기
        g.setColor(Color.GRAY); // 적 색 변경
        for (Enemy enemy : enemies) {
            g.fillRect(enemy.x, enemy.y, 20, 20);
        }
    }

    // 키 입력 처리 메서드
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            playerSpeed = -3; // 왼쪽으로 이동
        } else if (key == KeyEvent.VK_RIGHT) {
            playerSpeed = 3; // 오른쪽으로 이동
        } else if (key == KeyEvent.VK_SPACE && !spacePressed) {
            bullets.add(new Bullet(playerX + 15, playerY)); // 스페이스바를 누를 때만 총알 생성
            spacePressed = true; // 스페이스바 눌림 여부 설정
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            playerSpeed = 0; // 키 릴리즈 시 이동 중지
        } else if (key == KeyEvent.VK_SPACE) {
            spacePressed = false; // 스페이스바 눌림 여부 초기화
        }
    }

    // 게임 오버 처리 메서드
    public void gameOver() {
        gameOver = true;
        timer.stop();
        JOptionPane.showMessageDialog(this, "게임 오버!", "게임 오버", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    // 메인 메서드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("갤러그 게임");
            frame.setSize(WIDTH, HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            // 게임 패널 추가
            GalagaGame game = new GalagaGame();
            frame.add(game);

            frame.setVisible(true);
        });
    }
}
