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
public class Vet extends Person implements Cloneable{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="vet_specialities", joinColumns = @JoinColumn(name="vet_id"), inverseJoinColumns = @JoinColumn(name="speciality_id"))
    private Set<Speciality> specialities = new HashSet<>() ;

    public Vet clone() throws CloneNotSupportedException {
        Vet v1 = (Vet)super.clone();
        v1.setFirstname(this.getFirstname());
        v1.setLastname(this.getLastname());
        v1.setId(this.getId());
        v1.setSpecialities(new HashSet<>(this.getSpecialities()));
        return v1;
    }
}
