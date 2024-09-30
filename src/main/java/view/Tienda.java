package view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Setter
@Getter

public class Tienda extends JFrame {

    private JButton iniciarSesionBtn;
    private JButton altaClienteBtn;
    private JTextField emailField;
    private JPasswordField passwordField;


    //Configuramos la Ventana Principal

    public Tienda(){

        //Inicializamos lo que lleva la interfaz

        setTitle("Tienda de Compras");
        setSize(400,200); //tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //centrar la ventana
        emailField=new JTextField(20);
        passwordField=new JPasswordField(20);

        //Crear los botones

        iniciarSesionBtn = new JButton("Iniciar Sesión");
        altaClienteBtn = new JButton("Dar de alta Cliente");

        //Panel para contener y organizar los botones

        JPanel panel =new JPanel();
        panel.setLayout(new GridLayout(2,1,10,10));
        panel.add(iniciarSesionBtn);
        panel.add(altaClienteBtn);
        add(panel);





    }

}
