package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstname("Harish");
        owner1.setLastname("Renukunta");
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setFirstname("Anil");
        owner2.setLastname("Ravupudi");
        owner1.setId(2L);

        ownerService.save(owner1.getId(), owner1);
        ownerService.save(owner2.getId(), owner2);

        Vet vet1 = new Vet();
        vet1.setFirstname("Bhaskar Reddy");
        vet1.setLastname("Gomatam");
        vet1.setId(1L);

        Vet vet2 = new Vet();
        vet2.setFirstname("Siva");
        vet2.setLastname("Rachamarla");
        vet2.setId(2L);

        vetService.save(vet1.getId(), vet1);
        vetService.save(vet2.getId(), vet2);
    }
}
