import javax.swing.*;
import java.awt.*;

public class SwingTest extends JFrame {

    JTextField showText;
    JButton zeroBt;
    JButton equalBt;
    JPanel leftPanel;//左边面板
    JButton[] leftBts;//左边面板的10个按钮数组
    JPanel centerPanel;
    JButton[] cenretBts;
    JPanel rightPanel;
    JButton[] rightBts;

    public SwingTest() {
        this.setSize(400, 450);
        this.setTitle("计算器");
        this.setLayout(null);//将窗口布局设置为
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.cyan);
        this.init();
        this.setVisible(true);
    }

    //初始元窗口中包含的控件
    private void init() {
        //三个单独控件布置
        showText = new JTextField();
        showText.setSize(360,50);
        showText.setLocation(10,10);
        this.add(showText);
        zeroBt = new JButton("0");
        zeroBt.setSize(140,50);
        zeroBt.setLocation(10,360);
        this.add(zeroBt);
        equalBt = new JButton("=");
        equalBt.setSize(70,80);
        equalBt.setLocation(300,330);
        this.add(equalBt);
        //左边控件布置
        initLeftPanel();
        //中间控件布置
        initCenterPanel();
        //右边控件布置
        initRightPanel();
    }

    //左边面板初始化
    private void initLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setSize(140, 280);
        leftPanel.setLocation(10, 70);
        leftPanel.setBackground(Color.cyan);
        leftPanel.setLayout(new GridLayout(5,2, 5, 5));
        String[] centerBtsNames = {"MC", "MR", "<", "CE", "7", "8", "4", "5", "1", "2"};
        leftBts = new JButton[10];
        for(int i = 0; i < leftBts.length; i ++) {
            leftBts[i] = new JButton(centerBtsNames[i]);
            leftPanel.add(leftBts[i]);
        }
        this.add(leftPanel);
    }
    //中间面板初始化
    private void initCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setSize(140, 340);
        centerPanel.setLocation(155, 70);
        centerPanel.setBackground(Color.cyan);
        centerPanel.setLayout(new GridLayout(6,2, 5, 5));
        String[] leftBtsNames = {"MS", "M+", "C", "+-", "9", "/", "6", "*", "3", "-", "*", "+"};
        cenretBts = new JButton[12];
        for(int i = 0; i < cenretBts.length; i ++) {
            cenretBts[i] = new JButton(leftBtsNames[i]);
            centerPanel.add(cenretBts[i]);
        }
        this.add(centerPanel);
    }
    //右边面板初始化
    private void initRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setSize(70, 255);
        rightPanel.setLocation(300, 70);
        rightPanel.setBackground(Color.cyan);
        rightPanel.setLayout(new GridLayout(4,1, 5, 5));
        String[] leftBtsNames = {"M-", "√", "%", "1/X"};
        rightBts = new JButton[4];
        for(int i = 0; i < rightBts.length; i ++) {
            rightBts[i] = new JButton(leftBtsNames[i]);
            rightPanel.add(rightBts[i]);
        }
        this.add(rightPanel);
    }
}
