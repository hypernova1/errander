package org.melchor.errander.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
