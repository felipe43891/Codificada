package Codificada;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Codificada extends JFrame implements ActionListener {

    JLabel l1;
    JTextField t1;

    JLabel l2;
    JTextField t2;

    JLabel l3;
    JTextField t3;

    JLabel l4;
    JTextField t4;

    JButton b1;
    JTextField TT; 

    public static void main(String[] args) {
        Codificada gato = new Codificada();
    }

    public Codificada() {

        setBounds(300, 300, 300, 300); 
        setLayout(new FlowLayout());

        l1 = new JLabel("Cuantos Perros Grandes: ");
        t1 = new JTextField(10); 

        l2 = new JLabel("Cuantos Perros Medianos:");
        t2 = new JTextField(10);

        l3 = new JLabel("Cuantos Perros Pequeños");
        t3 = new JTextField(10);

        l4 = new JLabel("Cuantas Horas");
        t4 = new JTextField(10);

        b1 = new JButton("Total");
        b1.addActionListener(this);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b1);

        TT = new JTextField(15); 
        TT.setEditable(false); 
        add(TT);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int perrosGrandes = Integer.parseInt(t1.getText());
        int perrosMedianos = Integer.parseInt(t2.getText());
        int perrosPequenos = Integer.parseInt(t3.getText());
        int Horas = Integer.parseInt(t4.getText());

        int costoTotal = calcularCostoTotal(perrosGrandes, perrosMedianos, perrosPequenos, Horas);
        TT.setText(Integer.toString(costoTotal));

        JOptionPane.showMessageDialog(this, "El costo Total es: " + costoTotal);

    }

    private int calcularCostoTotal(int perrosGrandes, int perrosMedianos, int perrosPequenos, int horas) {
        int costoPerroGrande = 10000;
        int costoPerroMediano = 5000;
        int costoPerroPequeno = 3000;

        int costoTotal = (perrosGrandes * costoPerroGrande) + (perrosMedianos * costoPerroMediano)
                + (perrosPequenos * costoPerroPequeno);

        int totalPerros = perrosGrandes + perrosMedianos + perrosPequenos;

        if (totalPerros > 1) {
            double descuento = costoTotal * 0.1;
            costoTotal -= descuento;
        }

        costoTotal *= horas;

        return costoTotal;
    }
}
