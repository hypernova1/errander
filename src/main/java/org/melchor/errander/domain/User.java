package org.melchor.errander.domain;

import lombok.Getter;
import org.melchor.errander.constant.UserGrade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Enumerated(EnumType.STRING)
    private UserGrade grade;

    @OneToMany
    private final List<Errand> errands = new ArrayList<>();

    @OneToMany
    private final Set<Area> areas = new HashSet<>();

}