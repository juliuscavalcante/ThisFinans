package com.programeiros.thisfinans.model.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "transaction_days")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TransactionDays that = (TransactionDays) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
