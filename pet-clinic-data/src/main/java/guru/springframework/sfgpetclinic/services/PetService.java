package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Set<Pet> findAll();

    Pet findById(Long id);

    Pet save(Pet pet);

}