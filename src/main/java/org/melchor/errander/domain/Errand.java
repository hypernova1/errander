package org.melchor.errander.domain;

import lombok.Builder;
import lombok.Getter;
import org.melchor.errander.constant.ErrandState;
import org.melchor.errander.web.payload.ErrandForm;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
public class Errand extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @OneToOne
    private Category category;

    @ManyToOne
    private User errander;

    @ManyToOne
    private User ordered;

    @Enumerated(EnumType.STRING)
    private ErrandState state;

    @OneToMany
    private final Set<Area> areas = new HashSet<>();

    private Long tip;

    @Builder
    public Errand(String title, String description, Category category, User ordered) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.ordered = ordered;
        this.state = ErrandState.WAIT;
    }

    public void update(ErrandForm errandForm) {
        this.title = errandForm.getTitle();
        this.description = errandForm.getDescription();
    }
}
