package org.melchor.errander.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;

    private String password;

    @OneToMany
    private List<Errand> errands;

}