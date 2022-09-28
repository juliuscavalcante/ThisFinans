package com.programeiros.thisfinans.model.dto;

import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.enums.AccountType;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityReference(alwaysAsId = true)
public class AccountDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6331874124544418952L;

    private Long id;
    private UUID cod;
    private String name;
    private AccountType type;
    private Boolean deleted;
    private User user;
    private Instant creationDate;
    private Instant updateDate;
    private List<TransactionDTO> transactions;
    private List<TransactionEntryDTO> transactionEntries;


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
