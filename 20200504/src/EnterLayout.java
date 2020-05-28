import java.awt.*;
import javax.swing.*;

public class EnterLayout extends JFrame
{
    ///计算器上的控件
    JTextField showText;
    JButton zeroBt;
    JButton equalBt;
    JPanel leftPanel;
    JButton[] leftBts;//左边面板上的按钮数组(10个按钮对象)
    JPanel centerPanel;
    JButton[] centerBts;//中间面板上的按钮数组(12个按钮对象)
    JPanel rightPanel;
    JButton[] rightBts;//左边面板上的按钮数组(4个按钮对象)

    public EnterLayout()
    {
        //设置大小
        this.setSize(400, 450);
        //设置标题
        this.setTitle("计算器界面");
        //将窗口的默认布局方式设置为空（很重要）
        this.setLayout(null);
        //设置JFrame容器的颜色
        this.getContentPane().setBackground(Color.CYAN);
        //放置控件
        this.init();
        //设置为关闭窗口就结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置为大小不可变
        this.setResizable(false);
        //设置为可见
        this.setVisible(true);
    }


    private void init()
    {
        ///三个单独控件的创建及摆放
        showText=new JTextField();
        showText.setSize(365, 50);
        showText.setLocation(10, 10);
        this.add(showText);

        zeroBt=new JButton("0");
        zeroBt.setSize(140, 52);
        zeroBt.setLocation(10, 355);
        this.add(zeroBt);

        equalBt=new JButton("=");
        equalBt.setSize(70, 108);
        equalBt.setLocation(300, 298);
        this.add(equalBt);
        //左边面板的摆放和面板上控件的摆放
        initLeftPanel();
        //中间面板的摆放和面板上控件的摆放
        initCenterPanel();
        //右边面板的摆放和面板上控件的摆放
        initRightPanel();
    }

    //左边面板初始化方法
    private void initLeftPanel()
    {
        leftPanel=new JPanel();
        leftPanel.setSize(140, 280);
        leftPanel.setLocation(10,70);
        leftPanel.setBackground(Color.CYAN);
        leftPanel.setLayout(new GridLayout(5,2,5,5));
        String[] leftBtNames={"MC","MR","<-","CE","7","8","4","5","1","2"};
        leftBts=new JButton[10];
        for(int i=0;i<leftBts.length;i++)
        {
            leftBts[i]=new JButton(leftBtNames[i]);
            leftPanel.add(leftBts[i]);
        }
        this.add(leftPanel);
    }

    //中间面板初始化方法
    private void initCenterPanel()
    {
        centerPanel=new JPanel();
        centerPanel.setSize(140, 340);
        centerPanel.setLocation(155,70);
        centerPanel.setBackground(Color.CYAN);
        centerPanel.setLayout(new GridLayout(6,2,5,5));
        String[] centerBtNames={"MS","M+","C","+-","9","/","6","*","3","-",".","+"};
        centerBts=new JButton[12];
        for(int i=0;i<centerBts.length;i++)
        {
            centerBts[i]=new JButton(centerBtNames[i]);
            centerPanel.add(centerBts[i]);
        }
        this.add(centerPanel);
    }

    //右边面板初始化方法
    private void initRightPanel()
    {
        rightPanel=new JPanel();
        rightPanel.setSize(70, 225);
        rightPanel.setLocation(300,70);
        rightPanel.setBackground(Color.CYAN);
        rightPanel.setLayout(new GridLayout(4,1,5,5));
        String[] rightBtNames={"M-","√","%","1/x"};
        rightBts=new JButton[4];
        for(int i=0;i<rightBts.length;i++)
        {
            rightBts[i]=new JButton(rightBtNames[i]);
            rightPanel.add(rightBts[i]);
        }
        this.add(rightPanel);
    }

}
