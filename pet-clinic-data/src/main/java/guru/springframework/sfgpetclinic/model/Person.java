package guru.springframework.sfgpetclinic.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {
    @Column(name="first_name")
    String firstname;
    @Column(name="last_name")
    String lastname;

    public Person setFirstname(final String fname){
        this.firstname = fname;
        return this;
    }

}
