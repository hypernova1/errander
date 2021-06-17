package org.melchor.errander.web.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinForm {

    private String email;
    private String password;
    private String name;

}
