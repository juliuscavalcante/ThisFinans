package com.programeiros.thisfinans.model.entities;

import com.programeiros.thisfinans.model.entities.ENUM.TypeAccount;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NonNull
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String accountCod;
    @NonNull
    private String name;
    @NonNull
    private TypeAccount typeAccount;
    @NonNull
    private Boolean status;
    @NonNull
    private Instant createDate;
    @NonNull
    private Instant updateDate;


    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @OneToMany(mappedBy = "account")
    @Setter(AccessLevel.NONE)
    List<Transactions> Transactions = new ArrayList<>();
}

