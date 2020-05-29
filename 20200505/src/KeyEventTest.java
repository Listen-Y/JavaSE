import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventTest extends JFrame {
    JButton bt;
    public KeyEventTest() {
        this.setSize(400,400);
        this.setLayout(null);
        bt = new JButton("ok");
        bt.setSize(60,30);
        bt.setLocation(100,100);
        this.add(bt);
        KeyEventDeal deal = new KeyEventDeal(this);
        bt.addKeyListener(deal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class KeyEventDeal implements KeyListener {
    private KeyEventTest event;

    public KeyEventDeal(KeyEventTest event) {
        this.event = event;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        StringBuilder string = new StringBuilder();
        while (e.getKeyChar() != '\n') {
            string.append(e.getKeyChar());
        }
        if(string.equals('a')) {
            JButton j = new JButton();
            j.setSize(10,10);
            j.setLocation(10,10);
            event.add(j);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
