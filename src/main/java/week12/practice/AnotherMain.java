package week12.practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnotherMain {
    public static void main(String[] args) {
        Button button = new Button();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");

            }
        });

        button.addActionListener(e -> System.out.println("Button clicked!"));
    }
}
