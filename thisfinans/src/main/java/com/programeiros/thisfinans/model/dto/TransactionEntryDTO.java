package com.programeiros.thisfinans.model.dto;

import com.programeiros.thisfinans.model.entities.User;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1970751519617158088L;

    private Long id;
    private UUID cod;
    private BigDecimal amount;
    private Instant entryDate;
    private Instant creationDate;
    private Instant updateDate;
    private Long transactionId;
    private Long accountId;

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(cod);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof User) {
            return ((User) obj).getCod().equals(getCod());
        }
        return false;
    }
}
