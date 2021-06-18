package org.melchor.errander.domain;

import lombok.*;
import org.melchor.errander.constant.ErrandStatus;
import org.melchor.errander.web.payload.ErrandForm;

import javax.persistence.*;

@Entity
@Table
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private ErrandStatus status;

    @OneToOne
    private Area area;

    private Long tip;

    @Builder
    public Errand(String title, String description, Category category, Area area, User ordered) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.area = area;
        this.ordered = ordered;
        this.status = ErrandStatus.WAIT;
    }

    public void update(ErrandForm errandForm, Category category) {
        this.title = errandForm.getTitle();
        this.description = errandForm.getDescription();
        this.status = errandForm.getStatus();
        this.category = category;
    }
}
