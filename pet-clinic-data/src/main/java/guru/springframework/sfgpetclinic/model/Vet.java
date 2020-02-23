package guru.springframework.sfgpetclinic.model;

import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
public class Vet extends Person {

    private Set<Speciality> specialities;
}
