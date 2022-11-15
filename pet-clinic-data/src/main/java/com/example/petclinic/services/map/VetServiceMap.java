package com.example.petclinic.services.map;

import com.example.petclinic.model.Speciality;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.SpecialtyService;
import com.example.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Vet> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(specilty -> {
                if (specilty.getId() == null) {
                    Speciality savedSpecialty = specialtyService.save(specilty);
                    specilty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }
}
