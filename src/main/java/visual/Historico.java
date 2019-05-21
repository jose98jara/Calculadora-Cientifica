package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
/**
 * Creado por: mmonteiro
 * miguelmonteiroclaveri@gmail.com
 * github.com/mmonteiroc/Calculadora-Cientifica
 * Paquete visual
 * Proyecto Calculadora
 */
public class Historico {

    // Atributos
    private JPanel PanelPrincipal;
    private JTable table1;

    /**
     * @param ig Nos pasan una interficie rafica que es lo que el usuario esta viendo.
     *           <p>
     *           Este constructor lo que acemos es definir las columnas del
     *           historial y definir algunos ajustes de dicha tabla,
     *           despues lo que hacemos es añadir un listener que cuando
     *           clickemos en la tabla, la operacion se ponga en el input y output
     *           para poder recuperar dicha operacion si queremos
     */
    // Constructor
    Historico(final InterficieGrafica ig) {
        /*Modelo tabla*/
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Input 1");
        tableModel.addColumn("Input 2");
        tableModel.addColumn("Resultado");
        tableModel.addColumn("Modo calculadora");
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);

        table1.setRowHeight(35);

        table1.setFont(f);
        table1.setModel(tableModel);
        table1.setEnabled(true);


        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clic en la tabla");
                String tipoOperacion = ig.historico.get(table1.getSelectedRow())[3];
                String Operacion = ig.historico.get(table1.getSelectedRow())[0];
                String Operacion1 = ig.historico.get(table1.getSelectedRow())[1];
                String result = ig.historico.get(table1.getSelectedRow())[2];

                // Decimal
                if (tipoOperacion.equals("Decimal") || tipoOperacion.equals("Romano")) {
                    ig.Entrada.setText(Operacion);
                    ig.Salida.setText(result);
                } else if (tipoOperacion.equals("Polinomios")) {
                    ig.Entrada.setText(Operacion);
                    ig.Entrada2.setText(Operacion1);
                    ig.Salida.setText(result);
                }
            }

        });

    }

    /**
     * @return JPanel
     *
     * Este simple metodo lo que hace es
     * retornar el panel prinicpal de esta clase
     */
    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }


    /**
     * @param filas filas a añadir a la tabla
     *
     * Este metodo lo que hace es ir fila por fila y las
     * va añadiendo a la tabla para que las podamos ver
     */
    void setValuesTable(LinkedList<String[]> filas) {
        DefaultTableModel tabla = (DefaultTableModel) table1.getModel();

        for (int i = InterficieGrafica.indexImpresas; i < filas.size(); i++) {
            String[] fila = filas.get(i);
            tabla.addRow(new String[]{fila[0], fila[1], fila[2], fila[3]
            });
            InterficieGrafica.indexImpresas++;
        }
    }

}
