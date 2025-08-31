package com.luise.ecommer.infrastructure.persistence;

import com.luise.ecommer.infrastructure.persistence.embeddables.DateAudit;
import com.luise.ecommer.infrastructure.persistence.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 120)
    private String lastName;
    @Column(name = "email")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}",//valid from 2 characters or more
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "this  email is not correct")
    private String email;
    @Column(name = "password", nullable = false, length = 250)
    private String password;
    @Column(name = "phone", nullable = false, length = 60)
    private String phone;
    @Column(name = "address", nullable = false, length = 60)
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status; // es un enum
    @Embedded
    private DateAudit dateAudit;

    //relation
    @ManyToMany
    @JoinTable(name = "user_rol",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RolJpaEntity> roles = new HashSet<>();
}
