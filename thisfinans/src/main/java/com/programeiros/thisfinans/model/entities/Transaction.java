package com.programeiros.thisfinans.model.entities;

import com.programeiros.thisfinans.model.enums.TransactionStatus;
import com.programeiros.thisfinans.model.enums.TransactionType;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Transaction implements Serializable {

    @Serial
    private static final long serialVersionUID = 534117576380387880L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;

    @Column(name = "transaction_cod", nullable = false)
    private UUID cod;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean deleted;

    @Column(name = "transaction_date", nullable = false)
    private Instant transactionDate;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "update_date", nullable = false)
    private Instant updateDate;

    @ManyToOne
    @JoinColumn(name = "account_fk")
    private Account account;

    @OneToMany(mappedBy = "transaction", fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    private List<TransactionEntry> transactionEntriesId;

    @OneToMany(mappedBy = "transaction")
    @Setter(AccessLevel.NONE)
    private List<TransactionDays> transactionDays;

    @PrePersist
    private void prePersist(){
        deleted = Boolean.FALSE;
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
