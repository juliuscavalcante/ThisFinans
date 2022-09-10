package com.programeiros.thisfinans.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Table(name = "transaction_entries")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TransactionEntries implements Serializable {

    @Serial
    private static final long serialVersionUID = -5722327047262350956L;

    @NonNull
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private UUID cod;
    @NonNull
    private BigDecimal amount;
    @NonNull
    private Instant entriesDate;
    @NonNull
    private Instant createDate;

    private Instant updateDate;

    @ManyToOne
    @JoinColumn(name = "transaction_fk")
    private Transactions transactions;

    @ManyToOne
    @JoinColumn(name = "account_fk")
    private Account accountEntries;

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
