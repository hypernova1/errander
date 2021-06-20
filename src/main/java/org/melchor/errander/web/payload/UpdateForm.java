package org.melchor.errander.web.payload;

import lombok.Getter;
import org.melchor.errander.constant.ErrandStatus;

import javax.validation.constraints.NotBlank;

@Getter
public class UpdateForm {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

}
