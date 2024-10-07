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

    public TiendaLogin() {
        this.customerRepository = new CustomerRepository(); // Guardamos la referencia al repositorio

        setTitle("Iniciar sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));



        // Crear componentes
        JLabel correoLabel = new JLabel("Correo:");
        correoField = new JTextField();

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JButton loginBoton = new JButton("Iniciar sesión");


        // Agregar componentes a la ventana
        add(correoLabel);
        add(correoField);
        add(passwordLabel);
        add(passwordField);

       //acciones de los botones

        loginBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ;
            }
        });






    }}




