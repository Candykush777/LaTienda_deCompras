package view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class TiendaLogin extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton iniciarSesionBtn;


    public TiendaLogin() {

        //Inicializamos campos para texto y botón

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        iniciarSesionBtn = new JButton("Iniciar Sesión");

        //Hacemos las etiquetas

        JLabel emailLabel = new JLabel("Email");
        JLabel passwordLabel = new JLabel("Contraseña");

        //creamos panel para el layout
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(iniciarSesionBtn);

        add(panel);
    }


}
