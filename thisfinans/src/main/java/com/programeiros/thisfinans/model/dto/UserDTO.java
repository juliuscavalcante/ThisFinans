package com.programeiros.thisfinans.model.dto;

import com.programeiros.thisfinans.model.entities.User;
import com.programeiros.thisfinans.model.enums.UserType;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
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
    private Instant creationDate;
    private Instant updateDate;

    private List<AccountDTO> accounts;
    private List<UserConfig> userConfigs;

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
