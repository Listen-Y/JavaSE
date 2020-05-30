import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoGames extends JFrame {
    JButton colorBt;
    JButton beginBt;
    JButton[] buttons;
    JPanel panel;
    boolean key;
    public LottoGames() {
        this.setSize(330,550);
        this.setTitle("Welcome to LottoGame");
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.yellow);
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {
        colorBt = new JButton("键盘输入换颜色：c浅蓝 g绿色 b蓝色 w白色");
        colorBt.setSize(300,30);
        colorBt.setLocation(10,10);
        colorBt.setContentAreaFilled(false);
        colorBt.setBorderPainted(false);
        colorBtKeyDeal dealKey = new colorBtKeyDeal(this);
        colorBt.addKeyListener(dealKey);
        this.add(colorBt);
        beginBt = new JButton("欢迎光临");
        beginBt.setSize(200,80);
        beginBt.setLocation(60,100);
        beginBt.setFont(new Font("", 1, 25));
        beginBt.setBackground(Color.lightGray);
        beginBt.setBorderPainted(false);
        BeginBtMouseDeal dealMou = new BeginBtMouseDeal(this);
        beginBt.addMouseListener(dealMou);
        this.add(beginBt);
        beginGames();

    }

    public void beginGames() {
        panel = new JPanel();
        panel.setSize(300,300);
        panel.setLocation(10,210);
        panel.setLayout(new GridLayout(3,3));
        panel.setBackground(Color.cyan);
        buttons = new JButton[9];
        String[] buttonsNames = new String[] {"祝", "你", "一", "生", "好", "运", "发", "大", "财"};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonsNames[i]);
            buttons[i].setFont(new Font("", 4, 20));
            buttons[i].setBackground(Color.red);
            ButtonsActionDeal buttonsDeal = new ButtonsActionDeal(this);
            buttons[i].addActionListener(buttonsDeal);
            panel.add(buttons[i]);
        }
        this.add(panel);
    }
}

class colorBtKeyDeal extends KeyAdapter {
    private LottoGames event;

    public colorBtKeyDeal(LottoGames event) {
        this.event = event;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'c') {
            event.getContentPane().setBackground(Color.CYAN);
        }
        if(e.getKeyChar() == 'g') {
            event.getContentPane().setBackground(Color.green);
        }
        if(e.getKeyChar() == 'b') {
            event.getContentPane().setBackground(Color.blue);
        }
        if(e.getKeyChar() == 'w') {
            event.getContentPane().setBackground(Color.white);
        }
    }
}

class BeginBtMouseDeal extends MouseAdapter {
    private LottoGames event;

    public BeginBtMouseDeal(LottoGames event) {
        this.event = event;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getClickCount() == 2) {
            event.beginBt.setText("奖励都假的");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        event.beginBt.setText("双击发现秘密");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        event.beginBt.setText("欢迎光临");
    }
}

class ButtonsActionDeal implements ActionListener {
    private LottoGames event;
    private List<String> list;

    public ButtonsActionDeal(LottoGames event) {
        this.event = event;
        this.list = new ArrayList<>();
        String[] strings = new String[] { "空", "一百万", "空", "空", "一千万", "空", "一个亿", "空"};
        list.addAll(Arrays.asList(strings));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton)e.getSource();
        Random ran = new Random();
         int num = ran.nextInt(list.size());
        String str = bt.getText();
        for (int i = 0; i < event.buttons.length; i++) {
            if(event.buttons[i].getText().equals(str)) {
                event.buttons[i].setText(list.get(num));
                list.remove(num);
                break;
            }
        }
    }
}
