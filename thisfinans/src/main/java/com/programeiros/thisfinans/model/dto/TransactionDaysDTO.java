package com.programeiros.thisfinans.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDaysDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -75118087534273040L;
    private Long id;
    private Integer day;
    private Long transactionId;
}
