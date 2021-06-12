package org.melchor.errander.domain;

import lombok.Getter;

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

    @ManyToOne
    private User errander;

    @ManyToOne
    private User orderer;

}
