package com.programeiros.thisfinans.model.dto;

import com.programeiros.thisfinans.model.entities.User;
import java.io.Serializable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class UserConfigDTO implements Serializable {
    private Long id;
    private Integer budgetClosingDay;
    private Instant createDate;
    private Instant updateDate;
    private User user;
}
