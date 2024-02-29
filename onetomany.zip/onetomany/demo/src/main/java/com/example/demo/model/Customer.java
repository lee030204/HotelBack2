package com.example.demo.model;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer
{
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid;
    private  int number;
    private String customername;
    private int hotelNo;

    @JsonBackReference
    @ManyToOne
    // @JoinColumn(name = "customer_id",nullable = false)
    private Hotel hotel;

    // @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    // private List<Booking> booking;
    
}
