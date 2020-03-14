package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name="vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="vet_specialities", joinColumns = @JoinColumn(name="vet_id"), inverseJoinColumns = @JoinColumn(name="speciality_id"))
    private Set<Speciality> specialities = new HashSet<>() ;
}
