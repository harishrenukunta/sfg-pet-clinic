package guru.springframework.sfgpetclinic.services.map;


import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractCrudService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String name) {
        return map.values().stream()
            .filter( ow -> ow.getLastname().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }
}
