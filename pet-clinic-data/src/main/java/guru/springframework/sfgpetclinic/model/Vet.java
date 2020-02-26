package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>() ;
}
