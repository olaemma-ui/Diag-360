import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Design extends Loader{
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JPanel side = new JPanel();
    JButton video = new JButton();
    JButton post = new JButton();
    JButton ram = new JButton();
    JButton[] sideBtn = {video, post, ram};
    JPanel menu = new JPanel();
    JPanel bot = new JPanel();
    JPanel display = new JPanel();
    JTextArea message = new JTextArea();

    ButtonGroup btn = new ButtonGroup();
    JRadioButton yes = new JRadioButton();
    JRadioButton no = new JRadioButton();
    JRadioButton[] opt = {yes, no};

    JButton min = new JButton();
    JButton close = new JButton();
    JButton prev = new JButton();
    JButton cont = new JButton();
    JButton[] bars = {min,close};
    int[] b = {410,250,80,35};
    String[] txt = {"Yes", "No", "_", "X", "RAM", "POST", "Video"};
    String[] queResponse = {
            "Does System Power up ?", "Proceed to POST Diagnostics.", "Live Screen display ?", "Get Blinking Cursor ?", "Monitor Power on ?", "Controls in Middle of Range ?",
            "Check Monitor Power source. Make sure a Detachable Power cord is fully seated in the Monitor Socket.", "Hear Strings of Beeps ?", "No Signal Displayed ?", "Freezes on Bios Screen ?", "Video Cable secure ?", "Connect Video Cable.", "Cable Damaged or Pins Bent ?", "Adapter Seated properly ?",
            "Reseat Video Adapter secure.", "RAM Seated properly ?", "Reseat RAM on Motherboard.", "Repair or Replace Video Cable", "Adjust Brightness and Contrast.", "Any other Adapter Installed ?", "Live with new Video Adapter ?",
            "Live Video with Adapter Removed ?", "Proceed to Video Performance.", "Try old Adapter in other System before chucking.", "Proceed to Motherboard Diagnostics. ", "Proceed to Conflict Resolution Diagnostics.",
                // POST Troubleshooting
            "Power comes on ?", "Live Screen Display ?", "Good Power Source ?", "Proceed to Video Diagnostics.", "Use Live Outlet.", "Is 110/220 Volt set ?",
            "Boot on Second trial ?", "Select Proper Voltage on rear of Power supply.", "Premature Power ok Signal, Try different Power supply.", "Hear any Beeps ?", "Install Motherboard LEAD ?", "Check manual and Motherboard Silkscreen. Connect LEAD from front Panel.", "Proceed to Motherboard Diagnostics.", "New Hardware Installed ?",
            "Power Switch Fail ?", "Remove Latest Addition and retry Test. Replace Power supply.", "Replace Switch or Substitute front panel Reset Switch, if available", "Power Supply connections to Motherboard correct ?", "Remake Motherboard Power supply connections.", "Hard Drive spin up ?", "Spin up on other LEAD ?", "Bad Adapter on BUS ?",
            "Powers Motherboard on Bench ?", "Strip System down to Video Adapter only.", "Defective Power Supply LEAD or Connector.", "Try Drive in Test PC.", "Replace Power supply.", "Either you have a short circuit in the case or a Geometry problem placing an unacceptable stress on the Motherboard. It's also possible" +
                    "that the video adapter was never seated, due to the bracket position ", "Defective Power Supply lead or Connector"
    };
    Color[] color = {new Color(0, 150, 0), new Color(150,0,0)};
    void radioBtn (){
        for (int i = 0; i < 2; i++) {
            opt[i].setText(txt[i]);
            opt[i].setBounds(110+(i*70), 250, 60,35);
            opt[i].setBackground(color[i]);
            opt[i].setForeground(Color.white);
            opt[i].setFocusPainted(false);
            btn.add(opt[i]);
            frame.add(opt[i]);
            prev.setFocusPainted(false);
        }
    }
    void sideNav(){
        for (int i = 0; i < 3; i++) {
            sideBtn[i].setBounds(2,55+(i*70), 85,35);
            sideBtn[i].setText(txt[i+4]);
            sideBtn[i].setBackground(Color.GRAY);
            sideBtn[i].setForeground(Color.white);
            sideBtn[i].setFocusPainted(false);
            frame.add(sideBtn[i]);
        }
    }
    void properties(JButton btn, boolean bool, String text, Color color,Color FG, Font font, boolean border, int[] bounds, ActionListener listener){
        btn.setVisible(bool);
        btn.setText(text);
        btn.setBackground(color);
        btn.setForeground(FG);
        btn.setFont(font);
        btn.setBorderPainted(border);
        btn.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        btn.addActionListener(listener);
        System.out.println(bounds[0]);
    }

    Design(){
        radioBtn();
        sideNav();
        prev.setFocusPainted(false);
        cont.setFocusPainted(false);
        for (int i = 0; i < bars.length; i++) {
            bars[i].setBackground(Color.darkGray);
            bars[i].setText(txt[i+2]);
            bars[i].setForeground(color[i]);
            bars[i].setBounds(420+(i*40),3,50,40);
            bars[i].setBorderPainted(false);
            menu.add(bars[i]);
            panel.add(bars[i]);
            frame.add(bars[i]);
        }
        message.setBackground(Color.gray);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setEditable(false);
        message.setFont(new Font("Monospace", Font.BOLD, 20));
        message.setForeground(Color.white);
        message.setBounds(108,60,380,180);

        display.add(message);
        display.setBounds(100,45,390,193);
        display.setBackground(Color.GRAY);

        bot.setBounds(100,240,495,57);
        bot.setBackground(Color.DARK_GRAY);
        menu.setBounds(100,3,395,40);
        menu.setBackground(Color.DARK_GRAY);

        side.setBounds(3,3,96, 294);
        side.setBackground(Color.DARK_GRAY);
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        panel.setSize(500,400);

        frame.add(side);
        frame.add(cont);
        frame.add(prev);
        frame.add(message);
        frame.add(display);
        frame.add(bot);
        frame.add(menu);
        frame.add(panel);
        frame.setUndecorated(true);
        frame.setBackground(/*new Color(0,0,0,100)*/Color.GRAY);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}