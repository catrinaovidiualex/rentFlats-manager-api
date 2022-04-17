package com.example.rentflatsmanagerapi.web;

import com.example.rentflatsmanagerapi.model.Flat;
import com.example.rentflatsmanagerapi.repository.FlatRepository;
import com.example.rentflatsmanagerapi.services.FlatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/flats")

public class FlatController {
    private FlatRepository flatRepository;
    private FlatService flatService;

    public FlatController(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    //CRUD

    // endpoint pentru afisare apartamente de inchiriat
    @GetMapping
    public ResponseEntity<List<Flat>> getAll(){
        return new ResponseEntity<>(flatRepository.findAll(), HttpStatus.ACCEPTED);
    }



    //endpoint pentru adaugare apartament de inchiriat
    @PostMapping("/add")
    public ResponseEntity<String> addFlat(@RequestBody Flat flat){
        this.flatRepository.save(flat);
        return new ResponseEntity<>("adaugat",HttpStatus.ACCEPTED);
    }

    //endpoint pentru update apartament
    @PutMapping("/update")
    public Flat UpdateFlat (@RequestBody Flat ft){
    return flatService.updateFlat(ft);


    }

    //delete
    //endpoint pentru stergere apartament
    @DeleteMapping("/delete/{id}")
    public String deleteFlat(@PathVariable Long id){
        return flatService.deleteFlatByID(id);
    }

    //endpoint pentru sortare carti
    @GetMapping("/sortFlats")
    public ResponseEntity<List<Flat>> sortFlats(){
       List<Flat>flats=this.flatRepository.findAll();

       Collections.sort(flats);

       return  new ResponseEntity<>(flats,HttpStatus.ACCEPTED);



    }


}
