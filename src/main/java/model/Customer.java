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
    private String name, first_lastname, second_lastname, email;

    private String password;

    private int id;

    private String phone;

    public Customer(String name, String first_lastname, String second_lastname, String email, String password, String phone) {
        this.name = name;
        this.first_lastname = first_lastname;
        this.second_lastname = second_lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Customer(String name, String first_lastname, String second_lastname, String email, int id, String phone) {
        this.name = name;
        this.first_lastname = first_lastname;
        this.second_lastname = second_lastname;
        this.email = email;
        this.id = id;
        this.phone = phone;
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }
}


