package com.programeiros.thisfinans.model.dto;

import com.programeiros.thisfinans.model.enums.UserType;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
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

    private List<AccountDTO> accounts;
    private List<UserConfigDTO> userConfigs;

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
        if (obj instanceof UserDTO) {
            return ((UserDTO) obj).getCod().equals(getCod());
        }
        return false;
    }
}
