package view;

import lombok.Getter;
import lombok.Setter;
import repositories.CustomerRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Setter
@Getter

public class Tienda extends JFrame {


    private TiendaLogin tiendaLogin;
    private JButton iniciarSesionBtn;
    private JButton altaClienteBtn;

    //Configuramos la Ventana Principal

    public Tienda() {

        //Inicializamos lo que lleva la interfaz

        setTitle("Tienda de Compras");
        setSize(600, 400); //tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Para que termine la app cuando el usuario cierre la ventana
        setLocationRelativeTo(null); //centrar la ventana

        //Crear los botones

        iniciarSesionBtn = new JButton("Iniciar Sesión");
        altaClienteBtn = new JButton("Dar de alta Cliente");

        //Panel para contener y organizar los botones

        JPanel panel = new JPanel();//contenedor para componentes
        panel.setLayout(new GridLayout(2, 1, 10, 10));//diseño del panel
        panel.add(iniciarSesionBtn);
        panel.add(altaClienteBtn);
        add(panel);//para mostrar los botones en la ventana


iniciarSesionBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        abrirLogin();
    }
});

altaClienteBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        abrirDardealta();
    }
});




    }


    private void abrirLogin(){

        new TiendaLogin();
        this.dispose();

    }

    private void abrirDardealta(){
        new TiendaDarAltaCliente();
        this.dispose();
    }


}
