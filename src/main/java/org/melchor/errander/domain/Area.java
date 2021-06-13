package org.melchor.errander.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Area {

    @Id
    @GeneratedValue
    private Long id;

}
