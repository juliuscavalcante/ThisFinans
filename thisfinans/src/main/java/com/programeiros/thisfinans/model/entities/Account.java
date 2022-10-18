package com.programeiros.thisfinans.model.entities;

import com.programeiros.thisfinans.model.dto.AccountDTO;
import com.programeiros.thisfinans.model.enums.AccountType;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = -568700344491669241L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long id;

    @Column(name = "account_cod", nullable = false)
    private UUID cod;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean deleted;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @OneToMany(mappedBy = "accountTransactions")
    @Setter(AccessLevel.NONE)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "accountEntries")
    @Setter(AccessLevel.NONE)
    private List<TransactionEntry> transactionEntries;

    public Account(AccountDTO accountDTO) {
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
