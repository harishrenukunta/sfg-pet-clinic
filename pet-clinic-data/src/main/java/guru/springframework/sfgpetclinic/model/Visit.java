package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="visits")
public class Visit extends BaseEntity implements Cloneable {

    @Column(name="visit_date")
    private LocalDate date;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

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

    @Override
    public String toString(){
        return String.format("%s[id=%s desc=%s pet=%s]", this.getClass(), this.getId(), this.getDescription(), this.getPet().getName());
    }
}
