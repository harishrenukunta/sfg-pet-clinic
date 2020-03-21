package guru.springframework.sfgpetclinic.services.springdatjpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        final Set<Visit> allVisits = new HashSet<>();
        visitRepository.findAll().forEach(allVisits::add);
        return allVisits;
    }

    @Override
    public Visit save(Visit entity) {
        return visitRepository.save(entity);
    }

    @Override
    public Visit findById(Long visitId) {
        return visitRepository.findById(visitId).orElse(null);
    }

    @Override
    public Visit delete(Visit object) throws CloneNotSupportedException {
        final Visit visitClone = object.clone();
        visitRepository.delete(object);
        return visitClone;
    }
}
