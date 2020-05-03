package Snake.Boundray;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

public class SnakePanel extends JPanel{

    //ImageIcon倒入图片

    public void paint(Graphics g) {
        //设置画布背景颜色
        //this.setBackground(Color.magenta);
        //g.fillRect(0, 0, 900, 500);
        //this.setBackground(Color.BLUE);
        //g.fillRect(25, 25, 850, 54);
        //设置标题
        g.setColor(Color.RED);
        //g.setClip();
        int size = 120;
        int count = 0;
        g.setFont(new Font("", Font.ITALIC, 30));
        //g.drawString("♥爱你♥", 110,100);
        int x= 210;
        while (count < 4) {
            g.drawString("♥爱你♥", x,100);
            x += size;
            count ++;
        }
        x = 370;
        int y = 130;
        count = 0;
        while (count < 3) {
            g.drawString("爱",x,y);
            g.drawString("♥",x,y+30);
            g.drawString("你",x,y+60);
            y += size - 30;
            count ++;
        }
        x = 490;
        y = 130;
        count = 0;
        while (count < 3) {
            g.drawString("爱",x,y);
            g.drawString("♥",x,y+30);
            g.drawString("你",x,y+60);
            y += size - 30;
            count ++;
        }
        x = 210;
        count = 0;
        while (count < 4) {
            g.drawString("♥爱你♥", x,400);
            x += size;
            count ++;
        }
        g.drawString("♥",280, 190);
        g.drawString("爱",310, 220);
        g.drawString("你",340, 250);
        g.drawString("♥",580, 190);
        g.drawString("爱",550, 220);
        g.drawString("你",520, 250);
    }
}
