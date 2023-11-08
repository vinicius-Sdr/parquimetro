package com.reis.paquimetro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isFixedTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double paidValue;

    private Boolean isOpen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


}
