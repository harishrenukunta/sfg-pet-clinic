package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType("cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstname("Harish");
        owner1.setLastname("Renukunta");
        owner1.setAddress("49 Maine Street");
        owner1.setCity("Reading");
        owner1.setTelephone("07460778740");

        Pet harishDogPet = new Pet();
        harishDogPet.setOwner(owner1);
        harishDogPet.setPetType(savedDogPetType);
        harishDogPet.setName("harishDog");
        harishDogPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(harishDogPet);
        log.info("Loaded pet for Harish owner...");


        Owner owner2 = new Owner();
        owner2.setFirstname("Anil");
        owner2.setLastname("Ravupudi");
        owner2.setAddress("Rd no. 12 Banjara Hills");
        owner2.setCity("Hyderabad");
        owner2.setTelephone("98480442340");
        Pet anilCatPet = new Pet();
        anilCatPet.setName("AnilCat");
        anilCatPet.setBirthDate(LocalDate.now());
        anilCatPet.setPetType(savedCatPetType);
        anilCatPet.setOwner(owner2);
        log.info("Loaded pet for Anil owner...");


        ownerService.save(owner1);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstname("Bhaskar Reddy");
        vet1.setLastname("Gomatam");

        Vet vet2 = new Vet();
        vet2.setFirstname("Siva");
        vet2.setLastname("Rachamarla");

        vetService.save(vet1);
        vetService.save(vet2);
    }
}
