package guru.springframework.sfgpetclinic.services.map;


import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractCrudService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService){
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String name) {
        return map.values().stream()
            .filter( ow -> ow.getLastname().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Owner save(Owner object){
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach((pet) ->{
                   if(pet.getPetType() != null){
                       if(pet.getPetType().getId() == null){
                           pet.setPetType(petTypeService.save(pet.getPetType()));
                       }
                   }else{
                       throw new RuntimeException("Pet type is required.");
                   }

                   if(pet.getId() == null){
                       final Pet p = petService.save(pet);
                       pet.setId(p.getId());
                   }
                });
            }
            return super.save(object);
        }
        return null;

    }
}
