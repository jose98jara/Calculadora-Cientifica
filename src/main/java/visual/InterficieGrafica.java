package visual;

import evaluator.Evaluator;
import evaluator.Token;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc
 * Paquete visual
 * Proyecto Calculadora
 */
public class InterficieGrafica extends JFrame {
    //Historico
    static List<String> historico = new LinkedList<String>();
    static int indexOperaciones = 1;
    private JPanel panel1;
    private JPanel PanelPrincipal;
    private JPanel ParteNorte;
    private JPanel PanelCentral;

    // Package
    JTextField Entrada;
    JTextField Salida;

    private JComboBox comboBox1;
    private JComboBox TipoOP;
    private JComboBox TipoBase;
    private JPanel panelSur;

    // Card layout
    CardLayout cardLayout = new CardLayout();


    // Constructor
    public InterficieGrafica() {
        // Extablece panel principal
        this.setContentPane(panel1);

        this.setMinimumSize(new Dimension(450, 500));
        this.setMaximumSize(new Dimension(451, 501));
        this.setSize(new Dimension(450, 500));
        /*Barra menus*/
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        /*Menu File*/
        JMenu settings = new JMenu("Ajustes");
        menuBar.add(settings);



        /*Card settings*/
        KeyboardNormal kn = new KeyboardNormal(this);
        KeyboardRoman kr = new KeyboardRoman(this);


        panelSur.setLayout(cardLayout);
        panelSur.add(kn.getKeypadNormal(), "PanelNormal");
        panelSur.add(kr.getPanel(), "PanelRomano");


        /*CARD CHOOSER KEYPAD*/
        TipoOP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TipoOP.getSelectedIndex() == 0) {
                    // NORMAL
                    cardLayout.show(panelSur, "PanelNormal");
                } else if (TipoOP.getSelectedIndex() == 1) {
                    //Romano
                    cardLayout.show(panelSur, "PanelRomano");
                }
            }
        });


    }


}