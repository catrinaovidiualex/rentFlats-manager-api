package com.example.rentflatsmanagerapi.web;

import com.example.rentflatsmanagerapi.model.Flat;
import com.example.rentflatsmanagerapi.repository.FlatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/flats")

public class FlatController {
    private FlatRepository flatRepository;

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
    public ResponseEntity<String> updateFlats(@RequestBody Flat ft){
    Flat flat = this.flatRepository.findById(ft.getId()).get();

    flat.setTip(ft.getTip());
    flat.setNrcam(ft.getNrcam());
    flat.setPret(ft.getPret());
    flat.setStatus(ft.getStatus());
    this.flatRepository.save(flat);

    return new ResponseEntity<>("a fost modificata",HttpStatus.ACCEPTED);
    }

    //delete
    //endpoint pentru stergere apartament
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlats(@PathVariable Long id){



        this.flatRepository.deleteById(id);

        return new ResponseEntity<>("a fost sters",HttpStatus.ACCEPTED);
    }

}
