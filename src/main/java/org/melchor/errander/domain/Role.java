package org.melchor.errander.domain;

import lombok.Getter;
import org.melchor.errander.constant.RoleName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Role extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private RoleName name;
    
}
