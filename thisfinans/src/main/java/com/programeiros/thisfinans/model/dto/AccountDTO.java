package com.programeiros.thisfinans.model.dto;

import com.programeiros.thisfinans.model.entities.Account;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.enums.AccountType;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.*;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6331874124544418952L;

    private Long id;
    private UUID cod;
    private String name; //
    private AccountType type;
    private Boolean deleted;
    private User user;
    private Instant createDate;
    private Instant updateDate;
    private List<TransactionDTO> transactions;
    private List<TransactionEntryDTO> transactionEntries;


    public AccountDTO(Account entity){
        this.id = entity.getId();
        this.cod = entity.getCod();
        this.name = entity.getName();
        this.user = entity.getUser();
        this.deleted = entity.getDeleted();
        this.createDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();
        this.transactions = entity.getTransactions().stream().map(TransactionDTO::new).collect(Collectors.toList());
        this.transactionEntries = entity.getTransactionEntries().stream().map(TransactionEntryDTO::new).collect(Collectors.toList());
    }

    @PrePersist
    private void prePersist(){
        createDate = Instant.now();
        updateDate = Instant.now();
    }

    @PreUpdate
    private void preUpdate(){
        updateDate = Instant.now();
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
