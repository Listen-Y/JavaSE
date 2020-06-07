import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTest extends JFrame implements ActionListener {
    //处理菜单事件的事件源是菜单项，所以菜单项是一个对象，和下拉框不一样，下拉框直接加选项
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem[] menuItems;
    public MenuTest() {
        this.setSize(400,500);
        this.setLayout(null);
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {
        menu = new JMenu("Menu");
        String[] itemNames = new String[] {"红色", "蓝色", "绿色"};
        menuItems = new JMenuItem[3];
        for (int i = 0; i < 3; i++) {
            menuItems[i] = new JMenuItem(itemNames[i]);
            menuItems[i].addActionListener(this);
            menu.add(menuItems[i]);
        }
        menuBar = new JMenuBar();
        //menuBar.setSize(60,60);
        //menuBar.setLocation(60,60);
        menuBar.add(menu);
        //独立设置菜单栏的方法
        this.setJMenuBar(menuBar);
        //this.add(menuBar);
        initButton();

    }
    private void initButton()
    //初始化按钮的方法
    {
        //this.setLayout(null);
        JButton redBt = new JButton("红色");
        redBt.setSize(60, 30);
        redBt.setLocation(30, 30);
        this.add(redBt);
        JButton greenBt = new JButton("绿色");
        greenBt.setSize(60, 30);
        greenBt.setLocation(120, 30);
        this.add(greenBt);
        JButton blueBt = new JButton("蓝色");
        blueBt.setSize(60, 30);
        blueBt.setLocation(210, 30);
        this.add(blueBt);

        redBt.addActionListener(this);
        greenBt.addActionListener(this);
        blueBt.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //因为我们的按钮和菜单项都是继承与AbstractButton，所以可以直接让他们强转为AbstractButton
        AbstractButton item = (AbstractButton) e.getSource();
        if(item.getText().equals("红色")) {
            this.getContentPane().setBackground(Color.red);
        }else {
            if(item.getText().equals("蓝色")) {
                this.getContentPane().setBackground(Color.blue);
            }else {
                this.getContentPane().setBackground(Color.green);
            }
        }
    }
}
