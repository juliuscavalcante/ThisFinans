package com.programeiros.thisfinans.exceptions.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDTO {

    private Date timestamp;
    private Integer status;
    private String code;
    private Set<ErrorDTO> errors;

}
