package guru.springframework.sfgpetclinic.services.springdatjpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDjpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDjpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        final Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet save(Pet entity) {
        return petRepository.save(entity);
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet delete(Pet object) {
        Pet toDelete = null;
        try {
            toDelete = object.clone();
            petRepository.delete(object);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return toDelete;
    }
}
