package com.gan.socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Î´Íê³ÉµÄHmi
public class Hmi implements ActionListener {
    private JButton button;

    public static void main(String[] args) {
        new Hmi().go();
    }

    public void go(){
        JFrame frame=new JFrame();
        button=new JButton("Click");
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("clicked");
    }
}
