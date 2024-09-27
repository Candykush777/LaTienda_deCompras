package controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import view.Tienda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@NoArgsConstructor
@Setter
@Getter

public class TiendaController {

    private Tienda tienda;

    public TiendaController(Tienda tienda) {
        this.tienda = tienda;
        initController(); // Llama a un método específico para inicializar
    }

    private void initController() {

        //Configuramos los ActionListeners para los botones

        tienda.getIniciarSesionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(tienda, "Iniciar Sesión seleccionado");
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

        JOptionPane.showMessageDialog(tienda, "Dar de alta Cliente seleccionado");
    }

}
