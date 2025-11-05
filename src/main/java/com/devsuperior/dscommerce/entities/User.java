package com.devsuperior.dscommerce.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Mapeamento objeto relacional entre a classe User 
//(java) e a tabela tb_user no banco de dados H2
@Entity 
@Table(name = "tb_user") 

//- User se relaciona com Order (um para muitos)
public class User {
    /*   
    - Mapeamento objeto relacional entre a classe User 
    (java) e a tabela tb_user no banco de dados H2
    */
    @Id
    @GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;

    @OneToMany(mappedBy = "client")// nome do atributo na classe Order que referencia o User
    
    private List<Order> orders = new ArrayList<>(); //um usuario pode ter muitos pedidos

    /* a parte de ROLES vai serm implementada mais pra frente */
    public User() {
    }

    public User(Long id, String name, String email, String phone, LocalDate birthDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", birthDate="
                + birthDate + ", password=" + password + "]";
    }

    public List<Order> getOrders() {
        return orders;
    }
    
    

}
