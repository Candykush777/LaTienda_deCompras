package view;

import javax.swing.*;
import java.awt.*;

public class TiendaAltaCliente extends JPanel {

    private JButton registroBtn;

    public TiendaAltaCliente() {
        // Aquí puedes agregar los campos para dar de alta al cliente
        setLayout(new GridLayout(3, 2, 10, 10));

        // Para probar , me falta meter todos los campos
        JLabel nameLabel = new JLabel("Nombre");
        JTextField nameField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);
        JButton registroBtn = new JButton("Registrar");



        // Agregar componentes al panel
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(registroBtn);




    }
}

