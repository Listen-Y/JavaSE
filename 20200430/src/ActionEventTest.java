import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ActionEventTest extends JFrame{
    private JButton redBt, greenBt, buleBt;

    public ActionEventTest() {
        this.setSize(300,300);
        this.setTitle("动作实例");
        this.setLayout(null);
        redBt = new JButton("红色");
        redBt.setSize(60,60);
        redBt.setLocation(10,10);
        greenBt = new JButton("绿色");
        greenBt.setSize(60,60);
        greenBt.setLocation(80,10);
        buleBt = new JButton("蓝色");
        buleBt.setSize(60,60);
        buleBt.setLocation(150,10);
        this.add(redBt);
        this.add(greenBt);
        this.add(buleBt);
        //this.getDefaultCloseOperation();
        this.setVisible(true);
    }


}
