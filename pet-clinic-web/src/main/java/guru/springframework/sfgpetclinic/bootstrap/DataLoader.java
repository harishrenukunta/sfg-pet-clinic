package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        if(petService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = Owner.builder()
                .firstname("Harish")
                .lastname("Renukunta")
                .address("49 Maine Street")
                .city("Reading")
                .telephone("07460778740")
                .pets(new HashSet<>())
                .build();

        Owner owner2 = Owner.builder()
                .firstname("Anil").lastname("Ravupudi")
                .address("Rd no. 12 Banjara Hills").city("Hyderabad")
                .telephone("98480442340").build();

        ownerService.save(owner1);
        ownerService.save(owner2);

        /*
        Pet harishDogPet = new Pet();
        harishDogPet.setOwner(owner1);
        harishDogPet.setPetType(savedDogPetType);
        harishDogPet.setName("harishDog");
        harishDogPet.setBirthDate(LocalDate.now());
        */
         Pet harishDogPet = Pet.builder().petType(savedDogPetType).name("harishDog").birthDate(LocalDate.now()).owner(owner1).build();
        owner1.getPets().add(harishDogPet);
        log.info("Loaded pet for Harish owner...");

        Pet anilCatPet = new Pet();
        anilCatPet.setName("AnilCat");
        anilCatPet.setBirthDate(LocalDate.now());
        anilCatPet.setPetType(savedCatPetType);
        anilCatPet.setOwner(owner2);
        log.info("Loaded pet for Anil owner...");

        petService.save(harishDogPet);
        petService.save(anilCatPet);

        log.info("Loading Specialities....");
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        final Speciality savedRadiology = specialityService.save(radiology);

        final Speciality dentist = new Speciality();
        dentist.setDescription("dentist");
        final Speciality savedDentist = specialityService.save(dentist);

        Speciality surgeon = new Speciality();
        surgeon.setDescription("surgeon");
        final Speciality savedSurgeon = specialityService.save(surgeon);

        Vet vet1 = new Vet();
        vet1.setFirstname("Bhaskar Reddy");
        vet1.setLastname("Gomatam");
        vet1.getSpecialities().add(savedDentist);

        Vet vet2 = new Vet();
        vet2.setFirstname("Siva");
        vet2.setLastname("Rachamarla");
        vet2.getSpecialities().add(savedSurgeon);
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet1);
        vetService.save(vet2);

        Visit dogVisit = new Visit();
        dogVisit.setDate(LocalDate.of(2020,01,23));
        dogVisit.setDescription("Leg fracture");
        dogVisit.setPet(harishDogPet);
        visitService.save(dogVisit);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.of(2020, 02, 12));
        catVisit.setDescription("Indigestion");
        catVisit.setPet(anilCatPet);
        visitService.save(catVisit);

    }
}
