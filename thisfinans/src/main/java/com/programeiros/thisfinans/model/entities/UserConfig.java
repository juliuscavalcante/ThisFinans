package com.programeiros.thisfinans.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "user_configs")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = -5353237608690444531L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_id", nullable = false)
    private Long id;

    @Column(name = "budget_closing_day", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Integer budgetClosingDay;

    @Column(name = "creation_date", nullable = false)
    private Instant creationDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fk")
    private User user;

}
