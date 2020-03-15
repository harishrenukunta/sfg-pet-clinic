package guru.springframework.sfgpetclinic.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
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
