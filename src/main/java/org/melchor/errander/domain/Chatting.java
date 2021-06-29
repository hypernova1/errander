package org.melchor.errander.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Chatting extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Errand errand;

    @OneToMany
    private final List<ChattingMessage> messages = new ArrayList<>();

}
