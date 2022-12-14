package com.example.petclinic.services;

import com.example.petclinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);

}
