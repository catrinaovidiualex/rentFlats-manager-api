package com.example.rentflatsmanagerapi.services;


import com.example.rentflatsmanagerapi.model.Flat;
import com.example.rentflatsmanagerapi.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatService {
    @Autowired
private FlatRepository flatrepo;

    public Flat createFlat( Flat flat) {
        return flatrepo.save(flat);
    }

    public List<Flat> createFlats(List<Flat> flats) {
        return flatrepo.saveAll(flats);
    }

    public Flat getFlatByID(Long id){
        return flatrepo.findById(id).orElse(null);
    }

    public List<Flat> getFlats(){
        return flatrepo.findAll();
    }
    public Flat updateFlat(Flat flat){
        Flat oldFlat=null;
        Optional<Flat> optionalFlat=flatrepo.findById(flat.getId());
        if(optionalFlat.isPresent()) {
            oldFlat=optionalFlat.get();
            oldFlat.setTip(flat.getTip());
            oldFlat.setPret(flat.getPret());
            oldFlat.setNrcam(flat.getNrcam());
            oldFlat.setStatus(flat.getStatus());
            flatrepo.save(oldFlat);
        }else{
            return new Flat();
        }
        return oldFlat;
        }

        public String deleteFlatByID(Long id){
        flatrepo.deleteById(id);
        return "Flat was deleted";

        }


}





