package com.programeiros.thisfinans.model.entities;

import com.programeiros.thisfinans.model.entities.ENUM.TypeTransactions;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Transactions implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userAccount;
    @NonNull
    private TypeTransactions typeTransactions;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal amount;
    @NonNull
    private Boolean status;
    @NonNull
    private Instant transactionDate;
    @NonNull
    private Instant createDate;
    @NonNull
    private Instant updateDate;

    @ManyToOne
    @JoinColumn(name = "account_fk")
    private Account account;


}
