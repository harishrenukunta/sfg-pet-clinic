package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(builderMethodName = "VetBuilder")
@Entity
@Table(name="vets")
public class Vet extends Person implements Cloneable{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="vet_specialities", joinColumns = @JoinColumn(name="vet_id"), inverseJoinColumns = @JoinColumn(name="speciality_id"))
    private Set<Speciality> specialities = new HashSet<>() ;

    public Vet(long id, String firstname, String lastname, final Set<Speciality> specialities) {
        super(id, firstname, lastname);
        this.specialities = specialities;
    }

    public Vet clone() throws CloneNotSupportedException {
        Vet v1 = (Vet)super.clone();
        v1.setFirstname(this.getFirstname());
        v1.setLastname(this.getLastname());
        v1.setId(this.getId());
        v1.setSpecialities(new HashSet<>(this.getSpecialities()));
        return v1;
    }
}
