package controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Customer;
import org.mindrot.jbcrypt.BCrypt;
import repositories.CustomerRepository;
import view.Tienda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@NoArgsConstructor
@Setter
@Getter

public class TiendaController {

    private Tienda tienda;
    private CustomerRepository customerRepository;
    private int intentosFallidos = 0;
    private final int MAX_INTENTOS =3;

    public TiendaController(Tienda tienda, CustomerRepository customerRepository) {
        this.tienda = tienda;
        this.customerRepository = customerRepository;
        initController();
    }

    /* public TiendaController(Tienda tienda) {
        this.tienda = tienda;
        initController(); // Llama a un método específico para inicializar
    }*/

    private void initController() {

        //Configuramos los ActionListeners para los botones

        tienda.getIniciarSesionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLogin();
            }
        });

        tienda.getAltaClienteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darDeAltaCliente();
            }
        });


    }

    private void darDeAltaCliente(){

        JOptionPane.showMessageDialog(tienda, "Dar de alta Cliente seleccionado");//hay que modificar esto
    }

    private void IniciarSesion(){

        //lo primero es verificar si han superado los intentos, sino es así se continua d emanera normal.

        if(intentosFallidos>=MAX_INTENTOS){
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
        }

        //Buscamos el cliente en la bbdd usando el email


    }

    private void mostrarLogin(){

       // Tienda

    }
}
