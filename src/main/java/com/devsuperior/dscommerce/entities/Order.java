package com.devsuperior.dscommerce.entities;

import java.time.Instant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//Mapeamento objeto relacional entre a classe Order 
//(java) e a tabela tb_order no banco de dados H2
@Entity
@Table(name = "tb_order")

public class Order {

    /* Order se relaciona com User  (muitos para um) 
    e com Product (muitos para muitos)
    e com Payment (um para um) */

    @Id
    @GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;    
    private OrderStatus status;

    @ManyToOne //Relação muitos para um com User
    @JoinColumn(name = "client_id") // nome da chave estrangeira no banco de dados
      
    private User client; // associação com User. Um pedido tem um cliente

    @OneToOne(mappedBy = "order", cascade=CascadeType.ALL) // Relação um para um com Payment
    private Payment payment;// associação com Payment. Um pedido tem um pagamento
    
    public Order() {
    } 
    
    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getMoment() {
        return moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
