package org.melchor.errander.web.payload;

import lombok.Getter;
import org.melchor.errander.constant.ErrandStatus;

@Getter
public class ErrandForm {

    private String title;
    private String description;
    private Long categoryId;
    private Long areaId;
    private ErrandStatus status;

}
