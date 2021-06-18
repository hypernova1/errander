package org.melchor.errander.web.payload;

import lombok.Getter;
import org.melchor.errander.constant.ErrandStatus;

@Getter
public class UpdateForm {

    private String name;
    private String password;

}
