import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.AffineTransformOp;
import java.util.Random;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame fr=new JFrame("Вращение треугольника вокруг своего центра тяжести");
        fr.setPreferredSize( new Dimension(300,300));
        final JPanel pan= new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setSize(300, 400);
        int speed = 50;
        Timer tm= new Timer(speed, new ActionListener()
        {
            double x=12, y=35;
            double movex = 3, movey=3;
            @Override public void actionPerformed(ActionEvent arg0)
            {
                x = x+movex;
                y = y+movey;
                if (x >= 268 || x <= 2)
                    movex = -movex;
                if (y >= 198 || y <= 2)
                    movey = -movey;
                Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);
                Random random = new Random();


                gr.translate(x, y);
                gr.drawOval(0, 0, 5, 5);
            }
        });
        tm.start();
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.gray);
        fr.add(panel2, BorderLayout.PAGE_END);
        JButton button1 = new JButton("Медленее");
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tm.setDelay(tm.getDelay()+1);
            }
        });
        JButton button2 = new JButton("Быстрее");
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (tm.getDelay()>1)
                    tm.setDelay(tm.getDelay()-1);
            }
        });
        button1.setSize(50, 50);
        button1.setLocation(50, 210);
        button2.setSize(50, 50);
        button2.setLocation(150, 210);
        panel2.add(button1);
        panel2.add(button2);
    }
}
