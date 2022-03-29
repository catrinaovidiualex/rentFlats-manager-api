package com.example.rentflatsmanagerapi.repository;

import com.example.rentflatsmanagerapi.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {

}
