package com.programeiros.thisfinans.model.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
@Entity
@Table(name = "transaction_days")
public class TransactionDays implements Serializable {
    @Serial
    private static final long serialVersionUID = -7036969324835011428L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_day_id")
    private Long id;
    @Column(name = "transaction_day", columnDefinition = "TINYINT", nullable = false)
    private Integer day;

    @ManyToOne
    @JoinColumn(name = "transaction_fk")
    private Transaction transaction;
}
