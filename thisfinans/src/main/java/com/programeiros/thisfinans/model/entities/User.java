package com.programeiros.thisfinans.model.entities;




import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "usuario")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codUser;
    private String userName;
    private String password;
    private String email;
    private Date createDate;
    private Date updateDate;

    public User() {
    }

    public User(long id, String codUser, String userName, String password, String email, Date createDate) {
        this.id = id;
        this.codUser = codUser;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public String getCodUser() {
        return codUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", codUser='" + codUser + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
