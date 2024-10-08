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
        setLayout(new GridLayout(3, 2));


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


    }

    private void IniciarSesion() {

        String email = correoField.getText();
        String passwordIngresada=new String(passwordField.getPassword());

        Customer customer=customerRepository.findByEmail(email,passwordIngresada);
        if(customer !=null){
            JOptionPane.showMessageDialog(this,"Inico sesión con éxito");
            // aqui abriria el menu principal la ventana por hacer .. creo TiendaMenuPrincipal y el metodo para abrirlo

        }


    }


    //lo primero es verificar si han superado los intentos, sino es así se continua d emanera normal.

       /* if(intentosFallidos>=MAX_INTENTOS){
            //System.out.println("Has superado el número de intentos, debes esperar o hacerte una cuenta"); con el
            //view se hace de otra manera

            JOptionPane.showMessageDialog(tienda,"Has superado el número de intentos, debes esperar o hacerte una cuenta");
            return;
        }

        //Ahora queremos obetner el email y contraseña del formulario dentro del view

        String email=tienda.getTiendaLogin().getCorreoField().getText();
        String password = new String(tienda.getTiendaLogin().getPasswordField().getPassword());

        Customer customer =customerRepository.findByEmail(email);

        if(customer != null && BCrypt.checkpw(password, customer.getPassword())){
            JOptionPane.showMessageDialog(tienda, "Inicio de sesión exitoso");
        }
        else {
            intentosFallidos++;
            JOptionPane.showMessageDialog(tienda, "Credenciales Incorrectas, Intentos  : " +intentosFallidos);
        }*/
}




