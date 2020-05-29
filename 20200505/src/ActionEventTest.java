import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventTest extends JFrame {
    JButton one, two, three;
    JPanel panel;
    public ActionEventTest() {
        this.setSize(400,500);
        this.setLayout(null);
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void init() {
        panel = new JPanel();
        panel.setSize(300,30);
        panel.setLocation(50,100);
        panel.setLayout(new GridLayout(1,3));
        one = new JButton("red");
        two = new JButton("bule");
        three = new JButton("yellow");
        panel.add(one);
        panel.add(two);
        panel.add(three);
        this.add(panel);
        deal(one, two, three);
    }

    private void deal(JButton one, JButton two, JButton three) {
        ActionEventDeal deal = new ActionEventDeal(this);
        one.addActionListener(deal);
        two.addActionListener(deal);
        three.addActionListener(deal);
    }
}

class ActionEventDeal implements ActionListener {
    private ActionEventTest event;

    public ActionEventDeal(ActionEventTest event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        if(bt.getText().equals("red")) {
            event.getContentPane().setBackground(Color.red);
        }
        if(bt.getText().equals("bule")) {
            event.getContentPane().setBackground(Color.blue);
        }
        if(bt.getText().equals("yellow")) {
            event.getContentPane().setBackground(Color.yellow);
        }
    }
}
