package guru.springframework.sfgpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="specialities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Speciality extends BaseEntity implements Cloneable {

    @Column(name="description")
    private String description;

    /*
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     */

    public Speciality clone() throws CloneNotSupportedException {
        Speciality sp1 = (Speciality)super.clone();
        sp1.setDescription(this.getDescription());
        return sp1;
    }
}
