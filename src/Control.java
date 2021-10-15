import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import static java.awt.Frame.ICONIFIED;

public class Control extends Design implements ActionListener {
    String response;
    int index, i = 0, pos = 0, t = 0, j = 0;
    boolean bool = true;
    String[] userResponse = new String[30];
    int[] previousBranch = new int[30];
    HashMap <Integer, int[]>branchWithResponse = new HashMap<>();

    String dot = "Gathering Information \nLoading ";
    Timer timer;
    {
        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText(dot+=".");
                message.setVisible(true);
                if (t == 3) {
                    t = 0;
                    if (j >= 7)
                        dot = "Troubleshooting \nPlease wait ";
                    else
                        dot =  "Gathering Information \nLoading ";

                    if (j == 15) {
                        dot =  "Gathering Information \nLoading ";
                        message.setVisible(true);
                        message.setText(response);
                        prev.setVisible(true);
                        timer.stop();
                        j = 0;
                    }
                }
                j++;t++;
            }

        });
    }

    Control () {
        branchWithResponse.put(0, new int[]{2,1});branchWithResponse.put(2, new int[]{3,4});branchWithResponse.put(3, new int[]{7,8});
        branchWithResponse.put(4, new int[]{5,6});branchWithResponse.put(5, new int[]{7,18});branchWithResponse.put(7, new int[]{13,10});
        branchWithResponse.put(8, new int[]{10,9});branchWithResponse.put(9, new int[]{19,22});branchWithResponse.put(10, new int[]{12,11});
        branchWithResponse.put(12, new int[]{17,19});branchWithResponse.put(13, new int[]{15,14});branchWithResponse.put(15, new int[]{12,16});
        branchWithResponse.put(19, new int[]{21,20});branchWithResponse.put(20, new int[]{23,24});branchWithResponse.put(21, new int[]{25,20});
        branchWithResponse.put(26, new int[]{27,28});branchWithResponse.put(27, new int[]{32,29});branchWithResponse.put(28, new int[]{31,30});
        branchWithResponse.put(31, new int[]{36,33});branchWithResponse.put(32, new int[]{34,35});branchWithResponse.put(35, new int[]{38,39});
        branchWithResponse.put(36, new int[]{40,37});branchWithResponse.put(39, new int[]{41,45});branchWithResponse.put(40, new int[]{42,43});
        branchWithResponse.put(43, new int[]{45,44});branchWithResponse.put(45, new int[]{47,46});branchWithResponse.put(46, new int[]{50,51});
        branchWithResponse.put(47, new int[]{49,48});branchWithResponse.put(48, new int[]{53,52});
        display();
        properties(prev,true, "PREV", color[0], Color.white, new Font("monospace", Font.BOLD, 15), false, b, this);
        properties(cont,true, "Continue", color[0], Color.white, new Font("monospace", Font.BOLD, 15), false, b, this);
        for (int m = 0, j = 0; m < sideBtn.length || j < opt.length; m++, j++) {
            sideBtn[m].addActionListener(this);
            if (j < 2) {
                opt[j].addActionListener(this);
                bars[j].addActionListener(this);
                bars[j].setFocusPainted(false);
            }
        }
        active(ram, true);
    }

    public void display (){

        if (yes.isSelected() && bool){
            index = branchWithResponse.get(i)[0];
            i = index;
            bool=!bool;
            userResponse[pos] = "yes";
            previousBranch[pos] = index;
        }
        if (no.isSelected() && bool){
            index = branchWithResponse.get(i)[1];
            i = index;
            bool=!bool;
            userResponse[pos] = "no";
            previousBranch[pos] = index;
        }
        System.out.println("i = "+i);
        response = queResponse[index];
        message.setText(response);
        btn.clearSelection();
        userResponse[0] = userResponse[1];
        if (!response.contains("?")){
            message.setVisible(false);
            prev.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            timer.start();
        }
    }
    void active(JButton bt, boolean active){
        for(JButton btn: sideBtn){
            if (btn == bt && active) {
                bt.setBorderPainted(true);
                bt.setBorder(BorderFactory.createLineBorder(color[0], 3));
            }else{
                btn.setBorderPainted(false);
            }
        }

        yes.setVisible(true);
        no.setVisible(true);
    }
    public void previous(){
        if (pos > 0)
            index = previousBranch[pos - 1];
            i = index;
            response = queResponse[index];

            if (userResponse[pos].equalsIgnoreCase("yes"))
                yes.setSelected(true);
            if (userResponse[pos].equalsIgnoreCase("no"))
                no.setSelected(true);

        message.setText(response);
        yes.setVisible(true);
        no.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close)
            System.exit(0);
        if (e.getSource() == min)
            frame.setState(ICONIFIED);

        if (e.getSource() == yes || e.getSource() == no) {
            pos++;
            display();
            bool = !bool;
        }
        if (e.getSource() == post){
            userResponse = new String[30];
            previousBranch = new int[30];
            i = 26;
            pos = 0;
            index = i;
            display();
            active(post, true);
            dot = "Gathering Information \nLoading ";
            t = 0; j = 0;
            timer.stop();
            message.setVisible(true);
            prev.setVisible(true);
        }
        if (e.getSource() == ram){
            userResponse = new String[30];
            previousBranch = new int[30];
            i = 0;
            pos = 0;
            index = i;
            display();
            active(ram, true);
            dot = "Gathering Information \nLoading ";
            t = 0; j = 0;
            timer.stop();
            message.setVisible(true);
            prev.setVisible(true);
        }
        if (e.getSource() == video){
            pos = 0;t = 0; j = 0;
            active(video, true);
            dot = "Gathering Information \nLoading ";
            timer.stop();
            message.setVisible(true);
            prev.setVisible(true);
        }
        if (e.getSource() == prev && pos > 0){
            previous();
            System.out.println(pos + " " + userResponse[pos]);
            pos--;
        }
    }
}
