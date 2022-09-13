package com.programeiros.thisfinans.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.enums.UserType;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.startup.UserConfig;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -224173681751858248L;

    private Long id;
    private UUID cod;
    private String username;
    private String password;
    private String email;
    private UserType type;
    private Boolean deleted;
    private Instant createdDate;
    private Instant updateDate;

    private List<AccountDTO> accounts;
    private List<UserConfig> userConfigs;

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.cod = entity.getCod();
        this.username = entity.getPassword();
        this.password = entity.getPassword();
        this.email = entity.getEmail();
        this.type = entity.getType();
        this.deleted = entity.getDeleted();
        this.createdDate = entity.getCreateDate();
        this.updateDate = entity.getUpdateDate();
        accounts = entity.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toList());
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
