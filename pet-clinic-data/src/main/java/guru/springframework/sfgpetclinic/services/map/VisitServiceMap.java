package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractCrudService<Visit, Long> implements VisitService {

    @Override
    public Visit save(final Visit object){
//        if(object.getPet() == null || object.getPet().getId() == null){
//            throw new RuntimeException("Visit needs a Pet to save. So please provide Pet details");
//        }
        return super.save(object);
    }
}
