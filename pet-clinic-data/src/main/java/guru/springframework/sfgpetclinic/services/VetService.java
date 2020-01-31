package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Set<Vet> findAll();

    Vet findById(Long id);

    Vet save(Vet vet);
    
}