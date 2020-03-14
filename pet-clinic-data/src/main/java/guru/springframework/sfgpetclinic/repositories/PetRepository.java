package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    public Optional<Pet> findPetById(final Long id);
    public Optional<Pet> findPetByName(final String name);
    public List<Pet> findPetsByOwner(final Long id);
}
