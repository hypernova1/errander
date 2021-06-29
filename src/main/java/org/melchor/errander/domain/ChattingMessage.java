package org.melchor.errander.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Entity
public class ChattingMessage {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @OneToOne
    private User sender;

    @OneToOne
    private User receiver;

}
