package guru.springframework.sfgpetclinic.services.springdatjpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner owner;
    Owner harishOwner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).firstname("Ashish").lastname("Kamulu").address("Armur").city("Hyderabad").build();
        harishOwner = Owner.builder().id(2L).firstname("Harish").lastname("Renu").address("Berkshire").city("Reading").telephone("07460778740").build();
    }

    @Test
    void testfindByLastName() {
        when(ownerRepository.findByLastname(any())).thenReturn(owner);
        final Owner actualOwner = service.findByLastName("Kamulu");
        assertThat(actualOwner.getFirstname()).isEqualTo("Ashish");
        verify(ownerRepository).findByLastname(any());
    }

    @Test
    void testFindAll() {
        final List<Owner> listOfOwners = new ArrayList<>();
        listOfOwners.add(owner);
        listOfOwners.add(harishOwner);

        when(ownerRepository.findAll()).thenReturn(listOfOwners);

        assertThat(service.findAll().size()).isEqualTo(listOfOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        when(ownerRepository.save(any())).thenReturn(owner);
        assertThat(service.save(harishOwner).getFirstname()).isEqualTo(owner.getFirstname());
    }

    @Test
    void testFindById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(harishOwner));
        assertThat(service.findById(1L).getAddress()).isNotNull().isEqualTo(harishOwner.getAddress());
    }

    @Test
    void testFindByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThat(service.findById(1L)).isNull();
    }
    @Test
    void testDelete() {
        doNothing().when(ownerRepository).delete(any());
        assertThat(service.delete(harishOwner).getFirstname()).isEqualTo("Harish");
        verify(ownerRepository).delete(any());
    }
}