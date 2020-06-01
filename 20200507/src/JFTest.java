
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StudentFrame1 extends JFrame implements ActionListener {
    JLabel numLabel, nameLabel, sexLabel;//标签
    JTextField numText, nameText;//文本框
    JComboBox sexCom;//下拉框
    JCheckBox[] checkBoxs;//选择框
    JButton[] buttons;//按钮
    JPanel panel;//面板放置按钮
    JPanel panelCheck;//面板放置选择框

    public StudentFrame1() {
        this.setSize(420,350);
        this.setTitle("学生记录Deal");
        this.setLayout(null);
        init();
        //关闭窗口就结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可变
        this.setResizable(false);
        //可见
        this.setVisible(true);
    }

    private void init() {
        panelCheck = new JPanel();
        panelCheck.setSize(310,30);
        panelCheck.setLocation(70, 10);
        panelCheck.setLayout(new GridLayout(1,4,10,0));
        //panel.setBackground(Color.red);
        String[] checkNames = new String[] {"添加", "删除", "查询"};
        checkBoxs = new JCheckBox[3];
        for (int i = 0; i < checkBoxs.length; i++) {
            checkBoxs[i] = new JCheckBox(checkNames[i]);
            checkBoxs[i].addActionListener(this);
            panelCheck.add(checkBoxs[i]);
        }
        this.add(panelCheck);

        numLabel=new JLabel("学号");
        numLabel.setSize(60, 30);//设置控件的大小
        numLabel.setLocation(80, 50);//设置控件的左上角坐标
        this.add(numLabel);

        numText=new JTextField();
        numText.setSize(170, 30);
        numText.setLocation(140,50);//设置控件的左上角坐标
        numText.setEnabled(false);
        this.add(numText);

        nameLabel=new JLabel("姓名");
        nameLabel.setSize(60, 30);//设置控件的大小
        nameLabel.setLocation(80, 100);//设置控件的左上角坐标
        this.add(nameLabel);

        nameText=new JTextField();
        nameText.setSize(170, 30);
        nameText.setLocation(140,100);//设置控件的左上角坐标
        nameText.setEnabled(false);
        this.add(nameText);

        sexLabel=new JLabel("性别");
        sexLabel.setSize(60, 30);//设置控件的大小
        sexLabel.setLocation(80, 150);//设置控件的左上角坐标
        this.add(sexLabel);

        sexCom=new JComboBox();
        sexCom.addItem("");
        sexCom.addItem("男");
        sexCom.addItem("女");
        sexCom.setSize(170, 30);
        sexCom.setLocation(140,150);//设置控件的左上角坐标
        sexCom.setEnabled(false);
        this.add(sexCom);

        panel = new JPanel();
        panel.setSize(310,30);
        panel.setLocation(50, 220);
        panel.setLayout(new GridLayout(1,4,10,0));
        //panel.setBackground(Color.red);
        String[] buttonsNames = new String[] {"添加", "删除", "查询", "清空"};
        buttons = new JButton[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonsNames[i]);
            buttons[i].setEnabled(false);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().toString().contains("JCheckBox")) {
            JCheckBox check = (JCheckBox) e.getSource();
            if(check.getText().equals("添加")) {
                checkBoxs[1].setSelected(false);
                checkBoxs[2].setSelected(false);
                numText.setEnabled(true);
                nameText.setEnabled(true);
                sexCom.setEnabled(true);
                buttons[0].setEnabled(true);
                buttons[1].setEnabled(false);
                buttons[2].setEnabled(false);
                buttons[3].setEnabled(true);
                return;
            }
            if(check.getText().equals("删除")) {
                checkBoxs[0].setSelected(false);
                checkBoxs[2].setSelected(false);
                numText.setEnabled(true);
                nameText.setEnabled(false);
                sexCom.setEnabled(false);
                buttons[0].setEnabled(false);
                buttons[1].setEnabled(true);
                buttons[2].setEnabled(false);
                buttons[3].setEnabled(true);
                return;
            }
            if(check.getText().equals("查询")) {
                checkBoxs[0].setSelected(false);
                checkBoxs[1].setSelected(false);
                numText.setEnabled(true);
                nameText.setEnabled(false);
                sexCom.setEnabled(false);
                buttons[0].setEnabled(false);
                buttons[1].setEnabled(false);
                buttons[2].setEnabled(true);
                buttons[3].setEnabled(true);
                return;
            }
        }

        if(e.getSource().getClass().toString().contains("JButton")) {
            JButton bt = (JButton) e.getSource();
            if(bt.getText().equals("添加")) {
                if(numText.getText().equals("") || nameText.getText().equals("")
                        || sexCom.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(this,"信息不完整添加失败");
                    return;
                }
                /*StudentDeal deal = new StudentDeal();
                Student student = new Student(numText.getText().trim(), nameText.getText().trim()
                        , sexCom.getSelectedItem().toString());
                deal.addNewStudent(student);*/
                JOptionPane.showMessageDialog(this,"添加成功");
                return;
            }
            if(bt.getText().equals("删除")) {
                if(numText.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this,"信息不完整删除失败");
                    return;
                }
               /* StudentDeal deal = new StudentDeal();
                Student student = deal.findStuByNum(numText.getText().trim());
                if(student == null) {
                    JOptionPane.showMessageDialog(this, "无此人");
                    return;
                }
                deal.delStudent(numText.getText().trim());*/
                JOptionPane.showMessageDialog(this, "删除成功");
                return;
            }
            if(bt.getText().equals("查询")) {
                if(numText.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this,"信息不完整查询失败");
                    return;
                }
               /* StudentDeal deal = new StudentDeal();
                Student student = deal.findStuByNum(numText.getText().trim());
                if(student == null) {
                    JOptionPane.showMessageDialog(this, "无此人");
                    return;
                }*/
                nameText.setText("雷浩杰");
                sexCom.setSelectedItem("女");
                return;
            }
            if(bt.getText().equals("清空")) {
                numText.setText("");
                nameText.setText("");
                sexCom.setSelectedIndex(0);
            }
        }
    }
}

public class JFTest {
    public static void main(String[] args) {
        StudentFrame1 studentFrame1 = new StudentFrame1();
    }
}
