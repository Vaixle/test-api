package com.vaixle.testapi.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@ApiModel(value = "Покупатель")
public class CustomerBaseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty("id покупателя")
    long id;

//    @ApiModelProperty("имя покупателя")
    String name;

//    @ApiModelProperty("email покупателя")
    String email;

//    @ApiModelProperty("адрес покупателя")
    String address;
}
