package com.rouvsen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "urbanite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Urbanite implements Serializable {

    @Id
    @SequenceGenerator(
            name = "urbanite_sequence",
            sequenceName = "urbanite_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "urbanite_sequence"
    )
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @OneToMany
    @JoinColumn(name = "urbanite_address_id")
    private List<Address> addresses;

}
