package com.javalesson.graphic.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("SpringLayoutTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();

        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        Component label = new JLabel("Метка");
        Component field = new JTextField(15);
        JButton button = new JButton("test");
        Character[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Random random = new Random();



        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Character result = chars[random.nextInt(chars.length - 1 )];
                String text = ((JLabel) label).getText();
                text = text + result;
                ((JLabel) label).setText(text);
            }
        });

        button.addActionListener(new ActionListener() {
            boolean timerEnabled = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timerEnabled) {
                    timer.start();


                }
                else {
                    timer.stop();
                }
                timerEnabled = !timerEnabled;

            }
        });
        button.setBackground(Color.decode("#6cbbf7"));


        contentPane.add(label);
        contentPane.add(field);
        contentPane.add(button);
        // западная сторона (левая) компонента к западной стороне контейнера с отступом 10
        layout.putConstraint(SpringLayout.WEST , label, 10,
                SpringLayout.WEST , contentPane);
        layout.putConstraint(SpringLayout.NORTH, label, 25,
                SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.NORTH, field, 25,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST , field, 20,
                SpringLayout.EAST , label      );

        layout.putConstraint(SpringLayout.NORTH, button, 25,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST , button, 25,
                SpringLayout.EAST , field      );

        frame.setSize(350, 110);
        frame.getContentPane().setBackground(Color.decode("#fafafb"));
        frame.setVisible(true);
    }
}
