import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddJF extends JFrame implements ActionListener {
    JComboBox comboBox;
    JButton button;
    TableTest main;
    public AddJF(TableTest main) {
        this.main = main;
        this.setSize(200,200);
        init();
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        String[] values = {"","我爱你", "一生一世", "白头偕老"};
        comboBox = new JComboBox(values);
        comboBox.setSize(90,30);
        comboBox.setLocation(50, 50);
        this.add(comboBox);
        button = new JButton("确认");
        button.setSize(60,30);
        button.setLocation(80,100);
        button.addActionListener(this);
        this.add(button);
;    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bu = (JButton) e.getSource();
        if (bu.getText().equals("确认")) {
            if (comboBox.getSelectedIndex() == 0 || comboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "请选择");
            } else {
                main.text.setText(comboBox.getSelectedItem().toString());
                this.dispose();
            }
        }
    }
}
