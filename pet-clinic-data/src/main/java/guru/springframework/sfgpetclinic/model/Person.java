package guru.springframework.sfgpetclinic.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {
    @Column(name="first_name")
    String firstname;
    @Column(name="last_name")
    String lastname;

    public Person(final Long id, final String firstname, final String lastname){
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
