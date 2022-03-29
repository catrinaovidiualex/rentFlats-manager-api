package com.example.rentflatsmanagerapi.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="Flat")
@Table(name="flats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    Long id;
    private String tip;
    private int nrcam;
    private int pret;
    private String status;
}
