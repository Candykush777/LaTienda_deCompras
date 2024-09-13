package model;

import java.time.LocalDateTime;
import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

// ya lo tenemos creado en SQL mismos nombres

public class Orders {

    private int idPedido;
    private LocalDateTime fechaPedido;
    private  Date fechaEntrega;
    private String direccionEntrega;
    private String metodoDePago;
    private double total;
    private Customer cliente;
    private String estado;
    private String comentarios;

    public Orders(LocalDateTime fechaPedido, Date fechaEntrega, String direccionEntrega, String metodoDePago,
                  double total, Customer cliente, String estado, String comentarios) {
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.direccionEntrega = direccionEntrega;
        this.metodoDePago = metodoDePago;
        this.total = total;
        this.cliente = cliente;
        this.estado = estado;
        this.comentarios = comentarios;
    }
}
