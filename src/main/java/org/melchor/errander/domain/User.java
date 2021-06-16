package org.melchor.errander.domain;

import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.melchor.errander.constant.UserGrade;
import org.melchor.errander.web.payload.UpdateForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@SQLDelete(sql = "UPDATE user SET is_active = false WHERE id = ?")
@Where(clause = "is_active=1")
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

    @ManyToMany
    private final Set<Role> roles = new HashSet<>();

    private boolean isActive;

    public void update(UpdateForm updateForm) {
        this.name = updateForm.getName();
        this.password = updateForm.getPassword();
    }
}