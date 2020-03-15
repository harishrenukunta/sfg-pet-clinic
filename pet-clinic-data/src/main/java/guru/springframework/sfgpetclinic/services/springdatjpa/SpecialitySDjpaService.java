package guru.springframework.sfgpetclinic.services.springdatjpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDjpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDjpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality save(Speciality entity) {
        return specialityRepository.save(entity);
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality delete(Speciality object) {
        Speciality toDelete = null;
        try {
            toDelete = object.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        specialityRepository.delete(object);
        return toDelete;
    }
}
