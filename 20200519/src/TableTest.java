import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableTest extends JFrame implements ActionListener {
    JTable table;
    JScrollPane panel;
    JTextField text;
    JButton button;
    JButton open;

    public TableTest() {
        this.setSize(500,400);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        init();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void init() {
        String[] titles = {"被加数", "加数", "和"};
        String[][] numbs = new String[10][3];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = new String[] {String.valueOf(i), String.valueOf(i + 1), String.valueOf(2 * i + 1)};
        }
        table = new JTable(numbs, titles);
        panel = new JScrollPane(table);
        panel.setSize(500, 200);
        panel.setLocation(0,0);
        this.add(panel);
        button = new JButton("查找");
        button.addActionListener(this);
        button.setSize(60,30);
        button.setLocation(80, 250);
        this.add(button);
        text = new JTextField();
        text.setSize(120,30);
        text.setLocation(150,250);
        this.add(text);
        open = new JButton("打开");
        open.setSize(60,30);
        open.setLocation(400,300);
        open.addActionListener(this);
        this.add(open);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bu = (JButton) e.getSource();
        if (bu.getText().equals("查找")) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this,"请选择");
                return;
            }
        String num = (String) table.getValueAt(table.getSelectedRow(), 2);
        text.setText(num);
        } else {
            if (bu.getText().equals("打开")) {
                //System.out.println("aaaaaa");
                AddJF addJF = new AddJF(this);
            }
        }
    }
}
