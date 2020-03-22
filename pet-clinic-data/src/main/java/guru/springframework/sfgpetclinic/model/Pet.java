package guru.springframework.sfgpetclinic.model;

import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="pets")
@Builder
public class Pet  extends BaseEntity implements Cloneable{
    @Column(name="name")
    String name;

    @ManyToOne
    @JoinColumn(name="type_id")
    PetType petType;

    @Column(name="birth_date")
    LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name="owner_id")
    Owner owner;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="pet")
    Set<Visit> visits = new HashSet<>();

    public Pet clone() throws CloneNotSupportedException {
        Pet p1 = null;

        p1 = (Pet)super.clone();
        p1.setPetType(this.getPetType());
        p1.setBirthDate(this.getBirthDate());
        p1.setName(this.getName());
        p1.setVisits(new HashSet<>(this.getVisits()));
        return p1;
    }
}
