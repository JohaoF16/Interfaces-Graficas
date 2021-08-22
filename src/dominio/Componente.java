package dominio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Componente extends JFrame {

    JPanel panel;
    JTextField text1; 
    ArrayList<Producto> productos = new ArrayList();

    public Componente() {
        setBounds(10, 10, 500, 700);
        setTitle("Ventana");
        setVisible(true);
        setLocationRelativeTo(null);
        paneles();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void agregar() {
        paneles();
        etiquetas();
        botones();
        radioBotones();
        cajaTexto();
        escribeTexto();
        lista();
        insertarObjetos();
        tablas();

    }

    public void paneles() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        this.add(panel);//Añade el panel al Frame
//      this.getContentPane().add(panel);
        etiquetas();
        botones();
        radioBotones();
        cajaTexto();
        escribeTexto();
        lista();
        insertarObjetos();
        tablas();

    }

    public void etiquetas() {
        JLabel etiqueta = new JLabel();
        JLabel etiqueta2 = new JLabel(new ImageIcon("android.png"));
        etiqueta.setText("Figuras");
//      etiqueta.setFont(new Font("Italic",Font.ITALIC,20));
        etiqueta.setBounds(10, 10, 50, 30);
        etiqueta2.setBounds(10, 50, 100, 100);
        MouseListener escuchador = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Click y suelto sobre Android");
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Click en Android");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Click y suelto fuera de Android");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Ingresando a Android");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Saliendo de Android");
            }
        };
        etiqueta2.addMouseListener(escuchador);
        panel.add(etiqueta);
        panel.add(etiqueta2);
        panel.repaint(); //Pinta nuevamente el panel
//      ImageIcon imagen = new ImageIcon("imagen.jpg"); 
    }

    public void botones() {
        JButton boton1 = new JButton("Click");
        ImageIcon android = new ImageIcon("android.png");
        JButton boton2 = new JButton();
        boton2.setIcon(android);
//      JButton boton2 = new JButton(new ImageIcon("imagen.jpg"));
        boton1.setBounds(10, 160, 100, 50);
        boton2.setBounds(10, 220, 100, 60);
        boton2.setIcon(new ImageIcon(android.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
//      boton1.setEnabled(false);
        boton1.setMnemonic('c');
        boton1.setForeground(Color.BLACK);
        ActionListener escuchab1 =  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == boton1){
                    text1.setText("Hola...");
                }else if(e.getSource() == boton2){
                    text1.setText("Android...");
                }
                
            }
        };
//        ActionListener escuchab2 =  new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                text1.setText("Android...");
//            }
//        };
//        boton2.addActionListener(escuchab2);
        boton1.addActionListener(escuchab1);
        boton2.addActionListener(escuchab1);
        panel.add(boton1);
        panel.add(boton2);
        panel.repaint();

    }

    public void radioBotones() {
        JRadioButton botonop1 = new JRadioButton("Opción 1");
        JRadioButton botonop2 = new JRadioButton("Opción 2");
        JRadioButton botonop3 = new JRadioButton("Opción 3");
        botonop1.setBounds(10, 300, 100, 30);
        botonop2.setBounds(10, 330, 100, 30);
        botonop3.setBounds(10, 360, 100, 30);
        botonop1.setEnabled(false);
        botonop1.setBackground(Color.CYAN);
        botonop2.setBackground(Color.CYAN);
        botonop3.setBackground(Color.CYAN);
        panel.add(botonop1);
        panel.add(botonop2);
        panel.add(botonop3);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(botonop1);
        grupo.add(botonop2);
        grupo.add(botonop3);
        panel.repaint();
    }

    public void cajaTexto() {
        text1 = new JTextField();
        text1.setBounds(10, 400, 100, 30);
        text1.setColumns(5);
        text1.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        text1.setText("Texto 1");
        KeyListener llave = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //Define un número de caracteres
                if(text1.getText().length()>=5){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        };
        text1.addKeyListener(llave);
        panel.add(text1);
        panel.repaint();
    }

    public void escribeTexto() {
        JTextArea text2 = new JTextArea();
        text2.setBounds(10, 440, 300, 30);
        text2.setText("Escriba Texto....");
        text2.append("\n.....");
        text2.setEditable(true);
        panel.add(text2);
        JScrollPane text3 = new JScrollPane(text2);
        text3.setBounds(10, 470, 50, 50);
        text3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        text3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(text3);
        panel.repaint();
    }

    public void insertarObjetos() {
        productos.add(new Producto("Camisas", 15));
        productos.add(new Producto("Pantalones", 25));
        productos.add(new Producto("Zapatos", 40));

    }

    public void lista() {
        String[] ciudades = {"Quito", "Guayaquil", "Cuenca"};
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        insertarObjetos();
        modelo.addAll(productos);
        JComboBox listap = new JComboBox(modelo);
        JComboBox lista = new JComboBox(ciudades);
        lista.setSelectedItem("Cuenca");
        lista.setBounds(10, 520, 100, 30);
        listap.setBounds(10, 560, 150, 30);
        listap.setSelectedItem(productos.get(0));
        panel.add(listap);
        panel.add(lista);
        panel.repaint();
    }

    public void tablas() {
        DefaultTableModel modelot = new DefaultTableModel();
        DefaultTableModel modelop = new DefaultTableModel();
        modelot.addColumn("Nombre");
        modelot.addColumn("Ciudad");
        modelot.addColumn("Dirrección");
        modelop.addColumn("Producto");
        modelop.addColumn("Precio");
        String[] fila1 = {"Juan", "Quito", "El Recreo"};
        String[] fila2 = {"Franco", "Guayaquil", "Trinitaria"};
        modelot.addRow(fila1);
        modelot.addRow(fila2);
        JTable tabla = new JTable(modelot);
        JTable tablap = new JTable(modelop);
        tabla.setBounds(120, 10, 220, 200);
        tablap.setBounds(120, 220, 230, 210);
        panel.add(tabla);
        panel.add(tablap);
        JScrollPane barra = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barra.setBounds(120, 10, 250, 200);
        panel.add(barra);
        Object[] p = null;
        for (int i = 0; i < productos.size(); i++) {
            modelop.addRow(p);
            Producto pl = productos.get(i);
            modelop.setValueAt(pl.getNombre(), i, 0);
            modelop.setValueAt(pl.getPrecio(), i, 1);
        }
        JScrollPane barrap = new JScrollPane(tablap, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barrap.setBounds(120, 220, 230, 210);
        panel.add(barrap);
        panel.repaint();

    }
}
