package com.programeiros.thisfinans.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class TransactionEntry implements Serializable {

    @Serial
    private static final long serialVersionUID = -5722327047262350956L;

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_entry_id", nullable = false)
    private Long id;

    @Column(name = "transaction_entry_cod", nullable = false)
    private UUID cod;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "entry_date", nullable = false)
    private Instant entryDate;

    @Column(name = "creation_date")
    private Instant creationDate;

    @Column(name = "update_date", nullable = false)
    private Instant updateDate;

    @ManyToOne
    @JoinColumn(name = "transaction_fk")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "account_fk")
    private Account account;

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
