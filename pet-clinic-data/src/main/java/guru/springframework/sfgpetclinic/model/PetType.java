package guru.springframework.sfgpetclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="types")
public class PetType extends BaseEntity implements Cloneable {
    @Column(name="name")
    String name;

    public PetType clone() throws CloneNotSupportedException {
        PetType pt1 = (PetType)super.clone();
        pt1.setName(this.getName());
        return pt1;

    }
}
