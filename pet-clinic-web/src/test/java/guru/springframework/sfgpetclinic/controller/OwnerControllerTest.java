package guru.springframework.sfgpetclinic.controller;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.springdatjpa.OwnerSDJpaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest{

    @Mock
    OwnerSDJpaService ownerService;

    @InjectMocks
    OwnerController controller;

    MockMvc mvc;

    Set<Owner> listOfOwners = new HashSet<>();

    @BeforeEach
    void setUp() {
        listOfOwners.add(Owner.builder().id(1L).firstname("Tanvi").city("Reading").build());
        listOfOwners.add(Owner.builder().id(3L).firstname("Varshith").city("Cambridge").build());
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listAllOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(listOfOwners);
        mvc.perform(MockMvcRequestBuilders.get("/owners/index.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("/owners/index"))
                .andExpect(model().attribute("owners", hasSize(2) ));
    }

    @Test
    void findOwner() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));
    }
}