package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
public class OwnerServiceMapTest {

    @Mock
    Map<Long, Owner> map;

    OwnerService ownerService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerService.save(Owner.builder().id(1L).firstname("Harish").lastname("Renukunta").build());
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testFindAll() {
    }

    @Test
    void testFindById() {
    }

    @Test
    void testSave() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testfindByLastName() {
        assertThat(ownerService.findByLastName("Renukunta").getFirstname())
                .isEqualTo("Harish");
    }

    @Test
    void testSave1() {
    }
}