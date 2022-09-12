package com.programeiros.thisfinans.model.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
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
import lombok.Setter;

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

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

}
