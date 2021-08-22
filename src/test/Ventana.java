
package test;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        JButton boton = new JButton("Click Papu");
        boton.setLocation(30, 30);
        ventana.setSize(300, 200);
        ventana.setLocationRelativeTo(null);
//        ventana.setLocation(100, 100);
        ventana.setTitle("Primera Ventana");
        ventana.setVisible(true);
        ventana.add(boton);
    }
}
