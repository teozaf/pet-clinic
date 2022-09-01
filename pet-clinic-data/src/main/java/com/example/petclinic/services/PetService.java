package com.example.petclinic.services;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;

import java.util.Optional;
import java.util.Set;

public interface PetService {
    Optional<Pet> findById(Long id);

    Pet save (Pet pet);

    Set<Pet> findAll();
}
