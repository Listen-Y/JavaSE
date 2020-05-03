package Snake.Boundray;

import javax.swing.*;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(400, 200, 900, 500);
        //大小不可变
        //frame.setResizable(false);
        //点击x就可以直接关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SnakePanel panel = new SnakePanel();
        frame.add(panel);
        //显示
        frame.setVisible(true);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
    }
}
