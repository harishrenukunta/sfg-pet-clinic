package guru.springframework.sfgpetclinic.services.springdatjpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> allVets = new HashSet<>();
        vetRepository.findAll().forEach( allVets::add);
        return allVets;
    }

    @Override
    public Vet save(Vet entity) {
        return vetRepository.save(entity);
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet delete(Vet object) {
        Vet toDeleteVet = null;
        try {
            toDeleteVet = object.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        vetRepository.delete(object);
        return toDeleteVet;
    }
}
