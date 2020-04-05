package guru.springframework.sfgpetclinic.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="visits")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Visit extends BaseEntity implements Cloneable {

    @Column(name="visit_date")
    LocalDate date;

    @Column(name="description")
    String description;

    @ManyToOne
    @JoinColumn(name="pet_id")
    Pet pet;

    /*
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

     */

    public Visit clone(){
        Visit v1 = null;
        try {
            v1 = (Visit)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException("Exception when cloning. Exception msg:" + e.getMessage());
        }
        return v1;
    }
}
