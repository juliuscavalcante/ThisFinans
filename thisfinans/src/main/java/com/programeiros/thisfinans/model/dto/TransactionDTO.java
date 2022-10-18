package com.programeiros.thisfinans.model.dto;

import com.programeiros.thisfinans.model.entities.Account;
import com.programeiros.thisfinans.model.entities.Transaction;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.enums.TransactionStatus;
import com.programeiros.thisfinans.model.enums.TransactionType;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8223704568073625252L;

    private Long id;
    private UUID cod;
    private String description;
    private TransactionType type;
    private TransactionStatus status;
    private BigDecimal amount;
    private Boolean deleted;
    private Instant transactionDate;
    private Instant createDate;
    private Instant updateDate;
    private Account accountTransactions;

    private List<TransactionEntryDTO> transactionEntries;

    public TransactionDTO(Transaction entity) {
        this.id = entity.getId();
        this.cod = entity.getCod();
        this.description = entity.getDescription();
        this.type = entity.getType();
        this.amount = entity.getAmount();
        this.deleted = entity.getDeleted();
        this.transactionDate = entity.getTransactionDate();
        this.createDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();
        this.accountTransactions = entity.getAccountTransactions();
        this.transactionEntries = entity.getTransactionEntries().stream().map(TransactionEntryDTO::new).collect(Collectors.toList());
    }

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
