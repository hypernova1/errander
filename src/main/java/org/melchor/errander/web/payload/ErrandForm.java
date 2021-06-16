package org.melchor.errander.web.payload;

import lombok.Getter;

@Getter
public class ErrandForm {

    private String title;
    private String description;
    private Long categoryId;
    private Long areaId;

}
