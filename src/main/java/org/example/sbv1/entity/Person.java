/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 10:16
 **/

package org.example.sbv1.entity;

import lombok.Data;
import org.hibernate.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasport_id")
    private Passport passport;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Phone> phones;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "person_role", joinColumns = @JoinColumn(name = "person_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private String email;
    private String password;
    private Boolean active;

    public boolean isActive() {
        return active;
    }


    public Person() {
    }

    public Person(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Person(int id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +

                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getFirstName()+"  "+ getLastName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
