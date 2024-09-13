package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Customer {

// ya lo tenemos creado en SQL
    private String nombre, primerApellido, segundoApellido, email;

    private String contrasena;

    private int id;

    private int telefono;

    public Customer(String nombre, String primerApellido, String segundoApellido, String email, String contrasena, int telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }
}
