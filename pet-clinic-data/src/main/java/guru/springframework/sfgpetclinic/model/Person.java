package guru.springframework.sfgpetclinic.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {
    String firstname;
    String lastname;

}
