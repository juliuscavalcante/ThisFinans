package com.programeiros.thisfinans.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codUser;
    private String userName;
    private String password;
    private String email;
    private TypeUser typeUser;
    private Date createDate;
    private Date updateDate;
}
