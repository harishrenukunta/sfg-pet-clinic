package guru.springframework.sfgpetclinic.model;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="owners")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Owner extends Person implements Cloneable {

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(final Long id, final String firstname, final String lastname, final String address, final String city, final String telephone, final Set<Pet> pets){
        super(id, firstname, lastname);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if(pets != null){
            this.pets = pets;
        }
    }

    public Owner clone() throws CloneNotSupportedException {
        final Owner o1 = (Owner)super.clone();
        o1.setFirstname(this.getFirstname());
        o1.setLastname(this.getLastname());
        o1.setAddress(this.getAddress());
        o1.setCity(this.getCity());
        o1.setTelephone(this.getTelephone());
        o1.setPets(new HashSet<>(this.getPets()));
        o1.setId(this.getId());
        return o1;
    }
}
