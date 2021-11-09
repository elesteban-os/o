// Importación de elementos para el chat.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class interfac {

    private JFrame window = new JFrame("Calculadora");
    private JButton calcular = new JButton("Calcular");

    private JTextField operation = new JTextField();

    private JLabel lOperation = new JLabel("Operación");


    ActionListener escuchador = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){

        }
    };
    /**
     * Constructor que implementa todas las características de la interfaz.
     */

    public interfac(){

        // Botón
        calcular.setBounds(50, 300, 100, 30);
        calcular.addActionListener(escuchador);

        // Cuadros de texto
        operation.setBounds(50, 100, 100, 30);

        // Labels
        lOperation.setBounds(50, 80, 50, 10);

        window.add(operation);
        window.add(lOperation);
        window.add(calcular);

        window.setSize(400, 400);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
    }
}