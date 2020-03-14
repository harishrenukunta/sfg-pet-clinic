package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name="pets")
public class Pet  extends BaseEntity {
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
}
