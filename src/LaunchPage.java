import javax.swing.*;
import java.awt.event.*;

import java.awt.*;




public class LaunchPage implements ActionListener, MouseListener{
    JFrame frame = new JFrame();
    JButton enter = new JButton("Start Converting");
    JButton exit = new JButton("Exit Application");
    JLabel title;
    LaunchPage() {

        frame.setTitle("Welcome to SwingShift");

        JLabel title = new JLabel();
        ImageIcon img = new ImageIcon("logo.png");
        title.setIcon(img);
        title.setBounds(30, 180, 600, 300);

        enter.setBounds(75, 450, 225, 75);
        enter.setFocusable(false);
        enter.addActionListener(this);
        enter.setHorizontalTextPosition(JButton.CENTER);
        enter.setVerticalTextPosition(JButton.CENTER);
        enter.setBorder(BorderFactory.createEmptyBorder());
        enter.setBackground(new Color(55,170,136));
        enter.setForeground(Color.white);
        enter.setFont(new Font(null, Font.BOLD, 17));
        enter.addMouseListener(this);

        exit.setBounds(375, 450, 225, 75);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setHorizontalTextPosition(JButton.CENTER);
        exit.setVerticalTextPosition(JButton.CENTER);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setBackground(new Color(184,20,20));
        exit.setForeground(Color.white);
        exit.setFont(new Font(null, Font.BOLD, 17));
        exit.addMouseListener(this);

        frame.add(title);
        frame.add(enter);
        frame.add(exit);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== exit) {
            System.exit(0);
        }
        if (e.getSource()==enter) {
            frame.dispose();
            new JPEG2PDF();
        }
    }

    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == enter) {
            enter.setBackground(new Color(68, 207, 165));
        } else if (e.getSource() == exit) {
            exit.setBackground(new Color(233, 48, 91));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == enter) {
            enter.setBackground(new Color(55, 170, 136));
        } else if (e.getSource() == exit) {
            exit.setBackground(new Color(184, 20, 20));
        }
    }
}
