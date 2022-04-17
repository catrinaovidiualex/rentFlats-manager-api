package com.example.rentflatsmanagerapi.model;



import com.example.rentflatsmanagerapi.repository.FlatRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="Flat")
@Table(name="flats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat implements Comparable<Flat> {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    Long id;
    private String tip;
    private int nrcam;
    private int pret;
    private String status;

    @Override
    public int compareTo(Flat o) {


        if(this.pret>o.getPret()){

            return 1;
        }else if(this.pret<o.getPret()){
            return  -1;
        }

        return 0;
    }


}
