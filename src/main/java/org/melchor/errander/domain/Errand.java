package org.melchor.errander.domain;

import lombok.Getter;
import org.melchor.errander.constant.ErrandState;

import javax.persistence.*;

@Entity
@Table
@Getter
public class Errand extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private String category;

    @ManyToOne
    private User errander;

    @ManyToOne
    private User orderer;

    @Enumerated(EnumType.STRING)
    private ErrandState state;

    private Long tip;

}
