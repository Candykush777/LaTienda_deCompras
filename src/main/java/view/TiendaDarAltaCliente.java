package view;

import repositories.CustomerRepository;

import javax.swing.*;
import java.awt.*;

public class TiendaDarAltaCliente extends JFrame {

    private JTextField nameField;
    private JTextField first_lastnameField;
    private JTextField second_lastnameField;
    private JTextField correofield;
    private JPasswordField passwordField;
    private JTextField phoneField;
    private CustomerRepository customerRepository;

public TiendaDarAltaCliente(){
    customerRepository=new CustomerRepository();

    setTitle("Menú Principal");
    setSize(600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    //Panel central formulario de registro

    JLabel nameLabel=new JLabel("Nombre");
    nameField=new JTextField();
    JLabel firstLabel=new JLabel("Primer apellido");
    first_lastnameField=new JTextField();






}
}
