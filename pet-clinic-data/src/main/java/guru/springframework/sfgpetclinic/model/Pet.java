package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Pet  extends BaseEntity {
    String name;
    PetType petType;
    LocalDate birthDate;
    Owner owner;
}
