package view;

import lombok.Getter;
import lombok.Setter;
import model.Customer;
import org.mindrot.jbcrypt.BCrypt;
import repositories.CustomerRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter

public class TiendaLogin extends JFrame {

    private JTextField correoField;
    private JPasswordField passwordField;
    private CustomerRepository customerRepository;

    public TiendaLogin(CustomerRepository customerRepository) { // Inyectar el repositorio en el constructor
        this.customerRepository = customerRepository; // Guardamos la referencia al repositorio

        setTitle("Iniciar sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Usamos BorderLayout para organizar el contenido

        // Crear un panel central con GridLayout para los campos de correo y contraseña
        JPanel panelCentral = new JPanel(new GridLayout(2, 2, 10, 10)); // Filas y columnas con espacio entre componentes

        // Crear componentes
        JLabel correoLabel = new JLabel("Correo:");
        correoField = new JTextField(15); // Ajustar tamaño del campo de texto

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField(15); // Ajustar tamaño del campo de texto

        // Agregar componentes al panel
        panelCentral.add(correoLabel);
        panelCentral.add(correoField);
        panelCentral.add(passwordLabel);
        panelCentral.add(passwordField);

        // Panel inferior con botones
        JPanel panelInferior = new JPanel();
        JButton loginBoton = new JButton("Iniciar sesión");

        panelInferior.add(loginBoton); // Botón en el panel inferior

        // Añadir los paneles al frame principal
        add(panelCentral, BorderLayout.CENTER); // Añadir el panel central
        add(panelInferior, BorderLayout.SOUTH);  // Añadir el panel inferior para los botones


    }}




