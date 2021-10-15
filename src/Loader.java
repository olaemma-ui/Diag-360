import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Loader extends JPanel {
    int x = 30, ang = 10, arc = 10, i, j = 60, k = 0;
    boolean bool = false;
    JFrame f = new JFrame();
    int t = 0;
    Timer timer;

    {
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (k >= 4)
                    k = 0;
                else
                    k++;
                for (i = 0; i < 5; i++) {
                    ang=ang + (50 * i);
                    arc += i;
                }
                if (t >= 40){
                    j-=10;
                    x+=25;
                    if (j == -10) {
                        bool = true;
                        timer.stop();
                        f.dispose();
                        f.setVisible(false);
                        new Control();
                    }
                }
                repaint();
                t++;
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color[] colors = {Color.green, Color.BLUE, Color.ORANGE, Color.RED, Color.green};
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospace", Font.BOLD, 23));
        g.drawString("Diag360 ....", 10, 50);
        for (int i = 0; i < 5; i++) {
            g.setColor(colors[i]);
            g.drawArc(x+(j*i),80,30,30,ang*i, arc*i);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospace", Font.BOLD,  15));
        g.drawString("Developed by Tejumola Emmanuel ....", 10, 170);
        g.drawString("Ola Emma ", 280, 170);
    }

     public void popUp(){
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        f.add(this);
        f.setUndecorated(true);
        f.setBackground(Color.BLACK);
        f.setBounds(850,355,380,180);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        f.setVisible(true);
        timer.start();
    }

    public static void main(String[] args) {
        new Loader().popUp();
    }
}
