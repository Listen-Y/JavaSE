import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventTest extends JFrame {
    JButton one, two, three;
    JPanel panel;
    public MouseEventTest() {
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
        MouseEventDeal deal = new MouseEventDeal(this);
        one.addMouseListener(deal);
        two.addMouseListener(deal);
        three.addMouseListener(deal);
    }
}

class MouseEventDeal implements MouseListener {
    private MouseEventTest event;

    public MouseEventDeal(MouseEventTest event) {
        this.event = event;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 0) {
            event.getContentPane().setBackground(Color.BLUE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        event.one.setText("move");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        event.one.setText("red");
    }
}
