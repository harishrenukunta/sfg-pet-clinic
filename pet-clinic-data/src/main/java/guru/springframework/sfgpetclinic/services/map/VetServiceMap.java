package guru.springframework.sfgpetclinic.services.map;


import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractCrudService<Vet, Long>  implements VetService {
}