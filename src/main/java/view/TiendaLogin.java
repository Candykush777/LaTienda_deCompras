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
    private int intentosFallidos = 0;
    private final int MAX_INTENTOS = 3;


    public TiendaLogin() {
        this.customerRepository = new CustomerRepository(); // Guardamos la referencia al repositorio

        setTitle("Iniciar sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Panel para centrarlo

        JPanel iniciarSesionPAnel=new JPanel(new GridLayout(4,2));

        // Crear componentes
        JLabel correoLabel = new JLabel("Correo:");
        correoField = new JTextField();

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();




        // Agregar componentes a la ventana
        iniciarSesionPAnel.add(correoLabel);
        iniciarSesionPAnel.add(correoField);
        iniciarSesionPAnel.add(passwordLabel);
        iniciarSesionPAnel.add(passwordField);
        //iniciarSesionPAnel.add(loginBoton);
        add(iniciarSesionPAnel,BorderLayout.CENTER);
        //acciones de los botones


        JButton loginBoton = new JButton("Iniciar sesión");
        JPanel botonInferior=new JPanel();
        botonInferior.add(loginBoton);
        add(botonInferior, BorderLayout.SOUTH);

        loginBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                iniciarSesion();
            }
        });
        setLocationRelativeTo(null);

        setVisible(true);


    }

    private void iniciarSesion() {


        if (intentosFallidos >= 3) {
            JOptionPane.showMessageDialog(this, "Has superado el número de intentos, debes esperar o hacerte una cuenta");
            return;

        }
        String email = correoField.getText();
        String passwordIngresada = new String(passwordField.getPassword());

        // Llamada al método 'realizarLogin' desde 'CustomerRepository'
        Customer customer = customerRepository.realizarLogin(email, passwordIngresada);
        if (customer != null) {

            //Me falta poner algo para mantener la sesion activa etc
            JOptionPane.showMessageDialog(this, "Inicio de sesión con éxito");
            abrirMenuPrincipal();// Aquí abrirías el menú principal o alguna otra acción

        } else {
            intentosFallidos++;
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Intentos fallidos: " + intentosFallidos);
        }
    }

    private void abrirMenuPrincipal() {

        new TiendaMenuPrincipal();
        this.dispose();// cerramos la ventana anterior
    }



}




