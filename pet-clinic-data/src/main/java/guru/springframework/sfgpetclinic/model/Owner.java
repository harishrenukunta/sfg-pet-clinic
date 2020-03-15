package guru.springframework.sfgpetclinic.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Entity
@Table(name="owners")
public class Owner extends Person implements Cloneable {

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public Owner setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Owner setCity(String city) {
        this.city = city;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Owner setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public Owner setPets(Set<Pet> pets) {
        this.pets = pets;
        return this;
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
