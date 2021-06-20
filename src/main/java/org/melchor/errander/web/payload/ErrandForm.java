package org.melchor.errander.web.payload;

import lombok.Getter;
import lombok.Setter;
import org.melchor.errander.constant.ErrandStatus;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class ErrandForm {

    @NotBlank(message = "타이틀은 필수입니다.")
    private String title;
    @NotBlank(message = "설명은 필수입니다.")
    private String description;
    @NotBlank(message = "카테고리는 필수입니다.")
    private Long categoryId;
    @NotBlank(message = "지역 설정은 필수입니다.")
    private Long areaId;
    private ErrandStatus status;

}
