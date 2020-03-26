package dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Produits")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF")
    private Long reference;
    @Column(name = "DES")
    private String designation;
    private double price;
    private int quantity;

    public Produit(String designation, double price, int quantity) {
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
    }

    public Produit() {
        // getters and setters
    }

}
