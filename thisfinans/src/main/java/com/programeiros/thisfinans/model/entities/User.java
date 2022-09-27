package com.programeiros.thisfinans.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.programeiros.thisfinans.model.enums.UserType;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 2694266116540907321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_cod", nullable = false)
    private UUID cod;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean deleted;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "update_date")
    private Instant updateDate;

    @OneToMany(mappedBy = "user")
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private List<Account> accounts;

    @OneToOne(mappedBy = "user")
    private UserConfig userConfigs;

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
