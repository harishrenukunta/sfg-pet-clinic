package guru.springframework.sfgpetclinic.services.springdatjpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String name) {
        return ownerRepository.findByLastname(name);
    }

    @Override
    public Set<Owner> findAll() {
        final Set<Owner> listOfOwners = new HashSet<>();
        ownerRepository.findAll().forEach(listOfOwners::add);
        return listOfOwners;
    }

    @Override
    public Owner save(Owner entity) {
        return ownerRepository.save(entity);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner delete(Owner object) {
        Owner toDeleteOwner = null;
        try {
            toDeleteOwner = object.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ownerRepository.delete(object);
        return toDeleteOwner;
    }
}
